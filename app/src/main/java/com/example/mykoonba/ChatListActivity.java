package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;


public class ChatListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AppCompatButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        recyclerView=findViewById(R.id.recyclerViewChatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdapterChatList adapter=new AdapterChatList(getApplicationContext());
        recyclerView.setAdapter(adapter);

        back=findViewById(R.id.backChatList);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}