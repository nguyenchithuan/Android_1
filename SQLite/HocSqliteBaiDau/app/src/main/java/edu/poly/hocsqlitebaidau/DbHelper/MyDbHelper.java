package edu.poly.hocsqlitebaidau.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// SQLiteOpenHelper là một lớp trợ giúp để quản lý việc tạo cơ sở dữ liệu SQLite và quản lý phiên bản
    public class MyDbHelper extends SQLiteOpenHelper {
    // khai bao tên csdl, phiên bản csdl
    static final String DB_NAME = "crud_product";
    static final int DB_VERSION = 1;



    // viết hàm khởi tạo, không dùng generate
    public MyDbHelper(Context context) { // vì không kế thừa từ activiti lên phải tạo context
        super(context, DB_NAME, null, DB_VERSION);
    }



    // OnCreate () được gọi khi cơ sở dữ liệu được tạo lần đầu tiên
    // chỉ được gọi 1 lần trong toàn bộ vòng đời ứng dụng
    // Nó sẽ được gọi bất cứ khi nào có lệnh gọi đầu tiên đến hàm getReadableDatabase () hoặc getWainedDatabase ()
    @Override
    public void onCreate(SQLiteDatabase db) {
        // viết lệnh tạo bảng ở trong này
        String sql_create_tb_cat = "CREATE TABLE tb_cat ( id INTEGER NOT NULL, name TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))"; // báo đỏ không có vấn đề gì
        // execSQL để thực hiện câu lệnh truy vấn
        // để tạo ra bảng cat với cái tên trong database
        db.execSQL(sql_create_tb_cat);

        // làm tương tư với bảng sản phẩm
        String sql_create_tb_pro ="CREATE TABLE tb_product ( id INTEGER NOT NULL, name TEXT NOT NULL, price NUMERIC DEFAULT 0, img_res INTEGER, id_cat INTEGER, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL( sql_create_tb_pro);

        // Chạy câu lệnh insert tạm một ít dữ liệu vào bảng
        // Thêm dữ liệu vào bảng thể loại
        String sql_insert_cat = "INSERT INTO tb_cat (name) VALUES('Hàng điện tử'),('Hàng gia dụng')";
        db.execSQL( sql_insert_cat);

    }

    // nâng cấp sql và phiên bản
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
