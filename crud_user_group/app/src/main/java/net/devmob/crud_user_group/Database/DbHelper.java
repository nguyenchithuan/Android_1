package net.devmob.crud_user_group.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static  final  String DB_NAME = "crud_user_group";
    static  final int DB_VERSION = 1;

    public DbHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tb_group( id_group INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL UNIQUE ); ";
        sqLiteDatabase.execSQL(sql);

        // tạo bảng user
        sql = "CREATE TABLE tb_user(  id_user INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  username TEXT NOT NULL UNIQUE, password TEXT NOT NULL, email TEXT NOT NULL, fullname TEXT, id_group INTEGER NOT NULL ); ";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
