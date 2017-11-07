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
        Intent intent = getIntent();
        String picture = (String)getIntent().getExtras().get("image");


        TextView tv = (TextView) findViewById(R.id.textViewColoreable);
        if(tv != null)
            tv.setText(picture);


        File imgFile = new File(picture);
        if(imgFile.exists()) {
            Bitmap myBitMap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView iv = (ImageView) findViewById(R.id.image_coloreable);

            if (iv != null)
                iv.setImageBitmap(myBitMap);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloreable);
    }
}
