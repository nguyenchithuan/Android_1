package edu.poly.baitestsqlite.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.poly.baitestsqlite.DTO.Cat;
import edu.poly.baitestsqlite.R;

public class CatAdapter extends BaseAdapter {
    ArrayList<Cat> listCat;

    public CatAdapter(ArrayList<Cat> listCat) {
        this.listCat = listCat;
    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int position) {
        return listCat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCat.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view  = View.inflate(viewGroup.getContext(), R.layout.layout_row_item, null);
        }

        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_name = view.findViewById(R.id.tv_name);

        Cat cat = listCat.get(position);

        tv_id.setText(cat.getId() + "");
        tv_name.setText(cat.getName());
        return view;
    }
}
