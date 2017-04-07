package com.netease.activeandroidtest;

import android.app.Application;

import com.netease.activeandroid.ActiveAndroidHelper;

/**
 * Created by xiejiantao on 2017/4/5.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroidHelper.init(this);

    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroidHelper.dispose();
    }
}
