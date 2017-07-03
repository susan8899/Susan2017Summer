package com.example.susancarrera.susan2017summer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.susancarrera.susan2017summer.R;

/**
 * Created by SusanCarrera on 7/3/17.
 */

public class CustomDialog extends Dialog {
    public CustomDialog(@NonNull Context context){
        super(context);
        setContentView(R.layout.dialog_custom);
    }
}
