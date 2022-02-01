package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView sayilar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        new arkaplan().execute(); // AsynTask Class'ının burada çağırıyoruz.
    }

    public void tanimla()
    {
        sayilar = (TextView) findViewById(R.id.sayilar);
    }



    // <Birincisi parametre, , Üçüncüsü dönüş tibi>
    // Methodların yerinin bir önemi yoktur.
    class arkaplan extends AsyncTask<Void,Integer,Void>
    {
        // İşlem öncesi çalıştırılacak method.
        // Örneğin Progrees dialogun çalışması gibi.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // tanimla() fonk burdada verilebilir.
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }


        // Bu doInBackgroun methodunun kesinlikle olması gerekiyor.
        // Araka plan işlmeleri burada yapılır.
        // Html Parsing işlemleri burada yapılır.
        @Override
        protected Void doInBackground(Void... voids) {

            for (int i =0; i < 5; i++){
                try {
                    // ilerlemeyi onProgressUpdate fonk. gönderiyoruz.
                    publishProgress(i);
                    Thread.sleep(2000);// 2 saniyede bir değişiyor.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }


        // Bir işlemin durumunun takip edilmesini sağlayan method.
        // <'', ikinci parametre, ''> İkinci parametreye veilen değer ile tip ile aynı tipi alır.
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Integer iDeger = values[0];
            Log.i("i değerleri",""+iDeger);
            sayilar.setText(String.valueOf(iDeger));
        }


        // Arka plan işlemi bittikten sonra yapılacaklar  burada yapılır.
        // Örneğin Progress dialogun kapatılmaıs gibi.
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            sayilar.setText("Nihayet bitti.");
            progressDialog.cancel();
        }


        // Arka plan işlemleri iptal edildiğinde çalışacak fonksiyon
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

}

