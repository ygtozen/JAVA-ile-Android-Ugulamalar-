package com.example.webservis3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.webservis3.Models.Bilgi;
import com.example.webservis3.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class BilgiAdapter extends BaseAdapter {

    List<Bilgi> list;
    Context mContex;

    public BilgiAdapter(List<Bilgi> list, Context mContex) {
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

        TextView albumId = itemView.findViewById(R.id.albumId);
        TextView id = itemView.findViewById(R.id.id);
        TextView getirTitle = itemView.findViewById(R.id.getirTitle);
        TextView url = itemView.findViewById(R.id.url);
        ImageView imageView = itemView.findViewById(R.id.thumbnailUrl);

        albumId.setText(""+list.get(position).getAlbumId());
        id.setText(""+list.get(position).getId());
        getirTitle.setText(list.get(position).getTitle());
        url.setText(list.get(position).getUrl());
        // Resmi gösterme kodu



        String yer = list.get(position).getThumbnailUrl();
        Picasso.get().load(list.get(position).getThumbnailUrl()).into(imageView);
        //Picasso.with(mContex).load(list.get(position).getThumbnailUrl()).into(imageView);
        //Picasso.with(mContex).load("https://via.placeholder.com/150/771796").into(imageView);
        //Picasso.with(mContex).load("https://www.google.com.tr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png").into(imageView);

        return itemView;
    }
}
