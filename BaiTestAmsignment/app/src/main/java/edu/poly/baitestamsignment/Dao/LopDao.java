package edu.poly.baitestamsignment.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import edu.poly.baitestamsignment.DTO.Lop;
import edu.poly.baitestamsignment.DbHelper.DbHelper;

public class LopDao {
    // là lớp dùng để thao tác đến csdl như insert, delete, update, select
    private SQLiteDatabase db;

    public LopDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase(); // để lấy dữ liệu từ cơ sử dữ liệu
        // nếu chứ có thì tự tạo
    }

    public ArrayList<Lop> selectAll() {
        ArrayList<Lop> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM lop", null);
        if(cursor.moveToFirst()) {
            while(!cursor.isAfterLast()) {
                Lop lop = new Lop();
                lop.setMaLop(cursor.getString(0));
                lop.setTenLop(cursor.getString(1));
                list.add(lop);

                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public Lop selectOne(String maLop) {
        Lop lop = new Lop();
        Cursor cursor = db.rawQuery("SELECT * FROM lop WHERE maLop = ?", new String[] { maLop });
        if(cursor.moveToFirst()) {
            lop.setMaLop(cursor.getString(0));
            lop.setTenLop(cursor.getString(1));
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

        return db.update("lop", values, "maLop = ?", new String[] { lop.getMaLop() });
    }

    public int delete(Lop lop) {
        return db.delete("lop", "maLop = ?", new String[] { lop.getMaLop() });
    }

}
