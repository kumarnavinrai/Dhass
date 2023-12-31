package com.example.dhass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return the appropriate fragment based on the position
        return new PlaceholderFragment();
    }

    @Override
    public int getCount() {
        // Return the total number of tabs
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Return the title for each tab
        if(position == 0){
            return "Chats";
        }else if(position == 1){
            return "Status";
        }else{
            return "Calls";
        }
    }
}


