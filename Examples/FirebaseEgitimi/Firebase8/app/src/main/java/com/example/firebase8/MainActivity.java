package com.example.firebase8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    String userId, otherId;
    String user, other, key;

    List<MesajModel> list;
    RecyclerView rv;
    MesajAdapter mesajAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(manager);
        mesajAdapter = new MesajAdapter(list,MainActivity.this);
        rv.setAdapter(mesajAdapter);

        userId = "1";
        otherId = "2";

        SendMessage("selam",userId);
        SendMessage("ne zaman",otherId);
        SendMessage("saat kaç",userId);
        SendMessage("tamam",otherId);
        SendMessage("ok",userId);
        SendMessage("hangi gün",otherId);
        SendMessage("hangi takımlısın",otherId);
        SendMessage("sanane",userId);
        SendMessage("niye",userId);
        SendMessage("asdasd",userId);
        SendMessage("lolololo",otherId);
        SendMessage("tmamamamma",userId);

        load();

    }

    public void SendMessage(String mesajbody, String id) // Mesajlaşma
    {
        // Biz mesajları silsek bile mesajlaştığımız kişide mesajlar kalması için iki tane yaptıp.
        // Bir tane yapsak herkezden silinir.

        user = "messages/" + userId + "/" + otherId; // mesaj tablosu + bizim id miz + karşıdaki id
        other = "messages/" + otherId + "/" + userId; // Mesajlaştığımız kişi için

        // Key oluşturalım
        key = myRef.child("messages").child(userId).child(otherId).push().getKey();
        // Burada hem bizim keyimiz hemde mesajlaştığımız kişinin key'i alınır.

        Log.i("keyim",key);

        Map map = send(mesajbody,id);


        Map map2 = new HashMap();
        map2.put(user+"/"+key,map);
        map2.put(other+"/"+key,map);

        myRef.updateChildren(map2, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

            }
        });

    }

    public Map send(String mesajbody,String userId)
    {
        Map msj = new HashMap();
        msj.put("mesaj",mesajbody);
        msj.put("from",userId); // Mesaj Gönderici
        return  msj;
    }


    public void load() // Mesajların listelenmesi işlemi
    {
        myRef.child("messages").child(userId).child(otherId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MesajModel m = snapshot.getValue(MesajModel.class);
                list.add(m);
                mesajAdapter.notifyDataSetChanged(); // Güncellem için
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MesajModel m = snapshot.getValue(MesajModel.class);
                list.add(m);
                mesajAdapter.notifyDataSetChanged(); // Güncellem için
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                MesajModel m = snapshot.getValue(MesajModel.class);
                list.add(m);
                mesajAdapter.notifyDataSetChanged(); // Güncellem için
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}