package com.criticalblue.reactnative;

import android.app.Application;

import java.io.IOException;
import java.io.InputStream;

import com.facebook.react.modules.network.OkHttpClientProvider;

public class PinnedApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        InputStream is;
        try {
            is = getAssets().open("fetch-config.json");
        } catch (IOException ex) {
            is = null;
        }

        OkHttpClientProvider.setOkHttpClientFactory(new PinnedClientFactory(is));

        try {
            if (is != null) is.close();
        } catch (IOException ex) {
            is = null;
        }
    }
}
