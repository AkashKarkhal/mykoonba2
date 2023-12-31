package com.example.mykoonba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterContactList extends RecyclerView.Adapter<AdapterContactList.ViewHolder> {

    Context context;
    ArrayList<DataModelContactList> arrayList;

    AdapterContactList(Context context){
        this.context=context;
        getListData();
    }



    @NonNull
    @Override
    public AdapterContactList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.contact_list_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContactList.ViewHolder holder, int position) {

        holder.dp.setImageResource(arrayList.get(position).image);
        holder.name.setText(arrayList.get(position).name);

//        holder.item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String heading =arrayList.get(holder.getAdapterPosition()).name.toString();
//                Intent i=new Intent(context, chatscreen.class);
//                i.putExtra("heading",heading);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        CircularImageView dp;
        LinearLayout item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.contact_name_recycler_item);
            dp=itemView.findViewById(R.id.contect_dp_recycler_item);
            item=itemView.findViewById(R.id.item_contact_linear_layout_for_contact);

        }
    }

    void getListData() {
        arrayList=new ArrayList<>();
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Akashdeep Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Ramandeep kaur","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Manjinder Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Mohit Sharma","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Rakesh kumar","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Jyoti koshal","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Akashdeep Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Ramandeep kaur","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Manjinder Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Mohit Sharma","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Rakesh kumar","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Jyoti koshal","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Akashdeep Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Ramandeep kaur","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Manjinder Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Mohit Sharma","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Rakesh kumar","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Jyoti koshal","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Akashdeep Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Ramandeep kaur","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Manjinder Singh","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Mohit Sharma","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Rakesh kumar","contact"));
        arrayList.add(new DataModelContactList(R.drawable.img_1,"Jyoti koshal","contact"));


    }
}
