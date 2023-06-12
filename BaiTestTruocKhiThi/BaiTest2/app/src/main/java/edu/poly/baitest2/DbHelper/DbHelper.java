package edu.poly.baitest2.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "duLieu", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE vatTu(tenVatTu TEXT PRIMARY KEY, giaTien REAL NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO vatTu VALUES('Go', 123.2)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
