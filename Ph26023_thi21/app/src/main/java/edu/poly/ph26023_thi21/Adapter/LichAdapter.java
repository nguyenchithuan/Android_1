package edu.poly.ph26023_thi21.Adapter;

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
import java.util.List;

import edu.poly.ph26023_thi21.DAO.LichDao;
import edu.poly.ph26023_thi21.DTO.Lich;
import edu.poly.ph26023_thi21.MainActivity;
import edu.poly.ph26023_thi21.R;

public class LichAdapter extends BaseAdapter {
    ArrayList<Lich> list;
    LichDao dao;

    public LichAdapter(ArrayList<Lich> list, LichDao dao) {
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

        TextView tvTieuDeNhap = view.findViewById(R.id.tvTieuDeNhap);
        TextView tvNoiDung = view.findViewById(R.id.tvNoiDung);
        TextView tvThoiGian = view.findViewById(R.id.tvThoiGian);
        TextView tvXoa = view.findViewById(R.id.tvXoa);
        TextView tvUpdate = view.findViewById(R.id.tvUpdate);

        Lich lich = list.get(position);
        tvTieuDeNhap.setText(lich.getTieuDe());
        tvNoiDung.setText(lich.getNoiDung());
        tvThoiGian.setText(lich.getThoiGian());


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

        tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(parent.getContext(), R.style.Theme_Ph26023_thi21);

                dialog.setContentView(R.layout.activity_them);

                TextView tvTieuDe = dialog.findViewById(R.id.tvTieuDe);
                tvTieuDe.setText("Cập nhật lịch");
                Button btnThem = dialog.findViewById(R.id.btnLuu);
                btnThem.setText("Update");



                EditText etTieuDe = dialog.findViewById(R.id.etTieuDe);
                EditText etNoiDung = dialog.findViewById(R.id.etNoiDung);
                EditText etThoiGian = dialog.findViewById(R.id.etThoiGian);

                Lich lich1 = list.get(position);

                etTieuDe.setText(lich1.getTieuDe());
                etNoiDung.setText(lich1.getNoiDung());
                etThoiGian.setText(lich1.getThoiGian());

                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lich lich2 = new Lich();

                        lich2.setId(list.get(position).getId());
                        lich2.setTieuDe(etTieuDe.getText().toString());
                        lich2.setNoiDung(etNoiDung.getText().toString());
                        lich2.setThoiGian(etThoiGian.getText().toString());

                        if(etTieuDe.getText().toString().isEmpty() == true || etNoiDung.getText().toString().isEmpty() == true || etThoiGian.getText().toString().isEmpty() == true) {
                            Toast.makeText(parent.getContext(), "Nhập null!", Toast.LENGTH_SHORT).show();
                        } else {
                            dao.update(lich2);
                            list.set(position, lich2);
                            notifyDataSetChanged();
                            Toast.makeText(parent.getContext(), "Update thanh cong", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    }
                });

                dialog.show();

            }
        });

        return view;
    }
}
