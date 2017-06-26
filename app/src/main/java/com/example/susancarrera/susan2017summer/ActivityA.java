package com.example.susancarrera.susan2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SusanCarrera on 6/19/17.
 */

public class ActivityA extends BaseActivity {
    /*to use showtoast(), change superclass to BaseActivity*/

/*everytime you click, the word 'click' appears(needs a matching test id)*//*
    @OnClick(R.id.test)
    public void click(View v){
        Toast.makeText(this, "You clicked Something", Toast.LENGTH_SHORT).show();
    }*/




    @OnClick(R.id.activity_a_button)
    public void activityAButton(View v){
    showToast("ActivityA");
    }
    @OnClick(R.id.activity_b_button)
    public void activityBButton(View v){
        showToast("ActivityB");
    }
    @OnClick(R.id.activity_c_button)
    public void activityCButton(View v){
        showToast("ActivityC");
    }
    @OnClick(R.id.activity_d_button)
    public void activityDButton(View v){
        showToast("ActivityD");
    }


    public void goToActivityB (View view){
        Intent intent = new Intent (this, ActivityB.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
        showToast("onCreate");
    }



   /* @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        showToast("onNewIntent");
    }*/

   
}

