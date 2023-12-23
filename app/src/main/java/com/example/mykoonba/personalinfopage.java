package com.example.mykoonba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class personalinfopage extends AppCompatActivity {

    Uri ImageUri;
    CircularImageView image;

    TextView fullnamepersonal,emailpersonal,phnnumberpersonal,dobpersonal;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    AppCompatButton backbtn,addPic;

    LinearLayout personalinfolayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfopage);

        fullnamepersonal = findViewById(R.id.fullnamepersonal);
        emailpersonal = findViewById(R.id.emailpersonal);
        phnnumberpersonal = findViewById(R.id.phnnumberpersonal);
        dobpersonal = findViewById(R.id.dobpersonal);
        backbtn = findViewById(R.id.backbtnpersonal);
        addPic=findViewById(R.id.profilepicchngebtn);
        image=findViewById(R.id.fetchImageToadprofilepic);


        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 444);
            }
        });


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
                        fullnamepersonal.setText(userProfiledata.fullname);
                        emailpersonal.setText(firebaseUser.getEmail());
                        phnnumberpersonal.setText(userProfiledata.phnnumber);
                        dobpersonal.setText(userProfiledata.daeofbirth);


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                    Toast.makeText(personalinfopage.this, "Something Went Wrong!!", Toast.LENGTH_SHORT).show();

                }
            });
        }




    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            ImageUri = data.getData();
            image.setImageURI(ImageUri);
        }

    }
}