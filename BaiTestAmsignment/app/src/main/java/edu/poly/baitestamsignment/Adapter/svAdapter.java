package edu.poly.baitestamsignment.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import edu.poly.baitestamsignment.DTO.Sv;
import edu.poly.baitestamsignment.Dao.SvDao;
import edu.poly.baitestamsignment.R;

public class svAdapter extends BaseAdapter {
    ArrayList<Sv> list;
    SvDao dao;

    public svAdapter(ArrayList<Sv> list, SvDao dao) {
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.layout_item_sv, null);
        }

        return view;
    }
}
