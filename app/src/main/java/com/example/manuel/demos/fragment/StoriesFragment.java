package com.example.manuel.demos.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.manuel.demos.R;
import com.example.manuel.demos.adapter.ProblemListAdapter;
import com.example.manuel.demos.models.Boulder;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by manuel on 19/10/2017.
 */

public class StoriesFragment extends BaseFragment {

    private Button btnSettings;
    private ListView mListView;

    public static StoriesFragment create() {
        return new StoriesFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_search;
    }

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mListView = (ListView) root.findViewById(R.id.problemlistview);

        final ArrayList<Boulder> bouldersList = new ArrayList<Boulder>();

        for(int i=0; i < 10; i++) {
            bouldersList.add(new Boulder("Jose Carlos Arinero " + i, "Aprieta la regleta" + i, new Date(), "7a+", "Que chulo"));
        }

        ProblemListAdapter problemsAdapter = new ProblemListAdapter(root.getContext(), bouldersList);

        mListView.setAdapter(problemsAdapter);
    }
}
