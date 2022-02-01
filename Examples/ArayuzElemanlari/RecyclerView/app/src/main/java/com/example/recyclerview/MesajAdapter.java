package com.example.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MesajAdapter extends RecyclerView.Adapter<MesajAdapter.CardTasarimTutucu> {

    List<MesajModel> mesajModels;
    Context mContex;

    public MesajAdapter(List<MesajModel> mesajModels, Context mContex) {
        this.mesajModels = mesajModels;
        this.mContex = mContex;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView isim,mesaj;

        public CardTasarimTutucu(View view)
        {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            isim = (TextView) view.findViewById(R.id.isim);
            mesaj = (TextView) view.findViewById(R.id.mesaj);
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View itemView = LayoutInflater.from(mContex).inflate(R.layout.card_tasarim,parent,false);

        return new CardTasarimTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, final int position)
    {
        holder.isim.setText(mesajModels.get(position).getIsim());
        holder.mesaj.setText(mesajModels.get(position).getMesaj());
        holder.imageView.setImageResource(mesajModels.get(position).getResimId());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContex,mesajModels.get(position).getIsim(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mesajModels.size();
    }

}
