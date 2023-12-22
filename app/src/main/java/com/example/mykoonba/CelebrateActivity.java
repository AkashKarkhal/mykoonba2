package com.example.mykoonba;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CelebrateActivity extends AppCompatActivity {

    TextView more;
    FrameLayout frame;
    ArrayList<String> datesList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.celibrate_activity_layout);
        more=findViewById(R.id.more);
        frame=findViewById(R.id.frameCont);

        int id1=R.id.menu_item_bydate;
        int id2=R.id.menu_item_bymedia;

        CelebrateFragmentByDate byDate= new CelebrateFragmentByDate();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameCont,byDate);
        fragmentTransaction.commit();

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());

                // Set a listener for menu item clicks
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item clicks
                        int id=item.getItemId();
                        if(id==id1){
                            CelebrateFragmentByDate byDate= new CelebrateFragmentByDate();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frameCont,byDate);
                            fragmentTransaction.commit();

                            return true;
                        }
                        else if(id==id2){
                            CelebrateFragmentByMediaType bymedia=new CelebrateFragmentByMediaType();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frameCont,bymedia);
                            fragmentTransaction.commit();
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




    }

}