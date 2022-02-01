package com.example.mesajgonderme2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MesajAdapter extends BaseAdapter {

    List<MesajModel> list;
    Context mContex;
    Activity activity;

    public MesajAdapter(List<MesajModel> list, Context mContex, Activity activity) {
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

        final EditText mesaj = itemView.findViewById(R.id.mesaj);
        TextView isim = itemView.findViewById(R.id.isim);
        TextView tel = itemView.findViewById(R.id.tel);
        Button buttonGonder = itemView.findViewById(R.id.buttonGonder);

        isim.setText(list.get(position).getIsim());
        tel.setText(list.get(position).getTel());

        final String telNo = list.get(position).getTel();

        buttonGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mesajIcerik = mesaj.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+telNo));
                intent.putExtra("sms_body",mesajIcerik);
                activity.startActivity(intent);
            }
        });

        return itemView;
    }
}
