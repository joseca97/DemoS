package com.example.manuel.demos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.manuel.demos.R;

/**
 * Created by manuel on 19/10/2017.
 */

public class StoriesFragment extends BaseFragment {

    private Button btnSettings;

    public static StoriesFragment create() {
        return new StoriesFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_stories;
    }

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
}
