package com.example.squishyrollremake.pojo;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Anime implements Parcelable {
    private String titles;
    private String synopsis;
    private int id;

    public Anime(String titles, String synopsis){
        this.titles = titles;
        this.synopsis = synopsis;
    }

    //create object to read from db

    public Anime(int id, String titles,String synopsis){
        this.titles = titles;
        this.synopsis = synopsis;
        this.id = id;
    }

    protected Anime(Parcel in) {
        titles = in.readString();
        synopsis = in.readString();
        id = in.readInt();
    }


    public Anime(){

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titles);
        dest.writeString(synopsis);
        dest.writeInt(id);
    }
    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    }
