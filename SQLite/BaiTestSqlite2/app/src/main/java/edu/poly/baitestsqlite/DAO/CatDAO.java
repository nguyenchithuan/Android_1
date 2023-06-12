package edu.poly.baitestsqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.baitestsqlite.DTO.Cat;
import edu.poly.baitestsqlite.DbHelper.CatDbHelper;

public class CatDAO { // thao tac với csdl
    CatDbHelper helper;
    SQLiteDatabase db;

    public CatDAO(Context context) {
        helper = new CatDbHelper(context);
        db = helper.getWritableDatabase(); // ghi dư liệu vào db để thao tác
    }

    public void close() {
        db.close(); // đóng csdl không cho thao tác
    }

    public ArrayList<Cat> selectAll() {
        ArrayList<Cat> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM tb_cat", null); // lấy dữ liệu

        if(c.moveToFirst()) { // kiểm tra xem có dữ liệu hay không, hoặc là đặt con trỏ về vị trí đầu tin
            while (!c.isAfterLast()) {
                Cat cat = new Cat();
                cat.setId(c.getInt(0));
                cat.setName(c.getString(1));
                list.add(cat);
                c.moveToNext();
            }
        }
        return list;
    }


    // trả về 1 row trong db
    public Cat selectOne(int id) {
        Cat cat = new Cat();

        String[] dieuKien = new String[]{id + ""};

        Cursor c = db.rawQuery("SELECT * FROM tb_cat WHERE id = ?", dieuKien);

        if(c.moveToFirst()) {
            cat.setId(c.getInt(0));
            cat.setName(c.getString(1));
        }

        return cat;
    }

    public long insertRow(Cat cat) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", cat.getName());

        return db.insert("tb_cat", null, contentValues); // trả về id tự động tăng
    }

    public int updateRow(Cat cat) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", cat.getName());

        String[] dieuKien = new String[] { cat.getId() + ""};

        return db.update("tb_cat", contentValues, "id = ?", dieuKien);
    }


    public int deleteRow(Cat cat) {
        return db.delete("tb_cat", "id = ?", new String[]{ cat.getId() + ""});
    }
}
