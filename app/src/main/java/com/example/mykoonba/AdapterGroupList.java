package com.example.mykoonba;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

        holder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showDeleteConfirmationDialog(holder.getAdapterPosition());
                return true;
            }
        });
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


    void showDeleteConfirmationDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Are you sure you want to delete this Group?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform deletion here, for example, remove item from the list
                arrayList.remove(position);
                notifyItemRemoved(position);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
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
