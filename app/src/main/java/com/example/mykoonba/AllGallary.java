package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllGallary extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataModelFeature3Item> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_gallary);
        putDataInArraylist();
        recyclerView =findViewById(R.id.feature3_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterFeature3 adapter=new AdapterFeature3(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapter);
    }

    private void putDataInArraylist() {

        for(int i=1; i<11;i++){
            arrayList.add(new DataModelFeature3Item("Network "+i,R.drawable.person));
        }
    }
}