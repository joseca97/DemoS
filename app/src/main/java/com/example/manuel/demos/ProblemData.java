package com.example.manuel.demos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ProblemData extends AppCompatActivity {

    Spinner spin;
    String[] datos = {"6a","6a+","6b","6b+","6c","6c+","7a","7a+","7b"};

    String grade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_data);

        if(getIntent().hasExtra("image")){
            byte[] byteArray = getIntent().getByteArrayExtra("image");
            Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            ImageView imv = (ImageView) findViewById(R.id.imageView2);
            imv.setImageBitmap(image);
        }

        spin = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                grade = datos[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
