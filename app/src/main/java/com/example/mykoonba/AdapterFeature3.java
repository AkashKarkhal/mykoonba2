package com.example.mykoonba;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFeature3 extends RecyclerView.Adapter<AdapterFeature3.ViewHolder> {
    Context context;
    ArrayList<DataModelFeature3Item> arrayList;

    AdapterFeature3(Context context, ArrayList<DataModelFeature3Item> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.recycler_layout_feature3_item,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dp.setBackgroundResource(arrayList.get(position).pic);
        holder.name.setText(arrayList.get(position).name);


        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(context,Network_content.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        AppCompatButton dp;
        TextView name;
        LinearLayout item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dp=itemView.findViewById(R.id.button_recycler_item_feature_3);
            name=itemView.findViewById(R.id.text_recycler_item_feature_3);
            item=itemView.findViewById(R.id.recycler_view_item_layout);
        }
    }
}
