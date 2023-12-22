package com.example.mykoonba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;

import java.util.ArrayList;

public class networklayoutAdapter extends RecyclerView.Adapter<networklayoutAdapter.ViewHolder> {
    Context context;
    String mode;
    ArrayList<networklistDataModel> arrayList = new ArrayList<>();

    public networklayoutAdapter(Context context, ArrayList<networklistDataModel> arrayList,String mode) {
        this.context = context;
        this.arrayList = arrayList;
        this.mode = mode;
    }

    @NonNull
    @Override
    public networklayoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.groupnamelayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull networklayoutAdapter.ViewHolder holder, int position) {

        holder.grpnm.setText(arrayList.get(position).name);
        holder.grpdp.setBackgroundResource(arrayList.get(position).image);

        if(mode.equals("addrequest")){
            holder.grouplayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(holder.Checkboxgrp.isChecked())
                        holder.Checkboxgrp.setChecked(false);
                    else
                        holder.Checkboxgrp.setChecked(true);
                }
            });

        }
        else if(mode.equals("network")){
            holder.Checkboxgrp.setVisibility(View.GONE);
            holder.grouplayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(context, Network_content.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView grpnm;
        ImageButton grpdp;
        CheckBox Checkboxgrp;
        CardView grouplayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            grpnm = itemView.findViewById(R.id.grpnm);
            grpdp = itemView.findViewById(R.id.grpdp);
            Checkboxgrp = itemView.findViewById(R.id.Checkboxgrp);
            grouplayout=itemView.findViewById(R.id.grouplayout);
        }
    }
}
