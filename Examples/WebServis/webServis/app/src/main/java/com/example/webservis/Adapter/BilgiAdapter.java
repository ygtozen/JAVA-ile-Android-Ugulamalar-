package com.example.webservis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.webservis.Models.Bilgiler;
import com.example.webservis.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {

    private List<Bilgiler> list;
    Context mContex;

    public BilgiAdapter(List<Bilgiler> list, Context mContex) {
        this.list = list;
        this.mContex = mContex;
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
    public View getView(int position, View itemView, ViewGroup parent) {

        itemView = LayoutInflater.from(mContex).inflate(R.layout.listview_layout,parent,false);

        TextView userId = itemView.findViewById(R.id.userId);
        TextView id = itemView.findViewById(R.id.id);
        TextView title = itemView.findViewById(R.id.title);
        TextView body = itemView.findViewById(R.id.body);

        userId.setText(""+list.get(position).getUserId());
        id.setText(""+list.get(position).getId());
        title.setText(""+list.get(position).getTitle());
        body.setText(""+list.get(position).getTitle());

        return itemView;
    }
}
