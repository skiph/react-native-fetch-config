package com.example;

import com.facebook.react.ReactActivity;
import android.os.Bundle;

import com.facebook.react.modules.network.OkHttpClientProvider;

import com.criticalblue.reactnative.PinnedClientFactory;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "example";
    }
}
