package com.example.dbtojson.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dbtojson.Models.Kullanici;
import com.example.dbtojson.R;

import java.util.List;

public class KullaniciAdapter extends BaseAdapter {

    private List<Kullanici> list;
    private Context mContex;
    private Activity activity;

    public KullaniciAdapter(List<Kullanici> list, Context mContex,Activity activity) {
        this.list = list;
        this.mContex = mContex;
        this.activity = activity;
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

        TextView id,isim,soyad;
        LinearLayout linearLayout;
        id = itemView.findViewById(R.id.id);
        isim = itemView.findViewById(R.id.isim);
        soyad = itemView.findViewById(R.id.soyad);
        //linearLayout = itemView.findViewById(R.id.layout);

        id.setText(list.get(position).getId());
        isim.setText(list.get(position).getIsim());
        soyad.setText(list.get(position).getSoyad());

        /*linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogClass dialogClass = new DialogClass(activity,mContex);
                dialogClass.goster();
            }
        });*/

        return itemView;
    }
}
