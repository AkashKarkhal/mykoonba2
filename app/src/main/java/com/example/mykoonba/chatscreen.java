package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class chatscreen extends AppCompatActivity {

    TextView grpnamechat;
    AppCompatButton chatdot,chatback,chatsendbtn;
    CircularImageView chatgrpdp;
    EditText chatmsg;
    RecyclerView chatrecylerview;
    ArrayList<chatmodel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatscreen);


       grpnamechat = findViewById(R.id.chatscreenheading);
       chatdot =  findViewById(R.id.chatscreendot);
       chatback  = findViewById(R.id.chatscreenbackbtn);
       chatsendbtn = findViewById(R.id.chatscreensendbtn);
       chatgrpdp = findViewById(R.id.chatscreendp);
       chatmsg = findViewById(R.id.chatscreenedittext);
       chatrecylerview = findViewById(R.id.chatscreenecyclerview);


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
                arrayList.add(new chatmodel(chat,1));
                ChatscreenAdapter adapter=new ChatscreenAdapter(getApplicationContext(),arrayList);
                chatrecylerview.setAdapter(adapter);

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