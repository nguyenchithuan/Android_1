package edu.poly.sqlitetrencuangoc.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "data";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_tbl = "CREATE TABLE nhanvien(id TEXT PRIMARY KEY, name TEXT NOT NULL, salary REAL NOT NULL)";
        db.execSQL(create_tbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS nhanvien";
        db.execSQL(sql);
        onCreate(db);
    }
}
