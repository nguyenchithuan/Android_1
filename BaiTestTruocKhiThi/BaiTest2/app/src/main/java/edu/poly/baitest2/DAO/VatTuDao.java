package edu.poly.baitest2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.baitest2.DTO.VatTu;
import edu.poly.baitest2.DbHelper.DbHelper;

public class VatTuDao {
    SQLiteDatabase db;

    public VatTuDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<VatTu> selectAll() {
        ArrayList<VatTu> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM vatTu", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                VatTu vatTu = new VatTu();

                vatTu.setTenVatTu(cursor.getString(0));
                vatTu.setGiaTien(cursor.getDouble(1));

                list.add(vatTu);
                cursor.moveToNext();
            }
        }

        return list;
    }

    public long insert(VatTu vatTu) {
        ContentValues values = new ContentValues();
        values.put("tenVatTu", vatTu.getTenVatTu());
        values.put("giaTien", vatTu.getGiaTien());

        return db.insert("vatTu", null, values);
    }

    public int update(VatTu vatTu) {
        ContentValues values = new ContentValues();
        values.put("tenVatTu", vatTu.getTenVatTu());
        values.put("giaTien", vatTu.getGiaTien());
        return db.update("vatTu", values, "tenVatTu = ?", new String[] {vatTu.getTenVatTu()});
    }

    public int delete(VatTu vatTu) {
        return db.delete("vatTu","tenVatTu = ?", new String[] {vatTu.getTenVatTu()});
    }
}
