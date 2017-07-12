package com.example.susancarrera.susan2017summer;

import android.support.v7.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.susancarrera.susan2017summer.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Quiz5Activity extends BaseActivity implements
        View.OnTouchListener {


    private GestureDetector gestureDetector;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;


    @BindView(R.id.activity_quiz5_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this, new Quiz5Activity.simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
//                if(x2>x1) {

//                    // R > L
//                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", x1-360, x2);
//                    animator.start();
//                    shortToast("Swipe from R to L");
//                }
//
//                if (x2<x1) {
//                    //L > R
//                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", x1, x2+320);
//                    animator.start();
//                    shortToast("Swipe from Left to Right");
//
//                }



                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();

                if (x1<x2) {
                    //L > R
                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", x1, x2);
                    animator.start();
                    shortToast("Swipe from Left to Right");

               }
                if(x1>x2) {

                    // R > L
                    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", x1, x2);
                    animator.start();
                    shortToast("Swipe from right to left");
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", 0, distanceX);
            animator.start();
            UtilLog.d("Gesture", "OnScroll");
            UtilLog.d("Gesture", "distanceX " + distanceX);
            UtilLog.d("Gesture", "distanceY " + distanceY);
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }






}
