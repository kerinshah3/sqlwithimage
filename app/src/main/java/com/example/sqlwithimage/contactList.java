package com.example.sqlwithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class contactList extends AppCompatActivity {
    ListView contactList;
    contactapdpter contactapdpter;
    ArrayList<pojocontact> list;
    SQLiteDatabase mSQLiteDatabase;
    dbhelper dbhelper;
    Cursor mCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        list = new ArrayList<>();
        contactList = findViewById(R.id.contactlist);
        contactapdpter = new contactapdpter(this, R.layout.contact,list);
        contactList.setAdapter(contactapdpter);
        getinfo();
    }

    private void getinfo() {

        dbhelper = new dbhelper(getApplicationContext());
        mSQLiteDatabase = dbhelper.getReadableDatabase();
        mCursor = dbhelper.getInformation(mSQLiteDatabase);

        if (mCursor.moveToFirst()) {
            do {
                String userName = mCursor.getString(0);
                String score = mCursor.getString(1);
                String date = mCursor.getString(2);
                pojocontact pojocontact = new pojocontact(userName, score, date);
                list.add(pojocontact);
            } while (mCursor.moveToNext());
        }

    }
}
