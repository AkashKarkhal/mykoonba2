package com.example.mykoonba;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter3 extends FragmentPagerAdapter {

    private final int NUM_PAGES = 2; // Number of tabs

    public MyPagerAdapter3(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the fragment for each position
        switch (position) {
            case 0:
                return new FragmentContactList(); // Replace with your Fragment class
            case 1:
                return new FragmentGroupList();// Replace with your Fragment class

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
                return "Contacts";
            case 1:
                return "Groups";

            default:
                return null;
        }
    }
}
