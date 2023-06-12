package edu.poly.baitest4.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.baitest4.DTO.Xe;
import edu.poly.baitest4.DbHelper.DbHelper;

public class XeDao { // dùng để thao tác tới csdl như select, update, delete, insert
    SQLiteDatabase db;

    public XeDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase(); // dùng để tạo csdl nếu chưa có, còn có rồi thì chạy lại
    }

    public ArrayList<Xe> selectAll() {
        ArrayList<Xe> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM xe", null); // select
        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
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
        return db.update("xe", values, "id = ?", new String[] {xe.getId() + ""});
    }

    public int delete(Xe xe) {
        return db.delete("xe","id = ?", new String[] {xe.getId() + ""});
    }

}
