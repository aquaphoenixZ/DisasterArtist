package com.DisasterArtist.disaster;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "disaster.db";
    public static final String TABLE_NAME = "disaster_table";
    public static final String COL_1 = "DISASTER_ID";
    public static final String COL_2 = "DISASTER_NAME";

    public static final String COL_3 = "TIP_1";
    public static final String COL_4 = "TIP_2";
    public static final String COL_5 = "TIP_3";
    public static final String COL_6 = "TIP_4";

    public static final String COL_7 = "CHECKLIST_1";
    public static final String COL_8 = "CHECKLIST_2";
    public static final String COL_9 = "CHECKLIST_3";
    public static final String COL_10 = "CHECKLIST_4";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 +
                " TEXT, " + COL_3 + " TEXT, "+ COL_4+ " TEXT, " + COL_5 + " TEXT, "+ COL_6 + " TEXT, " + COL_7 + " TEXT, " +
                COL_8 + " TEXT," + COL_9 + " TEXT, " + COL_10 + "  TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
