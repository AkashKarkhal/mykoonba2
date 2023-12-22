package com.example.mykoonba;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterContentRecycler extends RecyclerView.Adapter<AdapterContentRecycler.ViewHolder> {
    Context context;
    ArrayList<DataModelContents> arrayList;
    String tabItem;

    AdapterContentRecycler(Context context, ArrayList<DataModelContents> arrayList,String tabItem){
        this.context=context;
        this.arrayList=arrayList;
        this.tabItem=tabItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1=LayoutInflater.from(context).inflate(R.layout.content_item_recyclerview,parent,false);
        View v2=LayoutInflater.from(context).inflate(R.layout.content_item_recyclerview2,parent,false);
        View v3=LayoutInflater.from(context).inflate(R.layout.content_item_recyclerview3,parent,false);

        if(tabItem.equals("0"))
        return new ViewHolder(v1);
        else if(tabItem.equals("1"))
            return new ViewHolder(v2);
        else
            return new ViewHolder(v3);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).img);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.imageview);

        }
    }
}
