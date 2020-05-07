package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int numberOfTabs;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        numberOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
                return new FrozenGroceryFragment();
            case 1 :
                return new FreshGroceryFragment();
            case 2 :
                return new CannedGroceryFragment();
            default:
                return  null;
        }
       // return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
