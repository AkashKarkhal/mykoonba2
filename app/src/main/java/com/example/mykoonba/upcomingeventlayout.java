package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class upcomingeventlayout extends AppCompatActivity {
    EditText addeventname;
    DatePicker datepicker;
    int day,month,year;
    AppCompatButton backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingeventlayout);

        AppCompatButton done=findViewById(R.id.Addupeventbtn);
        addeventname = findViewById(R.id.AddEventname);
        datepicker = findViewById(R.id.Addeventdatepicker);
        backbtn = findViewById(R.id.backbtnupcoming);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        day=datepicker.getDayOfMonth();
        month= datepicker.getMonth()+1;
        year= datepicker.getYear();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datepicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    year=i;
                    month=i1+1;
                    day=i2;
                }
            });
        }


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String events=addeventname.getText().toString();
                events+=": "+day+"-"+month+"-"+year;

                new EventData().getArrayList().add(events);
                finish();
            }
        });

    }
}