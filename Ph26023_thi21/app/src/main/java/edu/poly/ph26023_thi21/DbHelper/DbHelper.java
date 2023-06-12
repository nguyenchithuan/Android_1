package edu.poly.ph26023_thi21.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "DuLieu", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE lich(id INTEGER, tieuDu TEXT NOT NULL, noiDung TEXT NOT NULL, thoiGian TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO lich('tieuDu', 'noiDung', 'thoiGian') VALUES('Lưu ý', 'Ngủ nhá', '10:10PM')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
