package com.example.activityornekuygulama;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterModel extends BaseAdapter {

    List<Model> modelList;
    Context mContex;
    Activity activity;

    public AdapterModel(List<Model> modelList, Context mContex,Activity activity) {
        this.modelList = modelList;
        this.mContex = mContex;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = LayoutInflater.from(mContex).inflate(R.layout.listview_layout,parent,false);

        TextView isim = itemView.findViewById(R.id.isim);
        TextView telNo = itemView.findViewById(R.id.telNo);
        TextView soyisim = itemView.findViewById(R.id.soyisim);
        LinearLayout layout = itemView.findViewById(R.id.layout);

        final String isimS = modelList.get(position).getIsim();
        final String soyisimS = modelList.get(position).getSoyisim();
        final String telNOS = modelList.get(position).getNumara();

        isim.setText(isimS);
        soyisim.setText(soyisimS);
        telNo.setText(telNOS);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContex,ActivityDetay.class);
                intent.putExtra("isim",isimS);
                intent.putExtra("soyisim",soyisimS);
                intent.putExtra("telNo",telNOS);
                activity.startActivity(intent);
            }
        });

        return itemView;
    }
}
