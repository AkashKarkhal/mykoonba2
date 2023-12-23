package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.VideoView;

public class splashscreen extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        logo=findViewById(R.id.splashlogo);

        int screenHeight = getResources().getDisplayMetrics().heightPixels;

        // Create a translation animation for the ImageView
        ObjectAnimator logoAnimator = ObjectAnimator.ofFloat(logo, "translationY", screenHeight / 2f - logo.getHeight() / 2f, 0);
        logoAnimator.setDuration(800); // Animation duration in milliseconds
        // Use decelerate interpolator
        logoAnimator.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this, onboardingpage.class);
                startActivity(intent);
                finish();
            }

        },3000);


    }
}