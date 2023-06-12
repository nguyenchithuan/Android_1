package edu.poly.hocsqlitebaidau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.hocsqlitebaidau.DTO.Cat;
import edu.poly.hocsqlitebaidau.DbHelper.MyDbHelper;

public class CatDAO {
    SQLiteDatabase db;
    MyDbHelper dbHelper;




    // viết hàm khới tạo
    public CatDAO(Context context) {
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase(); // mở kết nối với csdl
        // nếu chưa có file csdl thì sẽ được tạo mới luôn
    }



    public void close()
    {
        db.close(); // đóng kết nối với csdl
    }

    // viết hàm lấy danh sách dữ liệu trong bảng tb_cat
    public ArrayList<Cat> selectAll() {
        // tạo ra 1 danh sách rỗng
        ArrayList<Cat> listCat = new ArrayList<Cat>();

        // viết lệnh SQL
        String sql = "SELECT * FROM tb_cat";

        // thực thi câu lệnh
        Cursor c = db.rawQuery(sql, null); // con trỏ

        // kiểm tra có dữ liệu thì lấy ra
        if(c.moveToFirst()) {
            // có dữ liệu
            while (!c.isAfterLast()) { // isAfterLast dưới dòng cuối cùng có giá trị null
                // tạo DTO để làm việc
                Cat objCat = new Cat();
                objCat.setId(c.getInt(0)); // c là đọc dữ liệu trong 1 ô theo column
                objCat.setName(c.getString(1));
                // vì mình tạo có 2 thuộc tính id, name lên index sẽ được đánh theo thức tự 0, 1

                // cho đối tượng vào danh sách
                listCat.add(objCat);

                // chuyển con trỏ đọc sang dòng tiếp theo
                c.moveToNext();
            }
        }
        return listCat;
    }



    // hàm lấy ra 1 dòng ==> trả về objCat --> đầu vào là id của dòng.
    public  Cat selectOne( int id){
        Cat objCat = null; // tạo đối tượng rỗng để tránh lỗi return

        String[] dieu_kien = new String[] { id + ""};
        // câu lệnh sql
        String sql = "SELECT id, name FROM tb_cat WHERE id = ? ";

        Cursor c = db.rawQuery(sql, dieu_kien);
        if(c.moveToFirst()){
            // có dữ liệu
            objCat = new Cat();
            objCat.setId(  c.getInt( 0 )  );
            objCat.setName( c.getString(1) );
        }
        return  objCat;
    }





    // hàm thêm mới: Đầu vào object chưa có ID
    public long insertRow (Cat objCat){
        // sử dụng contentValue để truyền dữ liệu vào câu lệnh
        ContentValues objContent = new ContentValues();
        objContent.put("name", objCat.getName());
        // thực hiện lệnh Insert
        return  db.insert("tb_cat", null, objContent); // trả về cái id tự động tăng (của insertRow)
    }




    // sửa: đầu vào obj cần có ID
    public int updateRow(Cat objCat){
        // sử dụng contentValue để truyền dữ liệu vào câu lệnh
        ContentValues objContent = new ContentValues();
        objContent.put("name", objCat.getName());
        // Tạo mảng điều kiện
        String[] dieu_kien = new String[] { objCat.getId() + "" };
        // thực hiện sửa
        return  db.update("tb_cat", objContent, "id=?", dieu_kien);
    }
    // ? để trống lỗi đẻ hack csdl





    // hàm xóa:
    public int deleteRow (Cat objCat){
        // tạo mảng dk
        String[] dieu_kien = new String[] { objCat.getId() + "" };
        return  db.delete("tb_cat", "id = ?", dieu_kien);
    }






}
