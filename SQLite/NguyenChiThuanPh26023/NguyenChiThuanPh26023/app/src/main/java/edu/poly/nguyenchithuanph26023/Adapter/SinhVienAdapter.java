package edu.poly.nguyenchithuanph26023.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.poly.nguyenchithuanph26023.DTO.SinhVien;
import edu.poly.nguyenchithuanph26023.R;

public class SinhVienAdapter extends BaseAdapter {
    ArrayList<SinhVien> list;

    public SinhVienAdapter(ArrayList<SinhVien> list) {
        this.list = list;
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
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.layout_row_item, null);
        }

        TextView tvId = view.findViewById(R.id.tvId);
        TextView tvHoTen = view.findViewById(R.id.tvHoTen);
        TextView tvSdt = view.findViewById(R.id.tvSdt);
        TextView tvGhiChu = view.findViewById(R.id.tvGhiChu);

        SinhVien sv = list.get(position);

        tvId.setText(sv.getId() + "");
        tvHoTen.setText(sv.getHoTen());
        tvSdt.setText(sv.getSodt());
        tvGhiChu.setText(sv.getGhiChu());

        return view;
    }
}
