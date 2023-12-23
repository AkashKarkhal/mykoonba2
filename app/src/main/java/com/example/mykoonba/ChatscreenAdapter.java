package com.example.mykoonba;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatscreenAdapter extends RecyclerView.Adapter<ChatscreenAdapter.ViewHolder> {
    Context context;
    ArrayList<chatmodel> arrayList ;

    public ChatscreenAdapter(Context context,ArrayList<chatmodel> arrayList) {
        this.context = context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ChatscreenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chat_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatscreenAdapter.ViewHolder holder, int position) {

        holder.c.setText(arrayList.get(position).message);
        if(arrayList.get(holder.getAdapterPosition()).sender==1){
            holder.llll.setGravity(Gravity.END);
            holder.llll.setPadding(120,0,0,0);
     }
        else {
            holder.llll.setGravity(Gravity.START);
            holder.llll.setPadding(0,0,120,0);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView c;
        LinearLayout llll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            c=itemView.findViewById(R.id.chatTxt);
            llll=itemView.findViewById(R.id.llll);
        }
    }

}
