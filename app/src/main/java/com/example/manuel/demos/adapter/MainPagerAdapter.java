package com.example.manuel.demos.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.manuel.demos.Camera2BasicFragment;
import com.example.manuel.demos.fragment.ChatFragment;
import com.example.manuel.demos.fragment.EmptyFragment;
import com.example.manuel.demos.fragment.StoriesFragment;

/**
 * Created by manuel on 19/10/2017.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                //return EmptyFragment.create();
                return ChatFragment.create();
            case 0:
                return Camera2BasicFragment.newInstance();
            case 2:
                return EmptyFragment.create();
        }

        return null;
    }


    @Override
    public int getCount() {
        return 3;
    }
}
