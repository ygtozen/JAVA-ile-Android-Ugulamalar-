package com.example.realminsertview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    private EditText editTextKullanici, editTextIsim, sifre;
    private RadioGroup cinsiyetRadio;
    private Button kayitOl,guncelle;
    private ListView listView;
    private int positionT = 0;
    private String kullaniciText,isimText,sifreText,cinsiyetText;
    RealmResults<KisiBilgileri> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        RealmTanimla();
        kayitEkle();
        goster();
        pozisyonBul();
    }

    public void RealmTanimla() {
        realm = Realm.getDefaultInstance();
    }

    public void tanimla() {
        editTextKullanici = findViewById(R.id.editTextKullanici);
        editTextIsim = findViewById(R.id.editTextIsim);
        sifre = findViewById(R.id.sifre);
        cinsiyetRadio = findViewById(R.id.cinsiyetRadio);
        kayitOl = findViewById(R.id.kayitOl);
        guncelle = findViewById(R.id.guncelle);
        listView = findViewById(R.id.listView);
    }

    public void kayitEkle() {
        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BilgileriAl();

                yaz(kullaniciText, isimText, sifreText, cinsiyetText);

                editTextKullanici.setText("");
                editTextIsim.setText("");
                sifre.setText("");
            }
        });

        guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VeriTabanindanListeGetir();

                final KisiBilgileri kisi = list.get(positionT);

                BilgileriAl();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        kisi.setKullaniciAdi(kullaniciText);
                        kisi.setIsim(isimText);
                        kisi.setSifre(sifreText);
                        kisi.setCinsiyet(cinsiyetText);
                    }
                });
                goster();
            }
        });
    }

    public void yaz(final String kullaniciAdi, final String isim, final String sifre, final String cinsiyet) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                KisiBilgileri kisiBilgileri = realm.createObject(KisiBilgileri.class);
                kisiBilgileri.setKullaniciAdi(kullaniciAdi);
                kisiBilgileri.setIsim(isim);
                kisiBilgileri.setSifre(sifre);
                kisiBilgileri.setCinsiyet(cinsiyet);

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                goster();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(getApplicationContext(), "Kayıt başarısız", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goster() {
        VeriTabanindanListeGetir();

        /*for (KisiBilgileri k : kisiBilgileri)
        {
            Log.i("Kayıtlar",k.toString());
        }*/

        if (list.size() > 0) {
            KisiAdapter adapter = new KisiAdapter(list, getApplicationContext());
            listView.setAdapter(adapter);
        }
    }

    public void pozisyonBul()
    {
        VeriTabanindanListeGetir();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sil(position);
                //Log.i("PozisyonGelen",""+position);
                alertAc(position);
                editTextKullanici.setText(list.get(position).getKullaniciAdi());
                editTextIsim.setText(list.get(position).getIsim());
                sifre.setText(list.get(position).getSifre());
                if (list.get(position).getCinsiyet().equals("Erkek"))
                {
                    ((RadioButton)cinsiyetRadio.getChildAt(0)).setChecked(true);
                }
                else
                {
                    ((RadioButton)cinsiyetRadio.getChildAt(1)).setChecked(true);
                }

                positionT = position;
            }
        });
    }

    public void sil(final int position) {
        VeriTabanindanListeGetir();
        Log.i("name", "Liste eleman sayısı:" + list.get(position).getKullaniciAdi());

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                KisiBilgileri kisi = list.get(position);
                kisi.deleteFromRealm();
                goster();

                editTextKullanici.setText("");
                editTextIsim.setText("");
                sifre.setText("");
            }
        });
    }

    public void alertAc(final int position) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_layout, null);

        Button evet = view.findViewById(R.id.evet);
        Button hayir = view.findViewById(R.id.hayir);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(view);
        alert.setCancelable(false);

        final AlertDialog dialog = alert.create();
        evet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sil(position);
                dialog.cancel();
            }
        });

        hayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public void BilgileriAl()
    {
        Integer id = cinsiyetRadio.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(id);
        cinsiyetText = radioButton.getText().toString();

        kullaniciText = editTextKullanici.getText().toString();
        isimText = editTextIsim.getText().toString();
        sifreText = sifre.getText().toString();
    }

    public void VeriTabanindanListeGetir()
    {
        list = realm.where(KisiBilgileri.class).findAll();
    }
}



