package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SliderEventsActivity extends AppCompatActivity {

    AppCompatButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_events);
        Intent i=getIntent();
        int position=i.getIntExtra("pos",0);


        switch (position){
            case 0:
                Toast.makeText(this, "Image Selected: 1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Image Selected: 2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Image Selected: 3", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Image Selected: 4", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Image Selected: 100", Toast.LENGTH_SHORT).show();
        }

        back=findViewById(R.id.backbtnSliderEvent);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}