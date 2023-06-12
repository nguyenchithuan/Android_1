package edu.poly.nguyenchithuanph26023.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME= "data";
    private static final  int DB_VERSION = 1;

    public DbHelper (Context context) {
            super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE sinhvien (id INTEGER, ten TEXT NOT NULL, sdt TEXT NOT NULL, ghichu TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT)) ";

        db.execSQL(sql);

        String sql1 = "INSERT INTO sinhvien(ten, sdt, ghichu) VALUES('thuan', '0936146245', 'Tốt')";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
