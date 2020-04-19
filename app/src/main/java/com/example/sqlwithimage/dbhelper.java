package com.example.sqlwithimage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contact";
    private static final int DATABASE_VERSION = 1;
    public static final String SCORE_TABLE_NAME = "contact";
    public static final String NAME = "name";
    public static final String EMAIL ="email";
    public static final String NUMBER = "number";
    public static final String IMAGE = "image";

    private static final String CREATE_QUERY = "CREATE TABLE "+ SCORE_TABLE_NAME+"("+ NAME+" Text,"
            + EMAIL+" Text,"+ NUMBER+" Text, " + IMAGE + " BLOB);";
    // pay attention to spacing carefully 


    public dbhelper(@Nullable Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void addInformation(String name, String email, String number, byte[] image, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(NUMBER, number);
        db.insert(SCORE_TABLE_NAME, null, contentValues);
    }

    public Cursor getInformation(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {NAME, EMAIL, NUMBER};
        String order = NUMBER;
        cursor = db.query(SCORE_TABLE_NAME, projections, null, null, null, null,order);
        return cursor;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
