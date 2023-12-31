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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class chatscreen extends AppCompatActivity {

    TextView grpnamechat;
    AppCompatButton chatdot,chatback,chatsendbtn;
    CircularImageView chatgrpdp;
    EditText chatmsg;
    int pos;
    RecyclerView chatrecylerview;
    String heading;
    AppCompatButton chatscreendot;
    ArrayList<chatmodel> arrayList=new ArrayList<>();

    Dialog dialog;

    String mode="";
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatscreen);
        Intent i= getIntent();
        heading=i.getStringExtra("heading");
        pos=0;
        mode=i.getStringExtra("mode");
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
               if(mode.equals("group")){
                   dialog.setContentView(R.layout.dialogdesinnforgroup);
                   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                   TextView nameindialogbox = dialog.findViewById(R.id.nameindialobox_group);
                   nameindialogbox.setText(heading);
                   list=dialog.findViewById(R.id.list_view_members_of_group);
                   ArrayList<String> itemList = new ArrayList<>();
                   itemList.add("John Doe");
                   itemList.add("Jane Doe");
                   itemList.add("Alice Johnson");
                   itemList.add("Bob Smith");
                   itemList.add("Eva Brown");
                   itemList.add("Michael Johnson");
                   itemList.add("Sophia Davis");
                   itemList.add("David Wilson");
                   itemList.add("Olivia Miller");
                   itemList.add("Daniel Taylor");

                   ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,itemList);
                   list.setAdapter(adapter);

                   AppCompatButton delete=dialog.findViewById(R.id.btn_delete_group);
                   delete.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                          //new groupdata().getArrayList().remove(pos);
                           finish();
                       }
                   });
                   dialog.show();
               }
               else{
                   dialog.setContentView(R.layout.dialogdesignsimple);
                   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                   TextView nameindialogbox = dialog.findViewById(R.id.nameindialobox);
                   nameindialogbox.setText(heading);
                   dialog.show();
               }


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