package com.example.webservis2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.webservis2.Models.Bilgi;
import com.example.webservis2.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {

    List<Bilgi> bilgiList;
    Context mContex;

    public BilgiAdapter(List<Bilgi> bilgiList, Context mContex) {
        this.bilgiList = bilgiList;
        this.mContex = mContex;
    }

    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {
        return bilgiList.get(position);
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
        TextView gelenTitle = itemView.findViewById(R.id.gelenTitle);
        CheckBox completedCheckBox = itemView.findViewById(R.id.completed);

        userId.setText(userId.getText() + " " + bilgiList.get(position).getUserId());
        id.setText(id.getText() + " " + bilgiList.get(position).getId());
        gelenTitle.setText(gelenTitle.getText() + " " + bilgiList.get(position).getTitle());

        Boolean  deger = bilgiList.get(position).getCompleted();
        if (deger == true)
        {
            completedCheckBox.setChecked(true);
        }
        else
        {
            completedCheckBox.setChecked(false);
            completedCheckBox.setText("False");
        }

        return itemView;
    }
}
