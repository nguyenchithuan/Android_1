package edu.poly.baitest5.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.baitest5.MainActivity;
import edu.poly.baitest5.Objects.Student;
import edu.poly.baitest5.R;
import edu.poly.baitest5.dao.StudentDAO;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> list;
    private StudentDAO dao;

    public StudentAdapter(Context context, ArrayList<Student> list, StudentDAO dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }

    public void setData(ArrayList<Student> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // hiển thị dữ liệu lên listview
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        }

        TextView tvId = view.findViewById(R.id.tv_id);
        TextView tvName = view.findViewById(R.id.tv_name);
        ImageView imgEdit = view.findViewById(R.id.img_edit);
        ImageView imgDelete = view.findViewById(R.id.img_delete);

        Student student = list.get(position);

        tvId.setText(student.getId() + "");
        tvName.setText(student.getName());

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDulieu(student);
            }
        });

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDulieu(student);
            }
        });

        return view;
    }

    private void deleteDulieu(Student student) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage("Bạn có muốn xóa không!");
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.delete(student.getId());
                list = dao.getAll();
                notifyDataSetChanged();
                Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.show();
    }

    private void updateDulieu(Student student) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_update_insert);

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        EditText ed_duLieu = dialog.findViewById(R.id.ed_insert_update);
        Button btn_send = dialog.findViewById(R.id.btn_insert_update);

        ed_duLieu.setText(student.getName());



        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student.setName(ed_duLieu.getText().toString());
                dao.update(student);
                list = dao.getAll();
                notifyDataSetChanged();
                Toast.makeText(context, "Update thành công!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
