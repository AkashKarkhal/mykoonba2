package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class chatscreen extends AppCompatActivity {

    TextView grpnamechat;
    AppCompatButton chatdot,chatback,chatsendbtn;
    CircularImageView chatgrpdp;
    EditText chatmsg;
    RecyclerView chatrecylerview;
    String heading;
    AppCompatButton chatscreendot;
    ArrayList<chatmodel> arrayList=new ArrayList<>();

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatscreen);
        Intent i= getIntent();
        heading=i.getStringExtra("heading");

       grpnamechat = findViewById(R.id.chatscreenheading);
       chatdot =  findViewById(R.id.chatscreendot);
       chatback  = findViewById(R.id.chatscreenbackbtn);
       chatsendbtn = findViewById(R.id.chatscreensendbtn);
       chatgrpdp = findViewById(R.id.chatscreendp);
       chatmsg = findViewById(R.id.chatscreenedittext);
       chatrecylerview = findViewById(R.id.chatscreenecyclerview);

       chatscreendot = findViewById(R.id.chatscreendot);
       dialog = new Dialog(this);

       chatscreendot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               dialog.setContentView(R.layout.dialogdesign);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();


           }
       });







       grpnamechat.setText(heading);

       chatrecylerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

       arrayList.add(new chatmodel("hi How are you?",1));
        arrayList.add(new chatmodel("i am fine",0));
        arrayList.add(new chatmodel("i am try to contact with you where are you",1));
        arrayList.add(new chatmodel("i am at home now",0));
        ChatscreenAdapter adapter=new ChatscreenAdapter(getApplicationContext(),arrayList);
        chatrecylerview.setAdapter(adapter);

        chatsendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chat=chatmsg.getText().toString();
              if (!chatmsg.getText().toString().equals("")){
                  arrayList.add(new chatmodel(chat,1));
                  ChatscreenAdapter adapter=new ChatscreenAdapter(getApplicationContext(),arrayList);
                  chatrecylerview.setAdapter(adapter);
                  chatrecylerview.scrollToPosition(arrayList.size()-1);
                  chatmsg.clearFocus();
                  chatmsg.setText("");
              }
              else{
                  Toast.makeText(chatscreen.this, "Can't Send Empty Message", Toast.LENGTH_SHORT).show();
              }
            }
        });
       chatback.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });

    }
}