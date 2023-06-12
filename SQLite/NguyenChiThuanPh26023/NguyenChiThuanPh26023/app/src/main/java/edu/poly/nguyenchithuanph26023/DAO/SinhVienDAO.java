package edu.poly.nguyenchithuanph26023.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.nguyenchithuanph26023.DTO.SinhVien;
import edu.poly.nguyenchithuanph26023.DbHelper.DbHelper;

public class SinhVienDAO {
    private SQLiteDatabase db;

    public SinhVienDAO (Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM sinhvien", null);
        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                SinhVien sv = new SinhVien();
                sv.setId(cursor.getInt(0));
                sv.setHoTen(cursor.getString(1));
                sv.setSodt(cursor.getString(2));
                sv.setGhiChu(cursor.getString(3));
                list.add(sv);
                cursor.moveToNext();
            }
        }
        return list;
    }

    public SinhVien getById(int id) {
        SinhVien sv = new SinhVien();
        Cursor cursor =  db.rawQuery("SELECT * FROM sinhvien WHERE id = ?", new String[] { id + ""});

        if(cursor.moveToFirst()) {
            sv.setId(cursor.getInt(0));
            sv.setHoTen(cursor.getString(1));
            sv.setSodt(cursor.getString(2));
            sv.setGhiChu(cursor.getString(3));
        }
        return sv;
    }

    public long insert(SinhVien sv) {
        ContentValues values = new ContentValues();
        values.put("ten", sv.getHoTen());
        values.put("sdt", sv.getSodt());
        values.put("ghichu", sv.getGhiChu());

        return db.insert("sinhvien", null, values);
    }

    public int update(SinhVien sv) {
        ContentValues values = new ContentValues();
        values.put("ten", sv.getHoTen());
        values.put("sdt", sv.getSodt());
        values.put("ghichu", sv.getGhiChu());
        return db.update("sinhvien", values, "id = ?", new String[]{ sv.getId() + ""});
    }

    public int delete(SinhVien sv) {
        return db.delete("sinhvien", "id = ?", new String[] { sv.getId() + ""});
    }

}




