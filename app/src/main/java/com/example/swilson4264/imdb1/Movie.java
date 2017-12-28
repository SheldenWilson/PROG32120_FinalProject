package com.example.swilson4264.imdb1;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by swilson4264 on 12/5/2017.
 */
@Entity
public class Movie {

    @PrimaryKey
    public final int id;
    public String mName;
    public String mDescription;
    //public String mAgeRating;
    //public String mGenre;


    public int getId() {
        return id;
    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {this.mName = mName; }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

//    public String getmAgeRating() {
//        return mAgeRating;
//    }
//
//    public void setmAgeRating(String mAgeRating) {
//        this.mAgeRating = mAgeRating;
//    }
//
//    public String getmGenre() {
//        return mGenre;
//    }
//
//    public void setmGenre(String mGenre) {
//        this.mGenre = mGenre;
//    }




    public Movie(int id, String mName, String mDescription) {
        this.id = id;
        this.mName = mName;
        this.mDescription = mDescription;
        //this.mAgeRating = mAgeRating;
       // this.mGenre = mGenre;

    }


}
