package com.kennyyou.project_1;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

//Needed to print images
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}