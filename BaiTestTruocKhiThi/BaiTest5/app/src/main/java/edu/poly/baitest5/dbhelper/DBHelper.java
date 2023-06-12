package edu.poly.baitest5.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "dulieusv";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE sv(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)";
        db.execSQL(sql);

        sql = "INSERT INTO sv(id, name) VALUES(1, 'hihi')";
        db.execSQL(sql);
        sql = "INSERT INTO sv(id, name) VALUES(2, 'hihi1')";
        db.execSQL(sql);
        sql = "INSERT INTO sv(id, name) VALUES(3, 'hihi2')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
