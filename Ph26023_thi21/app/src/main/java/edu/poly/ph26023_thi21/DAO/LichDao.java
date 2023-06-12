package edu.poly.ph26023_thi21.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.poly.ph26023_thi21.DTO.Lich;
import edu.poly.ph26023_thi21.DbHelper.DbHelper;

public class LichDao {
    SQLiteDatabase db;

    public LichDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<Lich> selectAll() {
        ArrayList<Lich> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM lich", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Lich lich = new Lich();

                lich.setId(cursor.getInt(0));
                lich.setTieuDe(cursor.getString(1));
                lich.setNoiDung(cursor.getString(2));
                lich.setThoiGian(cursor.getString(3));

                list.add(lich);

                cursor.moveToNext();
            }
        }

        return list;
    }


    public long insert(Lich lich) {
        ContentValues values = new ContentValues();
        values.put("tieuDu", lich.getTieuDe());
        values.put("noiDung", lich.getNoiDung());
        values.put("thoiGian", lich.getThoiGian());
        return db.insert("lich", null, values);
    }

    public int update(Lich lich) {
        ContentValues values = new ContentValues();
        values.put("tieuDu", lich.getTieuDe());
        values.put("noiDung", lich.getNoiDung());
        values.put("thoiGian", lich.getThoiGian());
        return db.update("lich", values, "id = ?", new String [] {lich.getId() + ""});

    }

    public int delete(Lich lich) {
        return db.delete("lich","id = ?", new String[] {lich.getId() + ""});
    }


}
