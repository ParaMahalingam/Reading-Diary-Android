package com.ParaMahalingam.readingdiaryapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

public class Entry extends SQLiteOpenHelper {
    public static final String DB_Name = "Diary.db";

    public static final String TB_Name = "Entry";

    public static final String COL_ID = "ID";
    public static final String COL_BookTitle = "BookTitle";
    public static final String COL_Date = "Date";
    public static final String COL_PagesRead = "PagesRead";
    public static final String COL_ChildComment = "ChildComment";
    public static final String COL_TPComment = "TPComment";


    public Entry(Context context) {
        super(context, DB_Name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TB_Name + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_BookTitle + " TEXT," + COL_Date + " TEXT," + COL_PagesRead + " TEXT," + COL_ChildComment + " TEXT," + COL_TPComment + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TB_Name;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void addNewEntry(String title, String date, String pagesread, String childcomment, String tpcomment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();

        data.put(COL_BookTitle, title);
        data.put(COL_Date, date);
        data.put(COL_PagesRead, pagesread);
        data.put(COL_ChildComment, childcomment);
        data.put(COL_TPComment, tpcomment);

        db.insert(TB_Name, null, data);

        db.close();

    }
}