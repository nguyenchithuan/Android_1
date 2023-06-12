package edu.poly.baitest5.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import edu.poly.baitest5.Objects.Student;
import edu.poly.baitest5.dbhelper.DBHelper;

public class StudentDAO {
    // dao dùng để quản lý các thao tác insert update delete query

    private SQLiteDatabase db; // chứa các phương thức thao tác csdl

    public StudentDAO(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase(); // đọc và ghi dữ liệu vào database
    }

    public ArrayList<Student> getData(String sql, String ...selectionArgs) {
        ArrayList<Student> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Student student = new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));

                list.add(student);

                cursor.moveToNext();
            }
            cursor.close();
        }


        return list;
    }


    public ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();

        list = getData("SELECT * FROM sv");

        return list;
    }

    public Student getOne(int id) {
        ArrayList<Student> list = new ArrayList<>();

        list = getData("SELECT * FROM sv WHERE id = ?", id + "");

        return list.get(0);
    }


    public long inset(Student student) {
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        return db.insert("sv", null, values);
    }

    public int update(Student student) {
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        return db.update("sv", values, "id = ?", new String[] {student.getId() + ""});
    }

    public int delete(int id) {
        return db.delete("sv", "id = ?", new String[] {id + ""});
    }

}
