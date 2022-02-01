package com.example.realminsertview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KisiAdapter extends BaseAdapter {

    private List<KisiBilgileri> list;
    private Context mContex;

    public KisiAdapter(List<KisiBilgileri> list, Context mContex) {
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

        TextView txtKullaniciAdi = itemView.findViewById(R.id.txtKullaniciAdi);
        TextView txtIsim = itemView.findViewById(R.id.txtIsim);
        TextView txtSifre = itemView.findViewById(R.id.txtSifre);
        TextView txtCinsiyet = itemView.findViewById(R.id.txtCinsiyet);

        txtKullaniciAdi.setText(list.get(position).getKullaniciAdi());
        txtIsim.setText(list.get(position).getIsim());
        txtSifre.setText(list.get(position).getSifre());
        txtCinsiyet.setText(list.get(position).getCinsiyet());

        return itemView;
    }
}




