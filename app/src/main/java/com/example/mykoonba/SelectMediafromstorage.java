package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectMediafromstorage extends AppCompatActivity {
    AppCompatButton backward, SubmitBtn, Addmediabtn;
    ImageView imageFetch;
    Uri ImageUri;
    String catagory;
    TextView catagoryTxt;
    EditText title;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mediafromstorage);

        SubmitBtn = findViewById(R.id.SubmitBtn);
        backward = findViewById(R.id.Backkk);
        Addmediabtn = findViewById(R.id.AddMediaBtn);
        imageFetch=findViewById(R.id.imageFetch);
        catagoryTxt=findViewById(R.id.CatagoryType);
        title=findViewById(R.id.AddTitletext);

        Intent i=getIntent();
        catagoryTxt.setText("Catagory: "+i.getStringExtra("catagory"));

        imageFetch.setVisibility(View.GONE);
        SubmitBtn.setEnabled(false);

        Addmediabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(title.getText().toString().isEmpty()){
                   title.setError("Please Enter catogary");
                   title.requestFocus();
               }
               else {
                   Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   startActivityForResult(intent, 444);
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


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            ImageUri = data.getData();
            imageFetch.setImageURI(ImageUri);
            imageFetch.setVisibility(View.VISIBLE);
            SubmitBtn.setEnabled(true);
        }

    }
}