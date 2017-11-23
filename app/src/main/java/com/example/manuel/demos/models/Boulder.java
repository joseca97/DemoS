package com.example.manuel.demos.models;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joseca on 23/11/17.
 */




public class Boulder implements Parcelable {
    public FirebaseUser uploader;
    public Date date;
    public String grade;
    public String name;
    public String comment;
    public byte[] image;
    public int ascents;
    public int points;      //Out of 5. Given by the community.

    transient public ArrayList<FirebaseUser> senders;

    public Boulder(FirebaseUser user,String name, Date date, String gra, String com, byte[] img){
        this.uploader = user;
        this.date = date;
        this.grade = gra;
        this.comment = com;
        this.image = img;
        this.name = name;

    }


    public Boulder(Parcel in) {

    }

    public static final Creator<Boulder> CREATOR = new Creator<Boulder>() {
        @Override
        public Boulder createFromParcel(Parcel in) {
            return new Boulder(in);
        }

        @Override
        public Boulder[] newArray(int size) {
            return new Boulder[size];
        }
    };

    //A user send a problem. Video, to demostrate it
    public void addAscent(FirebaseUser sender, int point){
        this.senders.add(sender);
        points = ((senders.size()-1)*points + point)/senders.size();        // Average points.
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
