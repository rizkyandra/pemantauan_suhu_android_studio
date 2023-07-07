package com.rizkyandra3008.kalkulator.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rizkyandra3008.kalkulator.R;
import com.rizkyandra3008.kalkulator.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;

    public Adapter(Activity activity, List<Data> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater != null) {
            view = inflater.inflate(R.layout.list_suhu, null);
        }
        if (view != null) {
            TextView suhu = view.findViewById(R.id.text_suhu);
            TextView date = view.findViewById(R.id.text_date);
            TextView time = view.findViewById(R.id.text_time);
            Data data = lists.get(i);
            suhu.setText("Suhu : " + data.getSuhu());
            date.setText(data.getDate() + " - " + data.getTime());
        }
        return view;
    }
}
