package edu.poly.baitestamsignment.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.baitestamsignment.DTO.Sv;
import edu.poly.baitestamsignment.DbHelper.DbHelper;

public class SvDao {
    SQLiteDatabase db;

    public SvDao(Context context) {
        DbHelper helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ArrayList<Sv> selectAll() {
        ArrayList<Sv> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM sv", null);

        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                Sv sv = new Sv();
                sv.setId(cursor.getInt(0));
                sv.setHoTen(cursor.getString(1));
                sv.setSdt(cursor.getString(2));
                sv.setMaLop(cursor.getString(3));
                list.add(sv);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return list;
    }

    public Sv getOne(int id) {
        Sv sv = new Sv();
        Cursor cursor = db.rawQuery("SELECT * FROM sv WHERE id = ?", new String[] { id + "" });
        if(cursor.moveToFirst()) {
            sv.setId(cursor.getInt(0));
            sv.setHoTen(cursor.getString(1));
            sv.setSdt(cursor.getString(2));
            sv.setMaLop(cursor.getString(3));
        }
        cursor.close();
        return sv;
    }

    public long insert(Sv sv) {
        ContentValues values = new ContentValues();
        values.put("hoTen", sv.getHoTen());
        values.put("sdt", sv.getSdt());
        values.put("maLop", sv.getMaLop());
        return db.insert("sv", null, values);
    }

    public int update(Sv sv) {
        ContentValues values = new ContentValues();
        values.put("hoTen", sv.getHoTen());
        values.put("sdt", sv.getSdt());
        values.put("maLop", sv.getMaLop());
        return db.update("sv", values, "id = ?", new String[] { sv.getId() + ""});
    }

    public int delete(Sv sv) {
        return db.delete("sv", "id = ?", new String[] { sv.getId() + ""});
    }
}
