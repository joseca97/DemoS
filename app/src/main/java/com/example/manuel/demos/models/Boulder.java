package com.example.manuel.demos.models;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.parceler.ParcelConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joseca on 23/11/17.
 */



@org.parceler.Parcel
public class Boulder {
    public String uploader;
    public Date date;
    public String grade;
    public String name;
    public String comment;
    public byte[] image;
    public int ascents;
    public int points;      //Out of 5. Given by the community.

    public ArrayList<FirebaseUser> senders;

    public Boulder(){


    }

    public Boulder(String user, String name, Date date, String gra, String com, byte[] img) {
        this.uploader = user;
        this.date = date;
        this.grade = gra;
        this.comment = com;
        this.image = img;
        this.name = name;

    }

}
