package com.example.listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MesajAdapter extends BaseAdapter {

    List<MesajModel> mesajModelList;
    Context mContex;

    public MesajAdapter(List<MesajModel> mesajModelList, Context mContex) {
        this.mesajModelList = mesajModelList;
        this.mContex = mContex;
    }

    @Override
    public int getCount() {
        return mesajModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mesajModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = LayoutInflater.from(mContex).inflate(R.layout.listview_layout, parent,false);

        ImageView kisiResim = itemView.findViewById(R.id.kisiResmi);
        TextView kisiAd = itemView.findViewById(R.id.kisiAd);
        TextView mesaj = itemView.findViewById(R.id.mesaj);

        kisiResim.setImageResource(mesajModelList.get(position).getResimId());
        kisiAd.setText(mesajModelList.get(position).getKisi());
        mesaj.setText(mesajModelList.get(position).getMesajIcerik());

        return itemView;
    }
}
