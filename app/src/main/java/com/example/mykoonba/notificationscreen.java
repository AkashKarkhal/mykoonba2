package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class notificationscreen extends AppCompatActivity {

    AppCompatButton threedotbtn,behindbtn;

    ArrayList<notificationDataMOdel> arrayList = new ArrayList<>();

    RecyclerView notirecyclerview;
    int id1 = R.id.DeleteALl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationscreen);

        notirecyclerview = findViewById(R.id.NotiRecyclerVIew);
        threedotbtn = findViewById(R.id.Threedotbtn);
        behindbtn = findViewById(R.id.behind);

        behindbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        threedotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
                popupMenu.getMenuInflater().inflate(R.menu.dltallnoti, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item clicks
                        int id=item.getItemId();
                        if(id==id1){
                           arrayList.clear();
                            notificationAdapter adapter = new notificationAdapter(getApplicationContext(),arrayList);
                            notirecyclerview.setAdapter(adapter);

                            return true;
                        }

                        else{
                            return false;
                        }
                    }
                });

                popupMenu.show();
            }

        });

        notirecyclerview.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));
        arrayList.add(new notificationDataMOdel(R.drawable.img_1,"Family Group ", "Akash has send to you message","3:43 AM"));

        notificationAdapter adapter = new notificationAdapter(this,arrayList);
        notirecyclerview.setAdapter(adapter);

    }
}