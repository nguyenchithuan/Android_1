package net.devmob.crud_user_group.Adapter;

import android.app.Dialog;
import android.content.Context;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import net.devmob.crud_user_group.DAO.GroupUserDAO;
import net.devmob.crud_user_group.DAO.UserDAO;
import net.devmob.crud_user_group.DTO.GroupUser;
import net.devmob.crud_user_group.DTO.User;
import net.devmob.crud_user_group.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserAdapter extends BaseAdapter {
    ArrayList<User> listUser;
    UserDAO userDAO;

    public UserAdapter(ArrayList<User> listUser, UserDAO userDAO) {
        this.listUser = listUser;
        this.userDAO = userDAO;
    }

    @Override
    public int getCount() {
        return listUser.size();
    }

    @Override
    public Object getItem(int i) {
        User objUser = listUser.get(i);

        return objUser;
    }

    @Override
    public long getItemId(int i) {
        User objUser = listUser.get(i);
        return objUser.getId_group();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        // khởi tạo cho itemView
        if(view == null){

            itemView = View.inflate(viewGroup.getContext(), R.layout.item_listview_user, null);
        }else
            itemView = view;


        //--- lấy thông tin bản ghi dữ liệu
        final User objUser = listUser.get(i);
        final int _index = i;


        // ánh xạ các view vào biến
        TextView tv_id = itemView.findViewById(R.id.tv_id);
        TextView tv_username = itemView.findViewById(R.id.tv_username);
        TextView tv_fullname = itemView.findViewById(R.id.tv_fullname);

        TextView tv_del = itemView.findViewById(R.id.tv_del);
        TextView tv_edit = itemView.findViewById(R.id.tv_edit);


        //----------- set text
        tv_id.setText( objUser.getId_group() + "");
        tv_username.setText( objUser.getUsername());
        tv_fullname.setText(objUser.getFullname());

        //------ viết sự kiện bấm nút
        tv_username.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("User Info");

                User new_obj_user = userDAO.selectOneWithGroup(objUser.getId_user());
                builder.setMessage(  new_obj_user.toString() );
                AlertDialog dialog = builder.create();
                dialog.show();

                return false;
            }
        });


        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //------------ hiển thị dialog hỏi
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("Xóa User?");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn xóa : " + objUser.getUsername());

                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // xử lý sự kiện xóa

                        // gọi lệnh xóa dòng
                        int kq = userDAO.deleteRow(objUser);
                        if(kq > 0)
                        {
                            // xóa thành công trong csdl
                            listUser.remove(_index); // xóa khỏi danh sách
                            notifyDataSetChanged();
                            Toast.makeText(viewGroup.getContext(), "Đã xóa ", Toast.LENGTH_SHORT).show();

                        }else
                            Toast.makeText(viewGroup.getContext(), "Không xóa được  " + kq, Toast.LENGTH_SHORT).show();

                        dialogInterface.dismiss(); // đóng dialog

                    }
                });

                builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); // đóng dialog
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });

        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEdit(objUser, _index ,viewGroup.getContext());
            }
        });



        return itemView;
    }

    public void showDialogEdit(User objUser, int index, Context context){

        final Dialog dialog = new Dialog(context, R.style.Theme_Crud_user_group);

        dialog.setContentView(R.layout.dialog_edit_user);

        EditText ed_username = dialog.findViewById(R.id.ed_username);
        ed_username.setText(objUser.getUsername());

        EditText ed_password = dialog.findViewById(R.id.ed_password);

        EditText ed_email = dialog.findViewById(R.id.ed_email);
        ed_email.setText(objUser.getEmail());
        EditText ed_fullname = dialog.findViewById(R.id.ed_fullname);
        ed_fullname.setText(objUser.getFullname());

        // làm spinner chọn
        final Spinner spin_group = dialog.findViewById(R.id.spin_group);

        GroupUserDAO groupUserDAO = new GroupUserDAO(context);
        groupUserDAO.open();
        ArrayList<GroupUser> listGroupUser = groupUserDAO.selectAll();
        SpinGroupUserAdapter adapter = new SpinGroupUserAdapter(listGroupUser);
        spin_group.setAdapter(adapter);

        for(int j = 0;j<listGroupUser.size(); j++){
            GroupUser tmp = listGroupUser.get(j);
            if(tmp.getId_group() == objUser.getId_group()){
                spin_group.setSelection(j);
                spin_group.setSelected(true);
            }
        }

        //======


        Button btnSave = dialog.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // viết lệnh update dữ liệu

                objUser.setUsername(   ed_username.getText().toString() );
                objUser.setPassword(   ed_password.getText().toString() );
                objUser.setEmail(   ed_email.getText().toString() );
                objUser.setFullname(   ed_fullname.getText().toString() );
                // lấy id spin
                GroupUser objGroupUser  =  (GroupUser) spin_group.getSelectedItem();
                objUser.setId_group( objGroupUser.getId_group() );



                int res = userDAO.updateRow(objUser);

                if(res > 0)
                {
                    listUser.set(index,objUser);

                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã sửa ", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(context, "Không sửa được  " + res, Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
        dialog.show();
    }



    public void showDialogAdd( Context context){

//        final Dialog dialog = new Dialog(context);
        final Dialog dialog = new Dialog(context, R.style.Theme_Crud_user_group);


        dialog.setContentView(R.layout.dialog_add_user);
        dialog.setTitle("Thêm nhóm mới");

        EditText ed_username = dialog.findViewById(R.id.ed_username);
        EditText ed_password = dialog.findViewById(R.id.ed_password);
        EditText ed_email = dialog.findViewById(R.id.ed_email);
        EditText ed_fullname = dialog.findViewById(R.id.ed_fullname);

        // làm spinner chọn
        final Spinner spin_group = dialog.findViewById(R.id.spin_group);

        GroupUserDAO groupUserDAO = new GroupUserDAO(context);
        groupUserDAO.open();


        SpinGroupUserAdapter adapter = new SpinGroupUserAdapter( groupUserDAO.selectAll() );
        spin_group.setAdapter(adapter);
        //======



        Button btnSave = dialog.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // viết lệnh update dữ liệu

                User objUser = new User();

                objUser.setUsername(   ed_username.getText().toString() );
                objUser.setPassword(   ed_password.getText().toString() );
                objUser.setEmail(   ed_email.getText().toString() );
                objUser.setFullname(   ed_fullname.getText().toString() );
                // lấy id spin
                GroupUser objGroupUser  =  (GroupUser) spin_group.getSelectedItem();
                objUser.setId_group( objGroupUser.getId_group() );


                long res = userDAO.insertNew(objUser);

                if(res > 0)
                {
                    listUser.clear();
                    listUser.addAll(userDAO.selectAll());

                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã thêm mới ", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(context, "Không thêm được  " + res, Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });
        dialog.show();

    }





}
