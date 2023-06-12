package edu.poly.baitest2.Adapter;

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

import edu.poly.baitest2.DAO.VatTuDao;
import edu.poly.baitest2.DTO.VatTu;
import edu.poly.baitest2.R;

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

        TextView tvTenVatLieu = view.findViewById(R.id.tvTenVatTu);
        TextView tvGiaTien = view.findViewById(R.id.tvGiaTien);

        VatTu vatTu = list.get(position);

        tvTenVatLieu.setText(vatTu.getTenVatTu());
        tvGiaTien.setText(vatTu.getGiaTien() + "");

        TextView tvSua = view.findViewById(R.id.tvSua);
        TextView tvXoa = view.findViewById(R.id.tvXoa);

        tvSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(parent.getContext(), R.style.Theme_BaiTest2);
                dialog.setContentView(R.layout.activity_them);
                EditText etTenVatTu = dialog.findViewById(R.id.etTenVatTu);
                EditText etGiaTien = dialog.findViewById(R.id.etGiaTien);
                TextView tvTieuDe = dialog.findViewById(R.id.tvTieuDe);
                tvTieuDe.setText("Sủa vật tư");
                Button btnLuu = dialog.findViewById(R.id.btnLuu);

                VatTu vatTu1 = list.get(position);
                etTenVatTu.setText(vatTu1.getTenVatTu());
                etGiaTien.setText(vatTu1.getGiaTien() + "");

                btnLuu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        VatTu vatTu2 = new VatTu();
                        vatTu2.setTenVatTu(etTenVatTu.getText().toString());
                        vatTu2.setGiaTien(Double.parseDouble(etGiaTien.getText().toString()));
                        dao.update(vatTu2);
                        list.set(position, vatTu2);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setMessage("Bạn có muốn xóa hay không");

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
