package edu.poly.sqlitetrencuangoc.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.poly.sqlitetrencuangoc.Model.Employee;

public class EmployeeDao {
    SQLiteDatabase db;

    public EmployeeDao(Context context) {
        DbHelper helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public List<Employee> get(String sql, String ...thuocTinh) { // thuoc tinh giong nhu mang String
        List<Employee> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, thuocTinh);
        if(c.moveToFirst()) {
            while (!c.isAfterLast()) {
                Employee e = new Employee();
                e.setId(c.getString(0));
                e.setName(c.getString(1));
                e.setSalary(c.getDouble(2));
                list.add(e);
                c.moveToNext();
            }
        }
        return list;
    }

    public List<Employee> getAll() {
        String sql = "SELECT * FROM nhanvien";
        return get(sql);
    }

    public Employee getById(String id) {
        String sql = "SELECT * FROM nhanvien WHERE id = ?";
        List<Employee> list = get(sql, id);
        return list.get(0);
    }

    public long inser(Employee e) {
        ContentValues values = new ContentValues();
        values.put("id", e.getId());
        values.put("name", e.getName());
        values.put("salary", e.getSalary());

        return db.insert("nhanvien", null, values);
    }

    public int update(Employee e) {
        ContentValues values = new ContentValues();
        values.put("name", e.getName());
        values.put("salary", e.getSalary());

        return db.update("nhanvien", values, "id = ?", new String[] { e.getId() });
    }

    public int delete(Employee e) {
        return db.delete("nhanvien", "id = ?", new String[] {e.getId()});
    }
}
