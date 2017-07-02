package com.example.susancarrera.susan2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.susancarrera.susan2017summer.adapter.BaseViewPagerAdapter;
import com.example.susancarrera.susan2017summer.fragment.BlueFragment;
import com.example.susancarrera.susan2017summer.fragment.GreenFragment;
import com.example.susancarrera.susan2017summer.fragment.RedFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SusanCarrera on 6/19/17.
 */

public class ActivityA extends BaseActivity {
    private ArrayList<Fragment> list;
    /*to use showtoast(), change superclass to BaseActivity*/

/*everytime you click, the word 'click' appears(needs a matching test id)*//*
    @OnClick(R.id.test)
    public void click(View v){
        Toast.makeText(this, "You clicked Something", Toast.LENGTH_SHORT).show();
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        showToast("NewActivityA");
        ButterKnife.bind(this);

    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        showToast("onNewIntent");
    }


    @OnClick(R.id.activity_a_button)
    public void activityAButton(View v){
    Toast.makeText(this,"ActivityA", Toast.LENGTH_SHORT).show();
        goToActivity(ActivityA.class);
    }

    @OnClick(R.id.activity_b_button)
    public void activityBButton(View v){

        showToast("ActivityB");
        goToActivity(ActivityB.class);
    }


    @OnClick(R.id.activity_c_button)
    public void activityCButton(View v){

        showToast("ActivityC");
        goToActivity(ActivityC.class);
    }

    @OnClick(R.id.activity_d_button)
    public void activityDButton(View v){

        showToast("ActivityD");
        goToActivity(ActivityD.class);
    }







    

   
}

