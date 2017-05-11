package com.zhoumushui.zygotevector;

import android.app.Application;

import com.zhoumushui.zygotevector.util.MyUncaughtExceptionHandler;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyUncaughtExceptionHandler myUncaughtExceptionHandler =
                MyUncaughtExceptionHandler.getInstance();
        myUncaughtExceptionHandler.init(getApplicationContext());

    }
}
