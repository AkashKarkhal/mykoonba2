package com.example.mykoonba;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final int NUM_PAGES = 3; // Number of tabs

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the fragment for each position
        switch (position) {
            case 0:
                return ContentFragment.newInstance(position+""); // Replace with your Fragment class
            case 1:
                return ContentFragment.newInstance(position+"");// Replace with your Fragment class
            case 2:
                return ContentFragment.newInstance(position+""); // Replace with your Fragment class
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Return the number of tabs
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Set the title for each tab
        switch (position) {
            case 0:
                return "Images";
            case 1:
                return "Videos";
            case 2:
                return "Audios";
            default:
                return null;
        }
    }
}
