package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.VideoView;

public class splashscreen extends AppCompatActivity {
    ImageView logo;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String FIRST_TIME_KEY = "firstTime";
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
//                Intent intent = new Intent(splashscreen.this, onboardingpage.class);
//                startActivity(intent);
//                finish();



                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                boolean firstTime = settings.getBoolean(FIRST_TIME_KEY, true);

                if (firstTime) {
                    // The app is opened for the first time
                    // Show the special activity

                    Intent firstTimeIntent = new Intent(getApplicationContext(), onboardingpage.class);
                    startActivity(firstTimeIntent);

                    // Set the flag in SharedPreferences to indicate that the app has been opened
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean(FIRST_TIME_KEY, false);
                    editor.apply();
                } else {
                    // The app has been opened before
                    // Proceed to the main functionality of your app
                    Intent intent = new Intent(splashscreen.this, LoginSignupActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        },3000);


    }
}