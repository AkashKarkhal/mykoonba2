package com.example.mykoonba;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFetchMedia extends RecyclerView.Adapter<AdapterFetchMedia.ViewHolder> {
    ArrayList<Uri> arrayList=new ArrayList<>();
    Context context;
    public AdapterFetchMedia( Context context,ArrayList<Uri> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterFetchMedia.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fetch_media_item_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFetchMedia.ViewHolder holder, int position) {

        holder.imageView.setImageURI(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.fetchImageItem);
        }
    }
}
