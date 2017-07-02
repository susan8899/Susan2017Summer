package com.example.susancarrera.susan2017summer;

import android.app.Application;

import com.example.susancarrera.susan2017summer.util.UtilLog;

/**
 * Created by SusanCarrera on 7/1/17.
 */

public class SusanApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }
}
