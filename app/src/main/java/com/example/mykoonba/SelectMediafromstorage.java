package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SelectMediafromstorage extends AppCompatActivity {
    AppCompatButton backward, SubmitBtn, Addmediabtn;
    //ImageView imageFetch;
    Uri ImageUri;
    RecyclerView recyclerView;
    String catagory;
    TextView catagoryTxt;
    EditText title;
    ArrayList<Uri> imageUris;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mediafromstorage);

        SubmitBtn = findViewById(R.id.SubmitBtn);
        backward = findViewById(R.id.Backward);
        Addmediabtn = findViewById(R.id.AddMediaBtn);
        //imageFetch=findViewById(R.id.imageFetch);
        catagoryTxt=findViewById(R.id.CatagoryType);
        title=findViewById(R.id.AddTitletext);

        SubmitBtn.setEnabled(false);
        imageUris = new ArrayList<>();

        recyclerView=findViewById(R.id.RecyclerViewFetchMedia);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));

        Intent i=getIntent();
        catagoryTxt.setText("Catagory: "+i.getStringExtra("catagory"));

        //imageFetch.setVisibility(View.GONE);


        Addmediabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(title.getText().toString().isEmpty()){
                   title.setError("Please Enter catogary");
                   title.requestFocus();
               }
               else {
                   Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                   intent.setType("image/*");
                   intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                   startActivityForResult(Intent.createChooser(intent, "Select Picture"), 444);
               }
            }
        });


        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectMediafromstorage.this, dsucessmedia.class));
                finish();
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
//            ImageUri = data.getData();
//            imageFetch.setImageURI(ImageUri);
            //imageFetch.setVisibility(View.VISIBLE);
            SubmitBtn.setEnabled(true);


            if (data != null) {
                // Check if multiple images are selected
                if (data.getClipData() != null) {
                    imageUris=new ArrayList<>();
                    ClipData clipData = data.getClipData();
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        Uri uri = clipData.getItemAt(i).getUri();
                        imageUris.add(uri);
                    }
                    AdapterFetchMedia adapterFetchMedia=new AdapterFetchMedia(getApplicationContext(),imageUris);
                    recyclerView.setAdapter(adapterFetchMedia);
                } else if (data.getData() != null) {
                    // Single image selected
                    Uri uri = data.getData();
                    imageUris.add(uri);
                }
            }
        }

    }
}