package com.frame.library.core;

import android.app.Application;
import com.frame.library.net.HttpClient;

public class Library {

    private Application context;
    private static Library instance;

    private Library() {
    }

    public static Library getInstance() {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) {
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public <T> T init(Application app, String url, Class<T> service) {
        this.context = app;
        return HttpClient.getInstance().getApiService(url, service);
    }


    public Application getContext() {
        return context;
    }
}
