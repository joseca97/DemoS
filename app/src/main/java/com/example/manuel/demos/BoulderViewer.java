package com.example.manuel.demos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuel.demos.models.Boulder;

public class BoulderViewer extends AppCompatActivity {
    Boulder boulder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boulder_viewer);

        if(getIntent().hasExtra("boulder")){
            boulder = (Boulder) getIntent().getSerializableExtra("boulder");
        }

        if(boulder != null){
            ImageView imV = (ImageView) findViewById(R.id.boulderViewer);
            byte[] byteArray = boulder.image;
            Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imV.setImageBitmap(image);

            TextView name = (TextView) findViewById(R.id.boulderName);
            name.setText(boulder.name);

            TextView grade = (TextView) findViewById(R.id.gradeView);
            grade.setText(boulder.grade);

            TextView comments = (TextView) findViewById(R.id.commentView);
            comments.setText(boulder.comment);

        }

    }
}
