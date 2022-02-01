package com.example.webservis4.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.webservis4.ActivityDetay;
import com.example.webservis4.Models.Bilgi;
import com.example.webservis4.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {

    private List<Bilgi> bilgiList;
    private Context mContex;
    private Activity activity;

    public BilgiAdapter(List<Bilgi> bilgiList, Context mContex,Activity activity) {
        this.bilgiList = bilgiList;
        this.mContex = mContex;
        this.activity = activity;
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
    public View getView(final int position, View itemView, ViewGroup parent) {

        itemView = LayoutInflater.from(mContex).inflate(R.layout.listview_layout,parent,false);

        final TextView postId,id,name,email,body;
        LinearLayout layoutList;

        layoutList = itemView.findViewById(R.id.layoutList);
        postId = itemView.findViewById(R.id.postId);
        id = itemView.findViewById(R.id.id);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
        body = itemView.findViewById(R.id.body);

        postId.setText(""+bilgiList.get(position).getPostId());
        id.setText(""+bilgiList.get(position).getId());
        name.setText(bilgiList.get(position).getName());
        email.setText(bilgiList.get(position).getEmail());
        body.setText(bilgiList.get(position).getBody());

        final String post = String.valueOf(bilgiList.get(position).getPostId());
        final String idm = String.valueOf(bilgiList.get(position).getId());

        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ActivityDetay.class);
                intent.putExtra("postId",post);
                intent.putExtra("id",idm);
                activity.startActivity(intent);
            }
        });

        return itemView;
    }
}
