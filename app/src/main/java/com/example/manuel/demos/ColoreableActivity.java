package com.example.manuel.demos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ColoreableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloreable);

        Intent intent = getIntent();
        Bitmap image_bitmap = (Bitmap)getIntent().getExtras().get("image");

        ImageView myImView = (ImageView) findViewById(R.id.image_coloreable);
        if(image_bitmap != null){
            myImView.setImageBitmap(image_bitmap);
        } else {
            myImView.setImageResource(R.drawable.no_image_found);
        }


    }
}
