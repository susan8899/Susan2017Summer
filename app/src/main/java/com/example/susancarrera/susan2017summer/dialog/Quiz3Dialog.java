package com.example.susancarrera.susan2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.susancarrera.susan2017summer.BaseActivity;
import com.example.susancarrera.susan2017summer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by SusanCarrera on 7/9/17.
 */

public class Quiz3Dialog extends Dialog{







    private final ICustomDialogListener listener;

    public interface ICustomDialogListener{
        public void onCancelClicked(String msg);
        public void onOkClicked(String msg);
    }



    @OnClick(R.id.dialog_quiz3_Cancel)
    public void cancel(View v){
        cancel();
    }


    private int checkedID = 0;


    @BindView(R.id.Quiz3_dialog_rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.dialog_quiz3_ok)
    public void ok(View v){


        switch (checkedID) {

            case R.id.quiz3_yes:
                listener.onOkClicked("Yes");
                cancel();
                break;
            case R.id.quiz3_No:
                listener.onOkClicked("No");
                cancel();
                break;
            case R.id.quiz3_exit:
                listener.onOkClicked("You clicked Exit");
                cancel();
                System.exit(0);
                break;
            default:
        }
    }



    public Quiz3Dialog(@NonNull Context context, ICustomDialogListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.dialog_quiz3);
        ButterKnife.bind(this);
        this.listener = listener;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_quiz3);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;



            }
        });
    }


}
