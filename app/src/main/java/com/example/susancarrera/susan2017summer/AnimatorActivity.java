package com.example.susancarrera.susan2017summer;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.example.susancarrera.susan2017summer.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorActivity extends BaseActivity {

    private ValueAnimator repeatAnimator;

    @OnClick(R.id.animator_trans)
    public void trans(){
        ObjectAnimator animator =
                ObjectAnimator.ofFloat(tv, "translationY", 0, 120); //translationY
        animator.setDuration(2000);
        animator.start();
    }

    @OnClick(R.id.animator_scale)
    public void scale(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "scaleX", 0, 3, 1, 5,1); //scaleY
        animator.setDuration(5000);
        animator.start();
    }

    @OnClick(R.id.animator_color)
    public void color(){
        ObjectAnimator animator =
                ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        animator.setDuration(8000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }

    @OnClick(R.id.animator_char)
    public void charFAnim(){
        ValueAnimator animator =
                ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character ('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char)animation.getAnimatedValue();
                tv.setText(String.valueOf(text));
            }
        });
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    @OnClick(R.id.animator_alpha)
    public void alpha(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1);
        animator.setDuration(2000);
        animator.start();
    }

    @OnClick(R.id.animator_rotation)
    public void rotation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "rotationY", 0,360,0 ); //rotationX
        animator.setDuration(4000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(2);
        animator.start();
    }



    @OnClick(R.id.animator_bt_start)
    public void startAnimator(){
        repeatAnimator = doAnimatorListener();
        repeatAnimator.setStartDelay(3000);
        repeatAnimator.start();
    }


    @OnClick(R.id.animator_bt_stop)
    public void cancelAnimator(){
        repeatAnimator.cancel();
        repeatAnimator.removeAllListeners();
        repeatAnimator.removeAllUpdateListeners();
    }


    @BindView(R.id.animator_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                shortToast("Click");
            }
        });
    }

    private ValueAnimator doAnimatorListener(){
      ValueAnimator animator = ValueAnimator.ofInt(0,400);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator animation){
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue, tv.getRight(), curValue+tv.getHeight());
            }
        });

        animator.addListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationStart(Animator animation){
                shortToast("Started");
                UtilLog.d("Susan","animation start");
            }
            @Override
            public void onAnimationEnd(Animator animation){
                shortToast("Ended");
                UtilLog.d("Susan", "animation end");
            }
            @Override
            public void onAnimationCancel(Animator animation){
                shortToast("Cancel");
                UtilLog.d("Susan", "animation cancel");
            }
            @Override
            public void onAnimationRepeat(Animator animation){
                shortToast("Repeated");
                UtilLog.d("Susan","animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(2);
        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(2000);
        return animator;
    }

    private class CharEvaluator implements TypeEvaluator<Character>{
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue){
            int startInt = (int)startValue;
            int endInt = (int)endValue;
            int curInt = (int)(startInt + fraction *(endInt-startInt));
            char result = (char)curInt;
            return result;
        }
    }



    public class ArgbEvaluator implements TypeEvaluator{
        public Object evaluate(float fraction, Object startValue, Object endValue){
            int startInt = (Integer) startValue;
            int startA = (startInt >> 24);
            int startR = (startInt >> 16) & 0xff;
            int startG = (startInt >> 8) & 0xff;
            int startB = startInt & 0xff;

            int endInt = (Integer) endValue;
            int endA = (endInt >> 24);
            int endR = (endInt >> 16) & 0xff;
            int endG = (endInt >> 8) & 0xff;
            int endB = endInt & 0xff;

            return (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                    (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                    (int)((startG + (int)(fraction * (endG - startG))) << 8)  |
                    (int)((startB + (int)(fraction * (endB - startB))));
        }
    }






}


