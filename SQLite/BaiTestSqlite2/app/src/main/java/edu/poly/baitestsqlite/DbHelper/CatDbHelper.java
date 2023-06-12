package edu.poly.baitestsqlite.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CatDbHelper extends SQLiteOpenHelper {
    // tạo name và version
    private static final String DB_NAME = "Quan ly Cat";
    private static final int DB_VERSION = 1;

    public CatDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    } // truy tai nguyen cua lớp tạo và name version


    // tạo ra table hoặc insert , delete, update như sql bình thường execSQL để truy vấn
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_tbl_cat = "CREATE TABLE tb_cat ( id INTEGER NOT NULL, name TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql_tbl_cat);

        String sql_insert_cat = "INSERT INTO tb_cat(name) VALUES('Cá'), ('Mèo'), ('Gà') ";
        db.execSQL(sql_insert_cat);
    }


    // update phien ban
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
