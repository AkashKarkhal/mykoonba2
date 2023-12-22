package com.example.mykoonba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterGroupList extends RecyclerView.Adapter<AdapterGroupList.ViewHolder> {

    Context context;
    ArrayList<networklistDataModel> arrayList;

    AdapterGroupList(Context context){
        this.context=context;
        //getListData();
        arrayList=new groupdata().getArrayList();
    }



    @NonNull
    @Override
    public AdapterGroupList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contact_list_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGroupList.ViewHolder holder, int position) {

        //holder.dp.setImageURI(arrayList.get(position).image);
        holder.name.setText(arrayList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        CircularImageView dp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.contact_name_recycler_item);
            dp=itemView.findViewById(R.id.contect_dp_recycler_item);


        }
    }

    void getListData() {
//        arrayList=new ArrayList<>();
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"Donate Blood"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"My Family"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"Yarri Dosti"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"Donate Blood"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"My Family"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"Yarri Dosti"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"Donate Blood"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"My Family"));
//        arrayList.add(new DataModelContactList(R.drawable.img_1,"Yarri Dosti"));
    }
}
