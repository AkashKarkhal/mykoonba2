package com.example.mykoonba;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter2 extends FragmentPagerAdapter {

    private final int NUM_PAGES = 4; // Number of tabs

    public MyPagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the fragment for each position
        switch (position) {
            case 0:
                return new Onboardingpage1(); // Replace with your Fragment class
            case 1:
                return new onboadringpage2();// Replace with your Fragment class
            case 2:
                return new onboardpage3();
            case 3:
                return new onboarding4();// Replace with your Fragment class
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
                return ".";
            case 1:
                return ".";
            case 2:
                return ".";
            case 3:
                return ".";
            default:
                return null;
        }
    }
}
