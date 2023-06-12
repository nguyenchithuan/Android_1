package edu.poly.baitest3.Adapter;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import edu.poly.baitest3.DAO.XeDao;
import edu.poly.baitest3.DTO.Xe;
import edu.poly.baitest3.R;

public class XeAdapter extends BaseAdapter {
    ArrayList<Xe> list;
    XeDao dao;

    public XeAdapter(ArrayList<Xe> list, XeDao dao) {
        this.list = list;
        this.dao = dao;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null) {
            view = View.inflate(parent.getContext(), R.layout.layout_item, null);
        }

        TextView tvId = view.findViewById(R.id.tvId);
        TextView tvTenXe = view.findViewById(R.id.tvTenXe);
        TextView tvXoa = view.findViewById(R.id.tvXoa);
        TextView tvCapNhat = view.findViewById(R.id.tvCapNhat);

        Xe xe = list.get(position);
        tvId.setText(xe.getId() + "");
        tvTenXe.setText(xe.getTenXe());


        tvCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(parent.getContext(), R.style.Theme_BaiTest3);
                dialog.setContentView(R.layout.activity_cap_nhat);


                EditText etCapNhat = dialog.findViewById(R.id.etCapNhat);
                Button btnCapNhat = dialog.findViewById(R.id.btnCapNhat);

                Xe xe = list.get(position);
                etCapNhat.setText(xe.getTenXe());
                btnCapNhat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Xe xe1 = new Xe();
                        xe1.setId(xe.getId());
                        xe1.setTenXe(etCapNhat.getText().toString());
                        dao.insert(xe1);
                        list.set(position, xe1);
                        notifyDataSetChanged();
                        Toast.makeText(parent.getContext(), "Update thành công!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

        tvXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setMessage("Bạn có muốn xóa hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.delete(list.get(position));
                        list.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(parent.getContext(), "Xóa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        return view;
    }
}
