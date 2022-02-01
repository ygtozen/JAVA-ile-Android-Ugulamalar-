package com.example.webservis4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.webservis4.Models.Result;
import com.example.webservis4.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityDetay extends AppCompatActivity {

    private String id,postId;
    private TextView postId2,id2,name2,email2,body2;
    private List<Result> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        tanimla();
        veriAl();
        istek();
    }

    public void tanimla()
    {
        postId2 = findViewById(R.id.postId2);
        id2 = findViewById(R.id.id2);
        name2 = findViewById(R.id.name2);
        email2 = findViewById(R.id.email2);
        body2 = findViewById(R.id.body2);
    }

    public void veriAl()
    {
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        postId = bundle.getString("postId");
        //Log.i("aldegerler","postId = " + postId + " , " + "id = " + id);
    }

    public void atama(List<Result> list)
    {
        postId2.setText(""+list.get(0).getPostId());
        id2.setText(""+list.get(0).getId());
        name2.setText(list.get(0).getName());
        email2.setText(list.get(0).getEmail());
        body2.setText(list.get(0).getBody());
    }

    public void istek()
    {
        list = new ArrayList<>();

        Call<List<Result>> call = ManagerAll.getInstance().managerGetResult(postId,id);
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                //Log.i("başarılı",response.body().get(0).getEmail());
                if (response.isSuccessful())
                {
                    list = response.body();
                    atama(list);
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }
}