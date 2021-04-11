package com.example.squishyrollremake.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

import androidx.annotation.Nullable;

import com.example.squishyrollremake.pojo.Anime;

import java.util.ArrayList;


public class AnimeDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "kitsu";

    public static final String TABLE_ANIME = "anime";

    public static final String COLUMN_ID = "id";

    public static final String COLUMN_TITLE = "titles"; //title
    public static final String COLUMN_IMAGE = "posterImage"; // poster image
    public static final String COLUMN_DESC = "synopsis"; // description


    public static final String CREATE_ANIME_TABLE = "CREATE TABLE " +
            TABLE_ANIME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_TITLE + " TEXT, " + COLUMN_DESC + " TEXT, " +
            COLUMN_IMAGE + " TEXT)";

    public AnimeDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // CRUD
    public void addAnime(Anime Anime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, Anime.getTitles());
        values.put(COLUMN_DESC, Anime.getSynopsis());
        values.put(COLUMN_IMAGE, Anime.getPosterImage());
        db.insert(TABLE_ANIME, null, values);
        db.close();
    }

    public Anime getAnime(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Anime Anime = null;
        Cursor cursor = db.query(TABLE_ANIME,
                new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_DESC, COLUMN_IMAGE}, COLUMN_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null);




        if(cursor.moveToFirst()){
            Anime = new Anime(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
        }
        db.close();
        return Anime;


}
    public ArrayList<Anime> getAllAnime(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ANIME, null);
        ArrayList<Anime> Animees = new ArrayList<>();
        while (cursor.moveToNext()){
            Animees.add(new Anime(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            ));
        }
        db.close();
        return Animees;
    }

    public int updateAnime(Anime Anime) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, Anime.getTitles());
        values.put(COLUMN_DESC, Anime.getSynopsis());
        values.put(COLUMN_IMAGE, Anime.getPosterImage());
        return db.update(TABLE_ANIME, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(Anime.getId())});
    }

    public void deleteAnime(int Anime){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ANIME, COLUMN_ID +  "=?",
                new String[]{String.valueOf(Anime)});
        db.close();
    }
}
