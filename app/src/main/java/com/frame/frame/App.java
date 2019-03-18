package com.frame.frame;

import android.app.Application;

import com.frame.library.Library;


public class App extends Application {

    private AppService appService;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appService = Library.getInstance().init(this, AppService.BASE_URL, AppService.class);
    }

    public AppService getApi() {
        return appService;
    }

    public static App getInstance() {
        return instance;
    }
}
