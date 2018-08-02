
package com.criticalblue.reactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class RNFetchClientModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNFetchClientModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    //OkHttpClientProvider.setOkHttpClientFactory(new PinnedClientFactory());
  }

  @Override
  public String getName() {
    return "RNFetchClient";
  }

  @ReactMethod
  public void replaceClient() {
    // CertificatePinner certificatePinner = new CertificatePinner.Builder()
    //   .add("demo-server.approovr.io", "sha256/Xq+Uj+2TYMg13txh1pXW0/VLAkonU3TnoPr5hfxPXXX=")
    //   //.add("*.approovr.io", "sha256/oq+Uj+2TYMg13txh1pXW0/VLAkonU3TnoPr5hfxPZVc=")
    //   //.add("*.approovr.io", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
    //   .build();

    // OkHttpClient client =  OkHttpClientProvider.enableTls12OnPreLollipop(
    //   new OkHttpClient.Builder()
    //     .connectTimeout(0, TimeUnit.MILLISECONDS)
    //     .readTimeout(0, TimeUnit.MILLISECONDS)
    //     .writeTimeout(0, TimeUnit.MILLISECONDS)
    //     .certificatePinner(certificatePinner)
    //     .cookieJar(new ReactCookieJarContainer())
    // ).build();

    // OkHttpClientProvider.replaceOkHttpClient(client);

    //OkHttpClientProvider.replaceOkHttpClient(null);
    
    //OkHttpClientProvider.setOkHttpClientFactory(new PinnedClientFactory());
  }
}
