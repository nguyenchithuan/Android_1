package edu.poly.baitestamsignment.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.poly.baitestamsignment.DTO.Lop;
import edu.poly.baitestamsignment.R;

public class lopAdapter extends BaseAdapter {

    ArrayList<Lop> list;

    public lopAdapter(ArrayList<Lop> list) {
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
        // chạy từ đầu đến cuối của list
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.layout_item_lop, null);
        }

        TextView tvMaLop = view.findViewById(R.id.tvMaLop);
        TextView tvTenLop = view.findViewById(R.id.tvTenLop);

        Lop lop = list.get(position);

        tvMaLop.setText(lop.getMaLop());
        tvTenLop.setText(lop.getTenLop());

        return view;
    }

}
