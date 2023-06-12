package edu.poly.assignment2_ph26023.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.poly.assignment2_ph26023.DTO.Lop;
import edu.poly.assignment2_ph26023.R;

public class LopAdapter extends BaseAdapter {

    ArrayList<Lop> list;

    public LopAdapter(ArrayList<Lop> list) {
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
            view = View.inflate(viewGroup.getContext(), R.layout.layout_item_lop, null);
        }

        TextView tvSttLop = view.findViewById(R.id.tvSttLop);
        TextView tvMaLop = view.findViewById(R.id.tvMaLop);
        TextView tvTenLop = view.findViewById(R.id.tvTenLop);

        Lop lop = list.get(position);

        tvSttLop.setText(lop.getStt() + "");
        tvMaLop.setText(lop.getMaLop());
        tvTenLop.setText(lop.getTenLop());

        return view;
    }
}
