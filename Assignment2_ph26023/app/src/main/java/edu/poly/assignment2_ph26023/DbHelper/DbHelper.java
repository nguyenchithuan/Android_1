package edu.poly.assignment2_ph26023.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "DuLieuSinhVien";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE lop(stt INTEGER NOT NULL , maLop TEXT NOT NULL, tenLop TEXT NOT NULL, PRIMARY KEY(stt AUTOINCREMENT) )";
        db.execSQL(sql);

        sql = "INSERT INTO lop(maLop, tenLop) VALUES('IT', 'Cong nghe thong tin')";
        db.execSQL(sql);

        sql = "CREATE TABLE sv(stt INTEGER NOT NULL, maLop TEXT NOT NULL, tenSv TEXT NOT NULL, ngaySinh TEXT NOT NULL, sdt TEXT NOT NULL, gioiTinh TEXT NOT NULL, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO sv(maLop, tenSv, ngaySinh, sdt, gioiTinh) VALUES('IT', 'Nguyen Chi Thuan', '20-10-2003', '09123432421', 'Nam')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
