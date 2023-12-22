package com.example.mykoonba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class notificationAdapter extends RecyclerView.Adapter<notificationAdapter.ViewHolder> {
    Context context;
    ArrayList<notificationDataMOdel>arrayList ;

    notificationAdapter(Context context, ArrayList<notificationDataMOdel> arrayList){
        this.context = context;
        this.arrayList = arrayList;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.notificationlayout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.notigrppic.setImageResource(arrayList.get(position).notipic);
        holder.notigrpnm.setText(arrayList.get(position).grpname);
        holder.notimsg.setText(arrayList.get(position).msg);
        holder.notitime.setText(arrayList.get(position).notitime);



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView notigrpnm,notimsg,notitime;
        CircularImageView notigrppic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notigrpnm = itemView.findViewById(R.id.notigrpnm);
            notimsg  = itemView.findViewById(R.id.notimsg);
            notitime = itemView.findViewById(R.id.notitime);
            notigrppic = itemView.findViewById(R.id.notiPic);

        }
    }
}
