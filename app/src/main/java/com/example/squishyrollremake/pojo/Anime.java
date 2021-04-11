package com.example.squishyrollremake.pojo;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Anime implements Parcelable {
    private String titles;
    private String posterImage;
    private String synopsis;
    private int id;

    public Anime(String titles, String posterImage, String synopsis){
        this.titles = titles;
        this.posterImage = posterImage;
        this.synopsis = synopsis;
    }


    public Anime(int id, String titles, String posterImage, String synopsis){
        this.titles = titles;
        this.posterImage = posterImage;
        this.synopsis = synopsis;
        this.id = id;
    }

    protected Anime(Parcel in) {
        titles = in.readString();
        posterImage = in.readString();
        synopsis = in.readString();
        id = in.readInt();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titles);
        dest.writeString(posterImage);
        dest.writeString(synopsis);
        dest.writeInt(id);
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

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
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

    @Override
    public int describeContents() {
        return 0;
    }

}
