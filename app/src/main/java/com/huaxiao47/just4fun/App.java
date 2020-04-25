package com.huaxiao47.just4fun;

import android.app.Application;


public class App extends Application  {

    private static App appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

    //get global context
    public static App getAppContext() {
        return appContext;
    }

}
