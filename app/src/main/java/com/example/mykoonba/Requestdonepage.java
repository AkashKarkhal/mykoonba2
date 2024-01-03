package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class Requestdonepage extends AppCompatActivity {

    AppCompatButton behind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestdonepage);

        behind = findViewById(R.id.Behind);

        behind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

            }
        },1500);
    }
}