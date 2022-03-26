package com.achu.lab_2_q_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper3 extends SQLiteOpenHelper {
    public static final String DBNAME = "biriyani.db";
    public DBHelper3(Context context) {
        super(context, "biriyani.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table biriyani(TYPE TEXT, NOG TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists biriyani");
        onCreate(MyDB);
    }

    public Boolean insertData(String type, String nog){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("TYPE", type);
        contentValues.put("NOG", nog);
        long result = MyDB.insert("biriyani", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM biriyani", null);
        return res;

    }
}