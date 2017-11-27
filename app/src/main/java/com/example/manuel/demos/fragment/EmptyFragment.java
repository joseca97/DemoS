package com.example.manuel.demos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.manuel.demos.LoginActivity;
import com.example.manuel.demos.MainActivity;
import com.example.manuel.demos.R;
import com.example.manuel.demos.SettingsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by manuel on 19/10/2017.
 */

public class EmptyFragment extends BaseFragment {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    private TextView userNameD;
    private ImageButton settingsButton;

    public static EmptyFragment create() {
        return new EmptyFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_empty;
    }

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        userNameD = (TextView) root.findViewById(R.id.userNameD);
        settingsButton = (ImageButton) root.findViewById(R.id.settingsButton);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        userNameD.setText(user.getEmail());

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), SettingsActivity.class);
                view.getContext().startActivity(Intent);}
        });
    }
}
