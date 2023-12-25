package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectCatagory extends AppCompatActivity {
    AppCompatButton Festivals,Backward;

    ArrayList<String> catogarylist = new ArrayList<>();

    ListView catagorylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_catagory);
        catagorylistview = findViewById(R.id.Catagorylistview);
        catogarylist.add("Celebration and Enjoyment");
        catogarylist.add("Food and Drinks");
        catogarylist.add("Fashion and Style");
        catogarylist.add("Festivals");
        catogarylist.add("Family Events");
        catogarylist.add("Travel and Adventure");
        catogarylist.add("Nature and Outdoors");
        catogarylist.add("Work and Business");
        catogarylist.add("Pets and Animals");
        catogarylist.add("Sports and Fitness");

        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,catogarylist);
       catagorylistview.setAdapter(adapter);

       catagorylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(getApplicationContext(), SelectMediafromstorage.class);
               intent.putExtra("catagory",catogarylist.get(i).toString());
               startActivity(intent);
           }
       });


        Backward =  findViewById(R.id.Backkk);


        Backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}