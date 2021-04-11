package com.example.squishyrollremake.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Rating implements Parcelable {


    // Reason for this second database is so that the data from the users ratings is stored separately

    private String Name;
    private String Description;
    private int id;

    public Rating(String Name, String Description){
        this.Name = Name;
        this.Description = Description;
    }


    public Rating(int id, String Name, String Description){
        this.Name = Name;
        this.Description = Description;
        this.id = id;
    }

    protected Rating(Parcel in) {
        Name = in.readString();
        Description = in.readString();
        id = in.readInt();
    }

    public Rating() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Description);
        dest.writeInt(id);
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel in) {
            return new Rating(in);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
