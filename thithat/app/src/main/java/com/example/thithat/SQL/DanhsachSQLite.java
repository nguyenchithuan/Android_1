package com.example.thithat.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DanhsachSQLite extends SQLiteOpenHelper {
    private  static  final String db_name="nhat dep trai";
    private  static  final  int db_vision= 1 ;
    public DanhsachSQLite( Context context) {
        super(context, db_name,null,db_vision );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String data= "CREATE TABLE danhsach(name NVARCHAR(50) PRIMARY KEY, nghe NCHAR(20))";
        db.execSQL(data);

        data = "INSERT INTO danhsach(name,nghe) VALUES ('nhat1','sinh vien')";
        db.execSQL(data);
        data = "INSERT INTO danhsach(name,nghe) VALUES ('nhat2','sinh vien')";
        db.execSQL(data);
        data = "INSERT INTO danhsach(name,nghe) VALUES ('nhat3','sinh vien')";
        db.execSQL(data);
        data = "INSERT INTO danhsach(name,nghe) VALUES ('nhat4','sinh vien')";
        db.execSQL(data);
        data = "INSERT INTO danhsach(name,nghe) VALUES ('nhat5','sinh vien')";
        db.execSQL(data);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
