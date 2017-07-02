package com.example.susancarrera.susan2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SusanCarrera on 6/26/17.
 */

public class ActivityB extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        showToast("onCreate");

    }
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        showToast("onNewIntent");
    }




    @OnClick(R.id.activity_b_to_a)
    public void activityAButton(View v){
        Toast.makeText(this,"ActivityA", Toast.LENGTH_SHORT).show();
        goToActivity(ActivityA.class);

    }

    @OnClick(R.id.activity_b_to_b)
    public void activityBButton(View v){

        showToast("ActivityB");
        goToActivity(ActivityB.class);
    }


    @OnClick(R.id.activity_b_to_c)
    public void activityCButton(View v){

        showToast("ActivityC");
        goToActivity(ActivityC.class);
    }

    @OnClick(R.id.activity_b_to_d)
    public void activityDButton(View v){

        showToast("ActivityD");
        goToActivity(ActivityD.class);
    }


}



