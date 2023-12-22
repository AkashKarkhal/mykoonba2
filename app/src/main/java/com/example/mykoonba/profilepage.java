
package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class profilepage extends AppCompatActivity {

    LinearLayout personalinfolayout,passwordlayout,invitemsglayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);


        personalinfolayout = findViewById(R.id.Personalinfolayout);
        passwordlayout = findViewById(R.id.Passwordlayout);
        invitemsglayout = findViewById(R.id.Invitemsglayout);

        invitemsglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToShare = "Hello, Join my Koonba Using this Link\nwww.playstore.com/Whatsapp\nDownload and join with me to share memories and more";

                // Create the share intent
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);

                // Display the share panel
                startActivity(Intent.createChooser(shareIntent, "Share using"));
            }
        });

        passwordlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Passwordchangepage.class));
            }
        });

        personalinfolayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), personalinfopage.class));
            }
        });
    }
}