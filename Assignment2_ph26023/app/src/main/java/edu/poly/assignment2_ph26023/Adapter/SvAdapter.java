package edu.poly.assignment2_ph26023.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import edu.poly.assignment2_ph26023.DTO.Sv;
import edu.poly.assignment2_ph26023.DanhSachSvActivity;
import edu.poly.assignment2_ph26023.R;

public class SvAdapter extends BaseAdapter {
    ArrayList<Sv> list;
    String sdt;

    public SvAdapter(ArrayList<Sv> list) {
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
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.layout_item_sv, null);
        }

        TextView tvSttSv = view.findViewById(R.id.tvSttSv);
        TextView tvMaLopSv = view.findViewById(R.id.tvMaLopSv);
        TextView tvTenSv = view.findViewById(R.id.tvTenSv);
        TextView tvNgaySinhSv = view.findViewById(R.id.tvNgaySinhSv);
        TextView tvSdtSv = view.findViewById(R.id.tvSdtSv);
        TextView tvGioiTinhSv = view.findViewById(R.id.tvGioiTinhSv);

        Sv sv = list.get(position);

        tvSttSv.setText(sv.getStt() + "");
        tvMaLopSv.setText(sv.getMaLop());
        tvTenSv.setText(sv.getTenSv());
        tvNgaySinhSv.setText(sv.getNgaySinh());
        tvSdtSv.setText(sv.getSdt());
        tvGioiTinhSv.setText(sv.getGioiTinh());

        sdt = tvSdtSv.getText().toString();

        return view;
    }


    public String getSdt() {
        return sdt;
    }

}
