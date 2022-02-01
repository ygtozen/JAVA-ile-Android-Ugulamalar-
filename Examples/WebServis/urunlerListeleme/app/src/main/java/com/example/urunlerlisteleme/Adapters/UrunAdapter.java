package com.example.urunlerlisteleme.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.urunlerlisteleme.Models.Urunler;
import com.example.urunlerlisteleme.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UrunAdapter extends BaseAdapter {

    private List<Urunler> urunlerList;
    private Context mContex;

    public UrunAdapter(List<Urunler> urunlerList, Context mContex) {
        this.urunlerList = urunlerList;
        this.mContex = mContex;
    }

    @Override
    public int getCount() {
        return urunlerList.size();
    }

    @Override
    public Object getItem(int position) {
        return urunlerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {

        itemView = LayoutInflater.from(mContex).inflate(R.layout.listview_layout,parent,false);

        ImageView urunResim;
        TextView urunId,urunAd,urunFiyat;
        urunResim = itemView.findViewById(R.id.urunResim);
        urunId = itemView.findViewById(R.id.urunId);
        urunAd = itemView.findViewById(R.id.urunAd);
        urunFiyat = itemView.findViewById(R.id.urunFiyat);

        urunId.setText("Ürün Id : " + urunlerList.get(position).getId());
        urunAd.setText("Ürün Ad : " + urunlerList.get(position).getUrunAdi());
        urunFiyat.setText("Ürün Fiyat : " + urunlerList.get(position).getUrunFiyat());

        Picasso.get().load("http://ygtozn.cf/resimler/" + urunlerList.get(position).getUrunResim())
                .into(urunResim);

        return itemView;
    }
}
