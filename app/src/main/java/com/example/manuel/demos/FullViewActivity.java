package com.example.manuel.demos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        if(getIntent().hasExtra("image")){
            ImageView imv = (ImageView) findViewById(R.id.fullviewimage);
            byte[] byteArray = getIntent().getByteArrayExtra("image");
            Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imv.setImageBitmap(image);
        }
    }
}
