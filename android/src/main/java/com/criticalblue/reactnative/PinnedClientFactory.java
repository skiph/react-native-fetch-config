package com.criticalblue.reactnative;

import android.util.Log;

import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class PinnedClientFactory implements OkHttpClientFactory {
    private static final String TAG = "PinnedClientFactory";

    private String json;

    public PinnedClientFactory(InputStream is) {
        json = null;
        if (is != null) {
            try {
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                json = null;
            }
        }
    }

    @Override
    public OkHttpClient createNewNetworkModuleClient() {
        CertificatePinner.Builder pinBuilder = new CertificatePinner.Builder();

        try {
            JSONObject top = new JSONObject(json);
            JSONObject domains = top.getJSONObject("domains");

            Iterator<?> keys = domains.keys();
            while (keys.hasNext()) {
                String key = (String)keys.next();
                JSONArray pinArray = domains.getJSONObject(key).getJSONArray("pins");
                for (int i = 0; i < pinArray.length(); i++) {
                    String pin = pinArray.getString(i);
                    pinBuilder.add(key, pin);
                }
            }
        } catch (final JSONException e) {
            Log.e(TAG, "Pinning Configuration error: client is UNPROTECTED");
            pinBuilder = null;
        }
        CertificatePinner pinner = pinBuilder != null ? pinBuilder.build() : null;

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .writeTimeout(0, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer())
                .certificatePinner(pinner);
        return OkHttpClientProvider.enableTls12OnPreLollipop(client).build();
    }
}

// end of file
