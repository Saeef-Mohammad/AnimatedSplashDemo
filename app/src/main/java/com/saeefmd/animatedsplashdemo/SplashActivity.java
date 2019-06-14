package com.saeefmd.animatedsplashdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    //private int longAnimationDuration;

    private View robotIv;
    private View welcomeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        robotIv = findViewById(R.id.robot_iv);
        welcomeTv = findViewById(R.id.welcome_tv);

        //longAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime );

        crossFade();

        /* New Handler to start the Main Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Main Activity. */
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void crossFade() {

        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        robotIv.setAlpha(0f);
        robotIv.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        robotIv.animate()
                .alpha(1f)
                .setDuration(1800)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        welcomeTv.setVisibility(View.VISIBLE);
                    }
                });

    }

}
