package com.example.manuel.demos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.manuel.demos.models.Boulder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.parceler.Parcels;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;

public class ProblemData extends AppCompatActivity {

    Spinner spin;
    String[] datos = {"6a","6a+","6b","6b+","6c","6c+","7a","7a+","7b"};

    String grade;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String username = user.getEmail();

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

    public void upload(View v){
        EditText com = (EditText) findViewById(R.id.comments);
        EditText name = (EditText) findViewById(R.id.boudler_name);
        ImageView im = (ImageView) findViewById(R.id.imageView2);
        Bitmap bitIm = ((BitmapDrawable)im.getDrawable()).getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitIm.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Boulder boulder = new Boulder(username, name.getText().toString() , Calendar.getInstance().getTime(), grade, com.getText().toString(), byteArray);

        Intent intent = new Intent(this, BoulderViewer.class);
        intent.putExtra("boulder", Parcels.wrap(boulder));
        startActivity(intent);
    }
}
