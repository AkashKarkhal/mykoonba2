package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class addgrouppage extends AppCompatActivity {

    AppCompatButton back,addBtn,addPic;
    EditText name;
    Uri ImageUri;
    CircularImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgrouppage);
        back=findViewById(R.id.backButtonAddGroup);
        addBtn=findViewById(R.id.CreateButtonwhilecreatinggroup);
        name=findViewById(R.id.NameofKoonbawhileCreatinggroup);
        image=findViewById(R.id.fetchImageToaddGroup);
        addPic=findViewById(R.id.addImageBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namek =  name.getText().toString();
                int pic = R.drawable.applogo;

                ArrayList<networklistDataModel> arrayList = new  groupdata().getArrayList();
                arrayList.add(new networklistDataModel(ImageUri,namek));
                finish();
            }
        });

        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 444);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            ImageUri = data.getData();
            image.setImageURI(ImageUri);
        }

    }
}