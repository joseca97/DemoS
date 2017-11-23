package com.example.manuel.demos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.manuel.demos.adapter.MainPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    private MainPagerAdapter adapter;
    private ViewPager viewPager;

    private View background;

    private int colorBlackOverlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };


        adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.ag_view_pager);
        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(1);

        background = findViewById(R.id.ag_background_view);
        colorBlackOverlay = ContextCompat.getColor(this, R.color.black_overlay);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            float sumPositionAndPositionOffset;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(position==0) {
//                    background.setBackgroundColor(colorBlackOverlay);
//                    background.setAlpha(1 - positionOffset);
//                } else {
//                    background.setBackgroundColor(colorBlackOverlay);
//                    background.setAlpha(positionOffset);
//                }

                if(position + positionOffset > sumPositionAndPositionOffset) {
                    background.setBackgroundColor(colorBlackOverlay);
                    background.setAlpha(1 - positionOffset);
                } else {
                    background.setBackgroundColor(colorBlackOverlay);
                    background.setAlpha(positionOffset);
                }
                sumPositionAndPositionOffset = position + positionOffset;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void signOut() {
        auth.signOut();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);

        FirebaseUser user = auth.getCurrentUser();
        updateUI(user);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    private void updateUI(FirebaseUser user) {


    }

    Uri imageUri;
    final int TAKE_PICTURE = 115;

    public void toCamera(View view){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File photoFile = new File(Environment.getExternalStorageDirectory(), "Photo.png");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));

        imageUri = Uri.fromFile(photoFile);
        startActivityForResult(intent, TAKE_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImageUri = imageUri;
                    //Do what ever you want
                }
        }
    }


    public void buttonColoreable(View v){
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.no_image_found);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Intent intent = new Intent(this, ColoreableActivity.class);
        intent.putExtra("image", byteArray);
        startActivity(intent);
    }

}
