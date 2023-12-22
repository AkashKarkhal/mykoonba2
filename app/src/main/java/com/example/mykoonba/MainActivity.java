package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppCompatButton CelebrateBtn,ADDBtn,rqst,plusbtn,addEventBtn,UserBtn,groupbtn;

    ImageSlider imageSlider;
    ListView listView;



    CardView groupcardview,ByMediaType;
    LinearLayout networks;
    ArrayList<String> eventList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CelebrateBtn = findViewById(R.id.CelebrateBtn);
        ADDBtn = findViewById(R.id.ADDBtn);
        rqst = findViewById(R.id.rqst);
        plusbtn = findViewById(R.id.PlusBtn);
        networks=findViewById(R.id.mynetworktxt);
        imageSlider = findViewById(R.id.image_slider);
        listView=findViewById(R.id.listEvents);
        addEventBtn=findViewById(R.id.addEventbtn);
        UserBtn = findViewById(R.id.Userbtn);
        ByMediaType = findViewById(R.id.ByMediaType);
        groupbtn=findViewById(R.id.groupbtn);

        groupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), onboardingpage.class));
            }
        });

        ByMediaType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Network_content.class));
            }
        });

        UserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), profilepage.class));
            }
        });

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.d1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.d2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.d3, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.d2, ScaleTypes.CENTER_CROP));

        eventList.add("Manjinder birthday: 17-12-2023");
        eventList.add("31st Party: 31-12-2023");
        eventList.add("Lohri Festival: 13-01-2024");
        eventList.add("holi Festival: 15-03-2024");
        eventList.add("Vaishakhi Festival: 14-04-2024");

        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,eventList);
        listView.setAdapter(adapter);


        imageSlider.setImageList(slideModels);





        networks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), Groupspage.class);
                i.putExtra("mode","network");
                startActivity(i);
            }
        });


        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), upcomingeventlayout.class));
            }
        });

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        rqst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Requestpage.class));
            }
        });

        CelebrateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CelebrateActivity.class));
            }
        });

        ADDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelectCatagory.class));
            }
        });


    }
}