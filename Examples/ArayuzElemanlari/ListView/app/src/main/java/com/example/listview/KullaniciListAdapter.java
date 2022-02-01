package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KullaniciListAdapter extends BaseAdapter {

    List<KullaniciModel>  list;
    Context mContex;

    public KullaniciListAdapter(List<KullaniciModel> list, Context mContex)
    {
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
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = LayoutInflater.from(mContex).inflate(R.layout.listview_layout,parent,false);

        TextView isim = itemView.findViewById(R.id.isim);
        TextView soyad = itemView.findViewById(R.id.soyad);
        TextView yas = itemView.findViewById(R.id.yas);
        TextView takim = itemView.findViewById(R.id.takim);

        isim.setText(list.get(position).getAd());//position her bir kullanıcıyı temsil eder her kullanıcı için tek tek döner
        soyad.setText(list.get(position).getSoyad());
        yas.setText(list.get(position).getYas());
        takim.setText(list.get(position).takimi);

        return itemView;
    }
}
