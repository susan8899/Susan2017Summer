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

public class ActivityC extends BaseActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        ButterKnife.bind(this);
        showToast("onCreate");
    }



    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        showToast("onNewIntent");
    }
        /*everytime you click, the word 'click' appears bc it matches the id with the id in XML file*/

    /*@OnClick(R.id.test)
    public void click(View v){
        Toast.makeText(this, "You clicked Something", Toast.LENGTH_SHORT).show();
    }*/
}
