package com.example.dbtojson.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.dbtojson.MainActivity;
import com.example.dbtojson.Models.Result;
import com.example.dbtojson.R;
import com.example.dbtojson.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogClass {

    Activity activity;
    Context mContex;

    public DialogClass(Activity activity, Context mContex) {
        this.activity = activity;
        this.mContex = mContex;
    }

    public void goster(final String id)
    {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        Button iptal = view.findViewById(R.id.iptal);
        Button sil = view.findViewById(R.id.sil);

        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setView(view);
        alert.setCancelable(false);// ekranın herhangi bir yerine basıldığında kapanmaz
        final AlertDialog alertDialog = alert.create();

        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Result> sil = ManagerAll.getInstance().deleteFromDb(id);
                sil.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        MainActivity mainActivity = new MainActivity();
                        mainActivity.yenile();
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });

                alertDialog.cancel();
            }
        });

        alertDialog.show();
    }

}
