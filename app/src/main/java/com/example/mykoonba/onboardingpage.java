package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class onboardingpage extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TextView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboardingpage);

        tabLayout=findViewById(R.id.onboardingtabLayout);
        viewPager=findViewById(R.id.onboardingPager);
        next=findViewById(R.id.onboardnext);
        MyPagerAdapter2 adapter=new MyPagerAdapter2(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextTab = viewPager.getCurrentItem() + 1;
                if (nextTab < viewPager.getAdapter().getCount()) {
                    viewPager.setCurrentItem(nextTab);
                }
                else{
                    startActivity(new Intent(getApplicationContext(), LoginSignupActivity.class));
                    finish();
                }
            }
        });
    }
}