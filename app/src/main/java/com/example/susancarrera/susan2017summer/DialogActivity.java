package com.example.susancarrera.susan2017summer;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {
    private int checkedID =0;

    @BindView(R.id.activity_dialog_rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.activity_dialog_ok)
    public void ok(View v) {
        switch (checkedID){

            case R.id.activity_dialog_rb1:
                break;
            case R.id.activity_dialog_rb2:
                break;
            case R.id.activity_dialog_rb3:
                break;
            case R.id.activity_dialog_rb4:
                break;
            case R.id.activity_dialog_rb5:
                break;
            case R.id.activity_dialog_rb6:
                break;
            case R.id.activity_dialog_rb7:
                break;
            case R.id.activity_dialog_rb8:

;                break;
            default:
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                shortToast("you chose: " +checkedId);


            }
        });
    }
}
