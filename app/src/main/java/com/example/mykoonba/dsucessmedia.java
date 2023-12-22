package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dsucessmedia extends AppCompatActivity {

    AppCompatButton ShareWithKoonbaBtn, Backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsucessmedia);

        ShareWithKoonbaBtn = findViewById(R.id.ShareWithKoonbaBtn);
        Backward =  findViewById(R.id.Backward);

        Backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ShareWithKoonbaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(new Intent(dsucessmedia.this, Groupspage.class));
                i.putExtra("mode","add");
                startActivity(i);
                finish();
            }
        });
    }
}