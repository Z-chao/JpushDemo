package com.example.z_chao.jpushdemo;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Z-chao on 2017/3/8 22:10
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }
}
