package edu.poly.baitest1.Adapter;

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

import edu.poly.baitest1.DAO.VatTuDao;
import edu.poly.baitest1.DTO.VatTu;
import edu.poly.baitest1.R;

public class VatTuAdapter extends BaseAdapter {
    ArrayList<VatTu> list;
    VatTuDao dao;

    public VatTuAdapter(ArrayList<VatTu> list, VatTuDao dao) {
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

        TextView tvTenVatTu = view.findViewById(R.id.tvTenVatTu);
        TextView tvGia = view.findViewById(R.id.tvGia);
        TextView tvSua = view.findViewById(R.id.tvSua);
        TextView tvXoa = view.findViewById(R.id.tvXoa);

        VatTu vatTu = list.get(position);

        tvTenVatTu.setText(vatTu.getTenVatTu());
        tvGia.setText(vatTu.getGiaTien() + "");

        tvSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(parent.getContext(), R.style.Theme_BaiTest1); //2000363
                dialog.setContentView(R.layout.activity_them);

                EditText etTenVatTu = dialog.findViewById(R.id.etTenVatTu);
                EditText etGiaTien = dialog.findViewById(R.id.etGiaTien);
                Button btnLuu = dialog.findViewById(R.id.btnLuu);

                VatTu vatTuEdit = list.get(position);

                etTenVatTu.setText(vatTuEdit.getTenVatTu());
                etGiaTien.setText(vatTuEdit.getGiaTien() + "");


                btnLuu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        VatTu vt = new VatTu();
                        vt.setTenVatTu(etTenVatTu.getText().toString());
                        vt.setGiaTien(Double.parseDouble(etGiaTien.getText().toString()));
                        dao.update(vt);
                        list.set(position, vt);
                        notifyDataSetChanged();
                        Toast.makeText(parent.getContext(), "Sửa thành công!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        tvXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
                builder.setMessage("Bạn muốn xóa không!");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.delete(list.get(position));
                        list.remove(position);
                        Toast.makeText(parent.getContext(), "Xóa thành công!", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
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
