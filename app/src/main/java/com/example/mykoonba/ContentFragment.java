package com.example.mykoonba;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public ContentFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     *
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String pos) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    RecyclerView recyclerView;
    ArrayList<DataModelContents> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_content, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_Content_layout);
        putDataInArraylist();

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        AdapterContentRecycler adapterContentRecycler=new AdapterContentRecycler(getContext(),arrayList,mParam1);
        recyclerView.setAdapter(adapterContentRecycler);

        // Inflate the layout for this fragment
        return view;
    }

    private void putDataInArraylist() {
        arrayList=new ArrayList<>();

       if(mParam1.equals("0")){
           for(int i=0;i<10;i++){
               arrayList.add(new DataModelContents(R.drawable.img_1));
           }
       }
        if(mParam1.equals("1")){
            for(int i=0;i<10;i++){
                arrayList.add(new DataModelContents(R.drawable.img_2));
            }
        }
        if(mParam1.equals("2")){
            for(int i=0;i<10;i++){
                arrayList.add(new DataModelContents(R.drawable.img_3));
            }
        }
    }
}