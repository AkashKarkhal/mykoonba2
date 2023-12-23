package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signin extends AppCompatActivity {

    AppCompatButton Createaccountbtn,backbtn;
    TextView Alreadyaccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Createaccountbtn = findViewById(R.id.CreateAccount);
        Alreadyaccount = findViewById(R.id.Doyoualreadyaccount);
        backbtn = findViewById(R.id.BackbtnCreateaccount);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Loginpage.class));
            }
        });

        Createaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), Verification_email_of_signin.class);
                i.putExtra("mode","signin");
                startActivity(i);
                finish();            }
        });


    }
}