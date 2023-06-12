package edu.poly.assignment2_ph26023.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.assignment2_ph26023.DTO.Sv;
import edu.poly.assignment2_ph26023.DbHelper.DbHelper;

public class SvDao {
    SQLiteDatabase db;

    public SvDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<Sv> selectAll() {
        ArrayList<Sv> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM sv", null);

        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                Sv sv = new Sv();
                sv.setStt(cursor.getInt(0));
                sv.setMaLop(cursor.getString(1));
                sv.setTenSv(cursor.getString(2));
                sv.setNgaySinh(cursor.getString(3));
                sv.setSdt(cursor.getString(4));
                sv.setGioiTinh(cursor.getString(5));
                list.add(sv);

                cursor.moveToNext();
            }
        }

        return list;
    }

    public Sv getByStt(int stt) {
        Sv sv = new Sv();

        Cursor cursor = db.rawQuery("SELECT * FROM sv WHERE stt = ?", new String[] {stt + ""});

        if(cursor.moveToFirst()) {
            sv.setStt(cursor.getInt(0));
            sv.setMaLop(cursor.getString(1));
            sv.setTenSv(cursor.getString(2));
            sv.setNgaySinh(cursor.getString(3));
            sv.setSdt(cursor.getString(4));
            sv.setGioiTinh(cursor.getString(5));
        }
        return sv;
    }

    public long insert(Sv sv) {
        ContentValues values = new ContentValues();
        values.put("maLop", sv.getMaLop());
        values.put("tenSv", sv.getTenSv());
        values.put("ngaySinh", sv.getNgaySinh());
        values.put("sdt", sv.getSdt());
        values.put("gioiTinh", sv.getGioiTinh());

        return db.insert("sv", null, values);
    }

    public int update(Sv sv) {
        ContentValues values = new ContentValues();
        values.put("maLop", sv.getMaLop());
        values.put("tenSv", sv.getTenSv());
        values.put("ngaySinh", sv.getNgaySinh());
        values.put("sdt", sv.getSdt());
        values.put("gioiTinh", sv.getGioiTinh());

        return db.update("sv", values, "stt = ?", new String[] {sv.getStt() + ""});
    }

    public int delete(Sv sv) {
        return db.delete("sv", "stt = ?", new String[] {sv.getStt() + ""});
    }
}
