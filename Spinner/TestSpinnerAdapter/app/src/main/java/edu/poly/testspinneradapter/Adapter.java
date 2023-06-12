package edu.poly.testspinneradapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    ArrayList<Lop> list;

    public Adapter(ArrayList<Lop> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.layout_item_spinner, null);
        }

        TextView tv_id = convertView.findViewById(R.id.tv_id);
        TextView tv_name = convertView.findViewById(R.id.tv_name);

        Lop lop = list.get(position);

        tv_id.setText(lop.getId() + "");
        tv_name.setText(lop.getTenLop());
        return convertView;
    }
}
