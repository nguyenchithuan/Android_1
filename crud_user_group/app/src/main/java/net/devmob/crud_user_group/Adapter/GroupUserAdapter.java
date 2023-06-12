package net.devmob.crud_user_group.Adapter;

import android.app.Dialog;
import android.content.Context;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import net.devmob.crud_user_group.DAO.GroupUserDAO;
import net.devmob.crud_user_group.DTO.GroupUser;
import net.devmob.crud_user_group.R;

import java.util.ArrayList;

public class GroupUserAdapter extends BaseAdapter {
    ArrayList<GroupUser> listGroupUser;
    GroupUserDAO groupUserDAO;

    public GroupUserAdapter(ArrayList<GroupUser> listGroupUser, GroupUserDAO groupUserDAO) {
        this.listGroupUser = listGroupUser;
        this.groupUserDAO = groupUserDAO;
    }

    @Override
    public int getCount() {
        return listGroupUser.size();
    }

    @Override
    public Object getItem(int i) {
        GroupUser objGroup = listGroupUser.get(i);

        return objGroup;
    }

    @Override
    public long getItemId(int i) {
        GroupUser objGroup = listGroupUser.get(i);
        return objGroup.getId_group();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        // khởi tạo cho itemView
        if(view == null){

            itemView = View.inflate(viewGroup.getContext(), R.layout.item_listview_group_user, null);
        }else
            itemView = view;


        //--- lấy thông tin bản ghi dữ liệu
        final GroupUser objGroup = listGroupUser.get(i);
        final int _index = i;


        // ánh xạ các view vào biến
        TextView tv_id = itemView.findViewById(R.id.tv_id);
        TextView tv_name = itemView.findViewById(R.id.tv_name);
        TextView tv_del = itemView.findViewById(R.id.tv_del);
        TextView tv_edit = itemView.findViewById(R.id.tv_edit);


        //----------- set text
        tv_id.setText( objGroup.getId_group() + "");
        tv_name.setText( objGroup.getName());

        //------ viết sự kiện bấm nút
        tv_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // context cung cap pham vi truy cap
                // viewgroup tuc la activiti
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("Group Info");
                builder.setMessage("Name: " + objGroup.getName());
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
                builder.setTitle("Xóa nhóm?");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Có chắc chắn xóa nhóm: " + objGroup.getName());

                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // xử lý sự kiện xóa

                        // gọi lệnh xóa dòng
                        int kq = groupUserDAO.deleteRow(objGroup); // trả về số lượng dòng bị xóa
                        if(kq > 0)
                        {
                            // xóa thành công trong csdl
                            listGroupUser.remove(_index); // xóa khỏi danh sách
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
                        dialogInterface.cancel(); // đóng dialog
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();



            }
        });

        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEdit(objGroup, _index ,viewGroup.getContext());
            }
        });


        return itemView;
    }

    public void showDialogEdit(GroupUser objGroup, int index, Context context){

        final Dialog dialog = new Dialog(context, R.style.Theme_AppCompat_Light_Dialog_Alert);


        dialog.setContentView(R.layout.dialog_edit_group_user);

        EditText ed_name = dialog.findViewById(R.id.ed_name);
        ed_name.setText(objGroup.getName());

        Button btnSave = dialog.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // viết lệnh update dữ liệu

                objGroup.setName(   ed_name.getText().toString() ); // gán lại dữ liệu người dùng mới nhập

                int res = groupUserDAO.updateRow(objGroup);

                if(res > 0)
                {
                    listGroupUser.set(index,objGroup);

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
        final Dialog dialog = new Dialog(context, R.style.Theme_AppCompat_Light_Dialog_Alert);


        dialog.setContentView(R.layout.dialog_add_group_user);
        dialog.setTitle("Thêm nhóm mới");

        EditText ed_name = dialog.findViewById(R.id.ed_name);


        Button btnSave = dialog.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // viết lệnh update dữ liệu

                GroupUser objGroup = new GroupUser();
                objGroup.setName(   ed_name.getText().toString() );

                long res = groupUserDAO.insertNew(objGroup);

                if(res > 0)
                {
                    listGroupUser.clear();
                    listGroupUser.addAll(groupUserDAO.selectAll());

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
