package com.bpc.nopphon.bpc;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;


public class UI_select extends Activity implements View.OnTouchListener {

    private RelativeLayout baseLayout;

    private int previousFingerPosition = 0;
    private int baseLayoutPosition = 0;
    private int defaultViewHieght;

    private boolean isClosing = false;
    private boolean isScrollingUp = false;
    private boolean isScrollingDown = false;

    public static final String BPC_UI = "UI_Type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_select);
        baseLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        baseLayout.setOnTouchListener(this);
    }

    public boolean onTouch(View view, MotionEvent event) {
        final int Y = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                defaultViewHieght = baseLayout.getHeight();
                previousFingerPosition = Y;
                baseLayoutPosition = (int) baseLayout.getY();
                break;

            case MotionEvent.ACTION_UP:
                if (isScrollingUp) {
                    baseLayout.setY(0);
                    isScrollingUp = false;
                }

                if (isScrollingDown) {
                    baseLayout.setY(0);
                    baseLayout.getLayoutParams().height = defaultViewHieght;
                    baseLayout.requestLayout();
                    isScrollingDown = false;
                }
                break;

            case MotionEvent.ACTION_MOVE:

                int currentYPosition = (int) baseLayout.getY();

                if (!isClosing) {
                    if (previousFingerPosition > Y) {
                        if (!isScrollingUp) {
                            isScrollingUp = true;
                        }
                    }

                    if (baseLayout.getHeight() < defaultViewHieght) {
                        baseLayout.getLayoutParams().height = baseLayout.getHeight() - (Y - previousFingerPosition);
                        baseLayout.requestLayout();
                    } else {
                        if ((baseLayoutPosition - currentYPosition) > defaultViewHieght / 4) {
                            closeUpAndDismissDialog(currentYPosition);
                            return true;
                        }
                    }
                    baseLayout.setY(baseLayout.getY() + (Y - previousFingerPosition));
                } else {
                    if (!isScrollingDown) {
                        isScrollingDown = true;
                    }

                    if (Math.abs(baseLayoutPosition - currentYPosition) > defaultViewHieght / 2) {
                        closeDownAndDismissDialog(currentYPosition);
                        return true;
                    }
                    baseLayout.setY(baseLayout.getY() + (Y - previousFingerPosition));
                    baseLayout.getLayoutParams().height = baseLayout.getHeight() - (Y - previousFingerPosition);
                    baseLayout.requestLayout();
                }

                previousFingerPosition = Y;
                break;
        }
        return true;
    }

    public void closeUpAndDismissDialog(int currentPosition){
        isClosing = true;
        ObjectAnimator positionAnimatior = ObjectAnimator.ofFloat(baseLayout, "y",currentPosition,-baseLayout.getHeight());
        positionAnimatior.setDuration(300);
        positionAnimatior.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        positionAnimatior.start();
    }

    public void closeDownAndDismissDialog(int currentPosition)
    {
        isClosing=true;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHieght = size.y;
        ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(baseLayout, "y",currentPosition,screenHieght+baseLayout.getHeight());
        positionAnimator.setDuration(300);
        positionAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        positionAnimator.start();
    }

    public void ui1onClick (View view)
    {
        final SharedPreferences.Editor UI_Edit = getSharedPreferences(BPC_UI,MODE_PRIVATE).edit();
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        UI_Edit.putInt(BPC_UI, 1);
        UI_Edit.apply();
        startActivity(i);
    }

    public void ui2onClick (View view)
    {
        final SharedPreferences.Editor UI_Edit = getSharedPreferences(BPC_UI,MODE_PRIVATE).edit();
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        UI_Edit.putInt(BPC_UI, 2);
        UI_Edit.apply();
        startActivity(i);
    }
}
