package com.example.firebase8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MesajAdapter extends RecyclerView.Adapter {

    List<MesajModel> list;
    Context mContex;
    boolean state = false;
    static  final int user = 1 , other = 2;

    public MesajAdapter(List<MesajModel> list, Context mContex) {
        this.list = list;
        this.mContex = mContex;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        // RecylerView'e ait layoutun view larını tanımlanması işlemleri yapılıyor.
        TextView mesajbody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (state)
            {
                mesajbody = itemView.findViewById(R.id.userText);
            }
            else
            {
                mesajbody = itemView.findViewById(R.id.otherText);
            }
        }

        void setle(MesajModel msj /*int position*/)
        {
            //mesajbody.setText(list.get(position).getMesaj());
            mesajbody.setText(msj.getMesaj().toString()); // Yukarıdaki ile aynı şey
        }
    }


    // Veritabanındaki from'a göre layout döndürülmesini sağlayan değişkenler.
    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getFrom().equals("1"))
        {
            // Mesaj gönderen biz isek
            state = true;
            return user;
        }
        else
        {
            // Mesaj gönderen karşı taraf ise
            state = false;
            return other;
        }
    }


    // Layout Tanımlaması
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == user)
        {
            view = LayoutInflater.from(mContex).inflate(R.layout.user_layout,parent,false);
            return new ViewHolder(view);
        }
        else
        {
            view = LayoutInflater.from(mContex).inflate(R.layout.other_layout,parent,false);
            return new ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MesajModel m = list.get(position);

        switch (holder.getItemViewType())
        {
            case user :
            {
                ((ViewHolder) holder).setle(m);
            }
            case other :
            {
                ((ViewHolder) holder).setle(m);
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
