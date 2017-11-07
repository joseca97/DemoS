package com.example.manuel.demos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.example.manuel.demos.R;

/**
 * Created by manuel on 19/10/2017.
 */

public class ChatFragment extends BaseFragment {

    public static ChatFragment create() {
        return new ChatFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_chat;
    }

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
}
