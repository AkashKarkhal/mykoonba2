package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Groupspage extends AppCompatActivity {

    RecyclerView recyclerView;
    AppCompatButton sndbtn;
    String mode;

    ArrayList<networklistDataModel> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupspage);
        recyclerView = findViewById(R.id.recyclerview);
        sndbtn = findViewById(R.id.sndbtn);

        Intent i=getIntent();
        mode=i.getStringExtra("mode");

        sndbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode.equals("add"))
                startActivity(new Intent(Groupspage.this, sucesslastpage.class));
                if(mode.equals("request"))
                    startActivity(new Intent(Groupspage.this, Requestdonepage.class));
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));
        arrayList.add(new networklistDataModel(R.drawable.img_3,"Family Group"));

        if(mode.equals("add")|| mode.equals("request")) {
            networklayoutAdapter adapter = new networklayoutAdapter(getApplicationContext(), arrayList,"addrequest" );
            recyclerView.setAdapter(adapter);
        }
        else{
            sndbtn.setVisibility(View.GONE);
            networklayoutAdapter adapter = new networklayoutAdapter(getApplicationContext(), arrayList,"network");
            recyclerView.setAdapter(adapter);
        }

    }
}