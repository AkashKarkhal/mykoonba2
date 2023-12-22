package com.example.mykoonba;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CelebrateFragmentByMediaType#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebrateFragmentByMediaType extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CelebrateFragmentByMediaType() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CelebrateFragmentByMediaType.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebrateFragmentByMediaType newInstance(String param1, String param2) {
        CelebrateFragmentByMediaType fragment = new CelebrateFragmentByMediaType();
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

        View view=inflater.inflate(R.layout.fragment_celebrate_by_media_type, container, false);
        tabLayout=view.findViewById(R.id.tabLayout2);
        viewPager=view.findViewById(R.id.viewPager2);
        MyPagerAdapter adapter=new MyPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        // Inflate the layout for this fragment
        return view;
    }
}