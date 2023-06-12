package edu.poly.baitest4.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // sqliteopenhelper dùng để quản lý csdl và bản

    public DbHelper(Context context) {
        super(context, "DuLieu", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // chỉ được tạo 1 lần duy nhất
        String sql = "CREATE TABLE xe(id INTEGER, tenXe TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO xe(tenXe) VALUES('JAV')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS xe";
        db.execSQL(sql);
        onCreate(db);
    }
}
