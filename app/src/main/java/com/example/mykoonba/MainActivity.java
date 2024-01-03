package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppCompatButton CelebrateBtn,ADDBtn,rqst,plusbtn,addEventBtn,UserBtn,groupbtn,notibtn;

    AppCompatButton Addgourpbtn,addeventbtn,homebtn,myContribition,chatButton;



    ImageSlider imageSlider;
    ListView listView;

    CardView groupcardview,ByMediaType;
    LinearLayout networks;
    ArrayList<String> eventList;


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
        UserBtn = findViewById(R.id.Userbtn);

        notibtn = findViewById(R.id.notibtn);
        addeventbtn = findViewById(R.id.AddEventbtn);
        homebtn = findViewById(R.id.Homemain);
        chatButton=findViewById(R.id.chatButton);

        myContribition=findViewById(R.id.ButonMyContribition);








        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        addeventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), upcomingeventlayout.class));
            }
        });

        notibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), notificationscreen.class));
            }
        });

        myContribition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MyContribition.class));
            }
        });
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChatListActivity.class));
            }
        });


//

//        ByMediaType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), Network_content.class));
//            }
//        });

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

        eventList = new EventData().getArrayList();

        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,eventList);
        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Remove the item from the list
                        eventList.remove(i);

                        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,eventList);
                        listView.setAdapter(adapter);


                    }
                });
                return true;
            }
        });


        imageSlider.setImageList(slideModels);



        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {

                Intent intent=new Intent(getApplicationContext(), SliderEventsActivity.class);
                intent.putExtra("pos",i);
                startActivity(intent);
            }

            @Override
            public void doubleClick(int i) {

            }
        });




        networks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i= new Intent(getApplicationContext(), Groupspage.class);
//                i.putExtra("mode","network");
//                startActivity(i);
                startActivity(new Intent(getApplicationContext(),NetworkTabActivity.class));
            }
        });


//        AddEventBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), upcomingeventlayout.class));
//            }
//        });

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

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,eventList);
        listView.setAdapter(adapter);
    }
}