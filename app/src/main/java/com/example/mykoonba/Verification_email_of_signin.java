package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Verification_email_of_signin extends AppCompatActivity {

    AppCompatButton Verifybtn,backbtnverification;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_email_of_signin);

        Verifybtn =  findViewById(R.id.VerifyOtp);
        backbtnverification = findViewById(R.id.Backbtnverification);
        Intent i=getIntent();
        mode=i.getStringExtra("mode");

        backbtnverification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(mode.equals("signin")){
                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   startActivity(intent);
                   finish();
               }
               if(mode.equals("login")){
                   startActivity(new Intent(getApplicationContext(), ResetPassword.class));
                   finish();
               }
            }
        });
    }
}