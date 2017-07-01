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


    


    @OnClick(R.id.activity_a_button)
    public void activityAButton(View v){
    Toast.makeText(this,"ActivityA", Toast.LENGTH_SHORT).show();

    }

    


    @OnClick(R.id.activity_c_button)
    public void activityCButton(View v){

        /*showToast("ActivityC");*/
    }
    @OnClick(R.id.activity_d_button)
    public void activityDButton(View v){

        /*showToast("ActivityD");*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){/*    @OnClick(R.id.activity_b_button)
    public void activityBButton(View v){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle", "onCreate");
        list.add(new RedFragment());
        list.add(new GreenFragment());
        list.add(new BlueFragment());
        BaseViewPagerAdapter pagerAdapter =
                new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);

        *//*showToast("ActivityB");*//*
    }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);


    }

  




    

   
}

