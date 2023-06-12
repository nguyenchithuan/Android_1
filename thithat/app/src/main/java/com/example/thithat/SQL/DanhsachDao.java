package com.example.thithat.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thithat.Adapter.Danhsanh;

import java.util.ArrayList;


public class DanhsachDao {
    private SQLiteDatabase db;
    public DanhsachDao(Context context){
        DanhsachSQLite danhsachSQLite = new DanhsachSQLite(context);
        db= danhsachSQLite.getWritableDatabase();
    }
    public ArrayList<Danhsanh> getAll(){
        ArrayList<Danhsanh> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM danhsach",null);
        if(cursor.moveToFirst()){
            while (cursor.isAfterLast()==false){
                Danhsanh ds = new Danhsanh();
                ds.setName(cursor.getString(0));
                ds.setNghe(cursor.getString(1));
                list.add(ds);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return  list;
    }
    public long them(Danhsanh danhsanh){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",danhsanh.getName());
        contentValues.put("nghe",danhsanh.getNghe());
        return  db.insert("danhsanh",null,contentValues);

    }
    public int update(Danhsanh danhsanh){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",danhsanh.getName());
        contentValues.put("nghe",danhsanh.getNghe());
        return db.update("danhsanh",contentValues,"name = ?",new String[]{danhsanh.getName()});
    }

    public int xoa(Danhsanh danhSach) {
        return db.delete("danhsach", "name = ?", new String[] {danhSach.getName()});
    }
}
