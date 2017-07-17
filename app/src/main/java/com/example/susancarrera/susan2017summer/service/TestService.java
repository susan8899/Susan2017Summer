package com.example.susancarrera.susan2017summer.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.example.susancarrera.susan2017summer.util.UtilLog;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by SusanCarrera on 7/17/17.
 */

public class TestService extends Service {
    private Timer timer = new Timer();
    private int update = 0;
    public static final String UPDATE = "update";
    public static final String ACTION = "TestAction";




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String value = intent.getStringExtra("Service");
        if(value.equals("Start")){
            timer.schedule(new UpdateTask(),0,2000);
        }else if(value.equals("Stop")){
            timer.cancel();
        }



        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class UpdateTask extends TimerTask{
        public void run(){
            Intent intent = new Intent();
            intent.setAction(ACTION); //necessary

            intent.putExtra(UPDATE,++update);
            sendBroadcast(intent);
            UtilLog.d("Service",update+"");

        }
    }


}
