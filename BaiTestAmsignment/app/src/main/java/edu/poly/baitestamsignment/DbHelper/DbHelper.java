package edu.poly.baitestamsignment.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // chỉ để tạo sql và bảng table
    private static final String DB_NAME = "quanLy";
    private static final int DB_VERTION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERTION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // oncreate chi duoc chay 1 lan duy nhat
        String sql = "CREATE TABLE lop(maLop NVARCHAR(50) PRIMARY KEY, tenLop NVARCHAR(50) NOT NULL)";
        db.execSQL(sql);

        sql = "INSERT INTO lop(maLop, tenLop) VALUES('A1', 'Lop toan')";
        db.execSQL(sql);


        sql = "CREATE TABLE sv(id INTEGER NOT NULL, hoTen NVARCHAR(50) NOT NULL, sdt NVARCHAR(50) NOT NULL, maLop NVARCHAR(50) NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO lop(hoTen, sdt, maLop) VALUES('nguyen chi thuan', '0912341234', 'IT')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
