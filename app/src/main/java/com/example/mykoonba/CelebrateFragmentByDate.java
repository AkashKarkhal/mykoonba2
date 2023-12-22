package com.example.mykoonba;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CelebrateFragmentByDate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebrateFragmentByDate extends Fragment {

    RecyclerView recyclerView;
    ArrayList<modelCelebrateData> arrayList;
    ArrayList<String> datesList=new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CelebrateFragmentByDate() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CelebrateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebrateFragmentByDate newInstance(String param1, String param2) {
        CelebrateFragmentByDate fragment = new CelebrateFragmentByDate();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_celebrate, container, false);

        recyclerView=view.findViewById(R.id.celebrate_main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addItemIntoList();
        AdapterCelebrate1 adapterCelebrate1=new AdapterCelebrate1(getContext(),arrayList);
        recyclerView.setAdapter(adapterCelebrate1);

        // Inflate the layout for this fragment
        return view;
    }

    private void addItemIntoList() {
        arrayList=new ArrayList<>();
        arrayList.add(new modelCelebrateData(R.drawable.holi1,"Holi","2020-08-21"));
        arrayList.add(new modelCelebrateData(R.drawable.holi2,"Holi","2020-08-21"));
        arrayList.add(new modelCelebrateData(R.drawable.holi3,"Holi","2020-08-21"));
        arrayList.add(new modelCelebrateData(R.drawable.h1,"Holi","2020-08-21"));
        arrayList.add(new modelCelebrateData(R.drawable.h2,"Holi","2020-08-21"));
        arrayList.add(new modelCelebrateData(R.drawable.h3,"Holi","2020-08-21"));
        arrayList.add(new modelCelebrateData(R.drawable.diwali,"Diwali","2020-08-25"));
        arrayList.add(new modelCelebrateData(R.drawable.diwali2,"Diwali","2020-08-25"));
        arrayList.add(new modelCelebrateData(R.drawable.diwali3,"Diwali","2020-08-25"));
        arrayList.add(new modelCelebrateData(R.drawable.diwali4,"Diwali","2020-08-25"));
        arrayList.add(new modelCelebrateData(R.drawable.diwali5,"Diwali","2020-08-25"));
        arrayList.add(new modelCelebrateData(R.drawable.diwali6,"Diwali","2020-08-25"));
        arrayList.add(new modelCelebrateData(R.drawable.birth1,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth2,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth3,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth4,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth5,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth6,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth7,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth8,"BirthDay","2020-08-23"));
        arrayList.add(new modelCelebrateData(R.drawable.birth9,"BirthDay","2020-08-23"));


    }

    private Set<String> getUniqueDates() {
        Set<String> uniqueDates = new HashSet<>();
        for (modelCelebrateData data : arrayList) {
            uniqueDates.add(data.date);
        }
        return uniqueDates;
    }
}