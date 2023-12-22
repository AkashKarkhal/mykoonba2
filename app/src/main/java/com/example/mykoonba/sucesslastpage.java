package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sucesslastpage extends AppCompatActivity {

    AppCompatButton ExitBtn,Backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesslastpage);

        ExitBtn = findViewById(R.id.Exittn);
        Backward =  findViewById(R.id.Backward);

        Backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sucesslastpage.this, MainActivity.class));
                finish();

            }
        });


    }
}