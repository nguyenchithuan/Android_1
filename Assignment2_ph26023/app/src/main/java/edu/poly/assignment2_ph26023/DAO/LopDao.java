package edu.poly.assignment2_ph26023.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.assignment2_ph26023.DTO.Lop;
import edu.poly.assignment2_ph26023.DbHelper.DbHelper;

public class LopDao {
    SQLiteDatabase db;

    public LopDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase(); // mở dữ liệu nếu không có thì tự động tạo
    }

    public ArrayList<Lop> selectAll() {
        ArrayList<Lop> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM lop", null);
        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Lop lop = new Lop();
                lop.setStt(cursor.getInt(0));
                lop.setMaLop(cursor.getString(1));
                lop.setTenLop(cursor.getString(2));

                list.add(lop);
                cursor.moveToNext();
            }
        }
        return list;
    }

    public Lop selectByMaLop(int stt) {
        Lop lop = new Lop();
        Cursor cursor = db.rawQuery("SELECT * FROM lop WHERE stt = ?", new String[] { stt + ""});
        if(cursor.moveToFirst()) {
            lop.setStt(cursor.getInt(0));
            lop.setMaLop(cursor.getString(1));
            lop.setTenLop(cursor.getString(2));
        }
        return lop;
    }

    public long insert(Lop lop) {
        ContentValues values = new ContentValues();
        values.put("maLop", lop.getMaLop());
        values.put("tenLop", lop.getTenLop());
        return db.insert("lop", null, values);
    }

    public int update(Lop lop) {
        ContentValues values = new ContentValues();
        values.put("maLop", lop.getMaLop());
        values.put("tenLop", lop.getTenLop());
        return db.update("lop", values, "stt = ?", new String[] { lop.getStt() + ""});
    }

    public int delete(Lop lop) {
        return  db.delete("lop", "stt = ?", new String[] { lop.getStt() + ""});
    }

}
