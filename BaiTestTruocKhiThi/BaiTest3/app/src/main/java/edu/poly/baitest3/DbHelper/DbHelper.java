package edu.poly.baitest3.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "DuLieu", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE xe(id INTEGER, tenXe TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO xe(tenXe) VALUES('DREAM')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
