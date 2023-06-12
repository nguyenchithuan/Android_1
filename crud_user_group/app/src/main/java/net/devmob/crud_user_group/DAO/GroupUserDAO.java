package net.devmob.crud_user_group.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.devmob.crud_user_group.DTO.GroupUser;
import net.devmob.crud_user_group.Database.DbHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupUserDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public GroupUserDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public long insertNew(GroupUser objGroupUser){

        ContentValues contentValues = new ContentValues();
        contentValues.put(GroupUser.COL_GROUP_NAME, objGroupUser.getName());

        long res = db.insert(GroupUser.TB_NAME, null, contentValues);

        return  res;

    }
    public int deleteRow(GroupUser objGroupUser){

        int res = db.delete(GroupUser.TB_NAME, "id_group = ?" , new String[] { objGroupUser.getId_group() +"" });

        return  res;
    }

    public int updateRow(GroupUser objGroupUser){

        // sử dụng contentValue
        ContentValues values= new ContentValues();
        values.put( GroupUser.COL_GROUP_NAME,objGroupUser.getName()  );

        int res = db.update(GroupUser.TB_NAME, values,"id_group = ?", new String[] { objGroupUser.getId_group() +"" } );
        return  res;
    }
    
    
    
    public GroupUser selectOne(int id){
        GroupUser objGroupUser = new GroupUser();
        String[] args = new String[] { id + "" };

//        Cursor c = db.rawQuery("SELECT id_lop, ten_lop FROM tb_lop WHERE id_lop=?", args );

        String[] columns = new String[]{"*"};

        Cursor c = db.query(GroupUser.TB_NAME,columns, null, null,null,null,null);
        if(c.moveToFirst()){
            // nếu có dữ liệu thì hàm moveToFirst sẽ trả về giá trị true
            objGroupUser.setId_group( c.getInt(  0  ) );
            objGroupUser.setName( c.getString(1) );
        }

        return objGroupUser; // nếu không lấy được dữ liệu thì cũng trả về object rỗng
    }

    public ArrayList<GroupUser> selectAll(){
        //1. Tạo biến chứa danh sach
        ArrayList<GroupUser> listGroupUser = new ArrayList<GroupUser>();
        String[] ds_cot = new String[] { "*" };
        // tạo đối tượng con trỏ đọc dữ liệu
        Cursor cursor = db.query(GroupUser.TB_NAME, ds_cot,null, null,null,null, null);
        if(cursor.moveToFirst()){
            // có dữ liệu
            while (!cursor.isAfterLast()){
                // lấy dữ liệu
                GroupUser objGroupUser = new GroupUser();
                objGroupUser.setId_group( cursor.getInt(0)   );
                objGroupUser.setName( cursor.getString(1   ));

                // bỏ đối tượng vào danh sách
                listGroupUser.add(objGroupUser);

                // chuyển con trỏ sang dòng tiếp theo
                cursor.moveToNext();// nếu không có dòng này sẽ bị treo ứng dụng
            }
        }
        return  listGroupUser;
    }



}
