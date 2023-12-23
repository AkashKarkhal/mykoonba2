
package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profilepage extends AppCompatActivity {

    AppCompatButton backbtn;

    LinearLayout personalinfolayout,passwordlayout,invitemsglayout;

    TextView fullname,mail;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        fullname=findViewById(R.id.fullnameprofilepage);
        mail=findViewById(R.id.usernameprofilepage);
        backbtn = findViewById(R.id.backbtnprofilepage);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser == null){
            Toast.makeText(this, "Data Not Fethced", Toast.LENGTH_SHORT).show();
        }
        else {
            String userid =  firebaseUser.getUid();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Register Users ");
            databaseReference.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserProfiledata userProfiledata = snapshot.getValue(UserProfiledata.class);
                    if (userProfiledata!=null){
                        fullname.setText(userProfiledata.fullname);
                        mail.setText(firebaseUser.getEmail());



                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                    Toast.makeText(getApplicationContext(), "Something Went Wrong!!", Toast.LENGTH_SHORT).show();

                }
            });
        }


    }
}