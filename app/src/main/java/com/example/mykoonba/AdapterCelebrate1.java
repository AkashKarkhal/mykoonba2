package com.example.mykoonba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AdapterCelebrate1 extends RecyclerView.Adapter<AdapterCelebrate1.ViewHolder> {

    Context context;
    SeekBar seekBar;
    ArrayList<modelCelebrateData> arrayList;
    ArrayList<String> uniqueDatesList;
    ArrayList<String> uniqueCategoriesList;

    public AdapterCelebrate1(Context context, ArrayList<modelCelebrateData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.seekBar=seekBar;
        findUniqueDatesAndCategories();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.parent_layout_for_celebrate_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.heading.setText(uniqueDatesList.get(position));
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        AdapterCelebrate2 adapterCelebrate2=new AdapterCelebrate2(context,arrayList,uniqueDatesList.get(position),holder.heading);
        holder.recyclerView.setAdapter(adapterCelebrate2);

    }

    @Override
    public int getItemCount() {
        return uniqueDatesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading=itemView.findViewById(R.id.celebrate_parent_heading);
            recyclerView=itemView.findViewById(R.id.celebrate_child_recyclerview);
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
}
