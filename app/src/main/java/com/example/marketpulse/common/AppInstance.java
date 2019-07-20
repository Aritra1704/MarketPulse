package com.example.marketpulse.common;

import android.app.Application;

import com.example.marketpulse.modules.AppComponent;
import com.example.marketpulse.modules.DaggerAppComponent;
import com.example.marketpulse.modules.RetrofitModule;

public class AppInstance extends Application {

    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().retrofitModule(new RetrofitModule()).build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
