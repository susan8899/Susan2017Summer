package com.example.susancarrera.susan2017summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.susancarrera.susan2017summer.dialog.Quiz3Dialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.q3_bt)
    public void Quiz3Button(View v){

        Quiz3Dialog customQuiz3Dialog =
                new Quiz3Dialog(this, new Quiz3Dialog.ICustomDialogListener(){


                    @Override
                    public void onCancelClicked(String msg) {
                        showToast(msg);


                    }

                    @Override
                    public void onOkClicked(String msg) {
                        showToast(msg);

                    }

                });
        customQuiz3Dialog.setCanceledOnTouchOutside(true);
        customQuiz3Dialog.show();


    }


}
