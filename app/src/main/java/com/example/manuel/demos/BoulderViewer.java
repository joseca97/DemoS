package com.example.manuel.demos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuel.demos.models.Boulder;

import org.parceler.Parcels;

public class BoulderViewer extends AppCompatActivity implements View.OnClickListener {
    Boulder boulder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boulder_viewer);

        if(getIntent().hasExtra("boulder")){
            boulder = Parcels.unwrap(getIntent().getParcelableExtra("boulder"));
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

            TextView user = (TextView) findViewById(R.id.userview);
            user.setText(boulder.uploader);

            findViewById(R.id.boulderViewer).setOnClickListener(this);
        }


    }
    public void onClick(View v){
        if(v.getId() == R.id.boulderViewer){
            Intent intent = new Intent(this, FullViewActivity.class);
            intent.putExtra("image", boulder.image);
            startActivity(intent);
        }
    }

}
