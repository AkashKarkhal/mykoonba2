package com.example.mykoonba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AdapterCelebrate2 extends RecyclerView.Adapter<AdapterCelebrate2.ViewHolder> {

    Context context;
    ArrayList<modelCelebrateData> arrayList;
    ArrayList<String> uniqueDatesList;
    ArrayList<String> uniqueCategoriesList;
    String date,catogary;
    ArrayList<Integer> image_list;
    TextView view;
    public AdapterCelebrate2(Context context, ArrayList<modelCelebrateData> arrayList,String date,TextView view) {
        this.context = context;
        this.arrayList = arrayList;
        this.date=date;
        getImageList(date);
        this.view=view;
        //findUniqueDatesAndCategories();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.child_layout_for_celebrate_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.imageView.setImageResource(image_list.get(position));

       if(position==0){
           view.setText(date+" : "+catogary);
       }

       holder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i= new Intent(context,ImageViewer.class);
               i.putExtra("img",image_list.get(holder.getAdapterPosition()));
               i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(i);
           }
       });

    }

    @Override
    public int getItemCount() {
        return image_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview_celebrate_child);
        }
    }



    private Set<String> getUniqueDates() {
        Set<String> uniqueDates = new HashSet<>();
        for (modelCelebrateData data : arrayList) {
            uniqueDates.add(data.date);
        }
        return uniqueDates;
    }

    private Set<String> getUniqueCategories() {
        Set<String> uniqueCategories = new HashSet<>();
        for (modelCelebrateData data : arrayList) {
            uniqueCategories.add(data.catogary);
        }
        return uniqueCategories;
    }

    private void findUniqueDatesAndCategories() {
        // Get unique dates
        uniqueDatesList = new ArrayList<>(getUniqueDates());
        // Get unique categories
        uniqueCategoriesList = new ArrayList<>(getUniqueCategories());
    }

    private void getImageList(String Date) {
        image_list=new ArrayList<>();
        for(int i=0;i<arrayList.size();i++){

            if(arrayList.get(i).date.equals(date)){
                image_list.add(arrayList.get(i).image);

                catogary=(arrayList.get(i).catogary);
            }
        }
    }
}
