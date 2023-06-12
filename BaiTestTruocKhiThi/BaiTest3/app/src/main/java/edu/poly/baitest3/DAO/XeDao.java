package edu.poly.baitest3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.baitest3.DTO.Xe;
import edu.poly.baitest3.DbHelper.DbHelper;

public class XeDao {
    SQLiteDatabase db;

    public XeDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<Xe> selectAll() {
        ArrayList<Xe> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM xe", null);
        if(cursor.moveToFirst()) {
           while (!cursor.isAfterLast()) {
                Xe xe = new Xe();
                xe.setId(cursor.getInt(0));
                xe.setTenXe(cursor.getString(1));
                list.add(xe);
                cursor.moveToNext();
           }
        }
        return list;
    }

    public long insert(Xe xe) {
        ContentValues values = new ContentValues();
        values.put("tenXe", xe.getTenXe());
        return db.insert("xe", null, values);
    }

    public int update(Xe xe) {
        ContentValues values = new ContentValues();
        values.put("tenXe", xe.getTenXe());
        return  db.update("xe", values, "id = ?", new String[] {xe.getId() + ""});
    }

    public int delete(Xe xe) {
        return  db.delete("xe","id = ?", new String[] {xe.getId() + ""});
    }
}
