package net.devmob.crud_user_group.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.devmob.crud_user_group.DTO.User;
import net.devmob.crud_user_group.Database.DbHelper;

import java.util.ArrayList;

public class UserDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public UserDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public long insertNew(User objUser){

        ContentValues contentValues = new ContentValues();
        contentValues.put(User.COL_USERNAME, objUser.getUsername());
        contentValues.put(User.COL_PASSWORD, objUser.getPassword());
        contentValues.put(User.COL_EMAIL, objUser.getEmail());
        contentValues.put(User.COL_FULLNAME, objUser.getFullname());
        contentValues.put(User.COL_ID_GROUP, objUser.getId_group());

        long res = db.insert(User.TB_NAME, null, contentValues);

        return  res;

    }
    public int deleteRow(User objUser){

        int res = db.delete(User.TB_NAME, "id_user = ?" , new String[] { objUser.getId_user() +"" });

        return  res;
    }

    public int updateRow(User objUser){

        // sử dụng contentValue
        ContentValues contentValues= new ContentValues();
        contentValues.put( User.COL_USERNAME,objUser.getUsername()  );
        contentValues.put(User.COL_PASSWORD, objUser.getPassword());
        contentValues.put(User.COL_EMAIL, objUser.getEmail());
        contentValues.put(User.COL_FULLNAME, objUser.getFullname());
        contentValues.put(User.COL_ID_GROUP, objUser.getId_group());

        int res = db.update(User.TB_NAME, contentValues,"id_user = ?", new String[] { objUser.getId_user() +"" } );
        return  res;
    }



    public User selectOne(int id){
        User objUser = new User();
        String[] args = new String[] { id + "" };


        String[] columns = new String[]{"*"};

        Cursor c = db.query(User.TB_NAME,columns, null, null,null,null,null);
        if(c.moveToFirst()){
            // nếu có dữ liệu thì hàm moveToFirst sẽ trả về giá trị true
            objUser.setId_group( c.getInt(  0  ) );
            objUser.setUsername( c.getString(1) );
        }

        return objUser; // nếu không lấy được dữ liệu thì cũng trả về object rỗng
    }

    public User selectOneWithGroup(int id){
        String[] args = new String[] { id + "" };

        User objUser = new User();
        String str_sql = "SELECT id_user, username, password,email,fullname,tb_user.id_group, tb_group.name" +
                " FROM tb_user INNER JOIN tb_group ON tb_user.id_group = tb_group.id_group WHERE id_user = ?";

        Cursor cursor = db.rawQuery(str_sql, args );

        if(cursor.moveToFirst()){
            // nếu có dữ liệu thì hàm moveToFirst sẽ trả về giá trị true
            objUser.setId_user( cursor.getInt(   0   )   );

            objUser.setUsername( cursor.getString(1   ));
            objUser.setPassword( cursor.getString(2   ));
            objUser.setEmail( cursor.getString(3   ));
            objUser.setFullname( cursor.getString(4   ));
            objUser.setId_group( cursor.getInt(5)   );
            objUser.setGroup_name( cursor.getString(6));
        }

        return objUser; // nếu không lấy được dữ liệu thì cũng trả về object rỗng
    }



    public ArrayList<User> selectAll(){
        //1. Tạo biến chứa danh sach
        ArrayList<User> listUser = new ArrayList<User>();
        String[] ds_cot = new String[] { "*" };
        // tạo đối tượng con trỏ đọc dữ liệu
        Cursor cursor = db.query(User.TB_NAME, ds_cot,null, null,null,null, null);
        if(cursor.moveToFirst()){
            // có dữ liệu
            while (!cursor.isAfterLast()){
                // lấy dữ liệu
                User objUser = new User();
                objUser.setId_user( cursor.getInt(0)   );

                objUser.setUsername( cursor.getString(1   ));
                objUser.setPassword( cursor.getString(2   ));
                objUser.setEmail( cursor.getString(3   ));
                objUser.setFullname( cursor.getString(4   ));
                objUser.setId_group( cursor.getInt(5)   );

                // bỏ đối tượng vào danh sách
                listUser.add(objUser);

                // chuyển con trỏ sang dòng tiếp theo
                cursor.moveToNext();// nếu không có dòng này sẽ bị treo ứng dụng
            }
        }
        return  listUser;
    }

}
