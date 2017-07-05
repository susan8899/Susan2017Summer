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
import com.example.susancarrera.susan2017summer.audio.BaseBean;
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
//        Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        String bs = bundle.getString("StringBundle");
        int bi = bundle.getInt("IntegerBundle");
        BaseBean bean = (BaseBean)bundle.getSerializable("Object");
        shortToast(bean.getName());
//        shortToast(bs);
//        shortToast("Integer is:" +bi);
//        String s = intent.getStringExtra("StringInfo"); //String is an object so it doesnt need a default value
//        int i = intent.getIntExtra("IntegerInfo",0);    //int is a raw value so it cant be null.thats what the 0 is for, its the default value
//        shortToast(s);
        //shortToast(String.valueOf(i) );  //these 2 are the same
        //shortToast(i+"");
        //shortToast("Integer is:" +i);

    }


    //this is to update the activity
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


