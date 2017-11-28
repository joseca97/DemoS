package com.example.manuel.demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by manuel on 28/11/2017.
 */

public class ProblemDetailsActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_details);

        // Get title element
        TextView titleTextView = (TextView) findViewById(R.id.recipe_list_title);

        // Get subtitle element
        TextView subtitleTextView = (TextView) findViewById(R.id.recipe_list_subtitle);

        // Get detail element
        TextView commentTextView = (TextView) findViewById(R.id.comentariobloque);

        // Get detail element
        TextView gradeTextView = (TextView) findViewById(R.id.recipe_list_grade);
        // 1
        String name = this.getIntent().getExtras().getString("name");
        String uploader = this.getIntent().getExtras().getString("uploader");
        String grade = this.getIntent().getExtras().getString("points");
        String comments = this.getIntent().getExtras().getString("comments");


        titleTextView.setText(name);
        subtitleTextView.setText(uploader);
        commentTextView.setText(comments);
        gradeTextView.setText(grade);

    }
}
