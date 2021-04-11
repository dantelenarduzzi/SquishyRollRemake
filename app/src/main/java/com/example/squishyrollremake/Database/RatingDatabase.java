package com.example.squishyrollremake.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.squishyrollremake.pojo.Rating;

import java.util.ArrayList;

public class RatingDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Rating";

    public static final String TABLE_RATING = "rating";

    public static final String COLUMN_ID = "id";

    public static final String COLUMN_NAME = "title"; //title
    public static final String COLUMN_DESC = "synopsis"; // description


    public static final String CREATE_Rating_TABLE = "CREATE TABLE " +
            TABLE_RATING + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT, " + COLUMN_DESC +" TEXT)";

    public RatingDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // CRUD
    public void addRating (Rating Rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, Rating.getName());
        values.put(COLUMN_DESC, Rating.getDescription());
        db.insert(TABLE_RATING, null, values);
        db.close();
    }

    public Rating getRating(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Rating Rating = null;
        Cursor cursor = db.query(TABLE_RATING,
                new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_DESC, }, COLUMN_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null);




        if(cursor.moveToFirst()){
            Rating = new Rating (
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2));
        }
        db.close();
        return Rating;


    }
    public ArrayList<Rating> getAllRating(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_RATING, null);
        ArrayList<Rating> Ratings = new ArrayList<>();
        while (cursor.moveToNext()){
            Ratings.add(new Rating(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)));
        }
        db.close();
        return Ratings;
    }

    public int updateRating(Rating Rating) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, Rating.getName());
        values.put(COLUMN_DESC, Rating.getDescription());
        return db.update(TABLE_RATING, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(Rating.getId())});
    }

    public void deleteRating(int Rating){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RATING, COLUMN_ID +  "=?",
                new String[]{String.valueOf(Rating)});
        db.close();
    }
}

