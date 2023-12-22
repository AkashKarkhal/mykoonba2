package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Requestpage extends AppCompatActivity {

    TextView selectdate;
    AppCompatButton callogo;
    DatePicker datePicker;
    int show = 0;
    int date,year,month;

    AppCompatButton SubmitButton,BAck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestpage);

        SubmitButton = findViewById(R.id.SubmitBtn);
        BAck = findViewById(R.id.Backward);
        selectdate = findViewById(R.id.Selectdate);
        callogo= findViewById(R.id.callogo);
        datePicker  = findViewById(R.id.datepicker);

        datePicker.setVisibility(View.GONE);
        show = 0;
        callogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (show ==0){
                    datePicker.setVisibility(View.VISIBLE);
                    show = 1;
                    callogo.setBackgroundResource(R.drawable.close);
                }
                else{
                    datePicker.setVisibility(View.GONE);
                    show = 0;
                    callogo.setBackgroundResource(R.drawable.call);

                }
            }
        });
        date = datePicker.getDayOfMonth();
        year = datePicker.getYear();
        month = datePicker.getMonth()+1;

        selectdate.setText(date+ "-" + month + "-" + year);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                selectdate.setText(i2+ "-" + (i1+1) + "-" + i);
            }
        });


        BAck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(new Intent(Requestpage.this, Groupspage.class));
                i.putExtra("mode","request");
                startActivity(i);
                finish();
            }
        });
    }
}