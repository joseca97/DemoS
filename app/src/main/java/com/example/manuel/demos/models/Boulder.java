package com.example.manuel.demos.models;

import android.graphics.Bitmap;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joseca on 23/11/17.
 */




public class Boulder {
    FirebaseUser uploader;
    Date date;
    String grade;
    String comment;
    Bitmap image;
    int ascents;
    int points;      //Out of 5. Given by the community.

    ArrayList<FirebaseUser> senders;

    public Boulder(FirebaseUser user, Date date, String gra, String com, Bitmap img){
        this.uploader = user;
        this.date = date;
        this.grade = gra;
        this.comment = com;
        this.image = img;

    }


    //A user send a problem. Video, to demostrate it
    public void addAscent(FirebaseUser sender, int point){
        this.senders.add(sender);
        points = ((senders.size()-1)*points + point)/senders.size();        // Average points.
    }
}
