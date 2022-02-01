package com.example.htmlparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final  String url = "http://yigitozen.tk/htmlparsing.html";
    Document document;
    private TextView textView, h1TextView, pTextView;
    private ImageView resim;
    private String h1Elemeti, imageUrl;
    Elements h1Element, pElements, srcElements, liElements;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new getirHtml().execute(); // getirHtml class'ını burada çağırıyouz.
    }


    public class getirHtml extends AsyncTask<Void,Void,Void>
    {

        // Araka plan işlemleri başlamadan önce yapılacak işlemeler.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView = findViewById(R.id.textView);
            h1TextView = findViewById(R.id.h1TextView);
            pTextView = findViewById(R.id.pTextView);
            resim = findViewById(R.id.resim);
        }

        // Bu method'un bulunma zorunluluğu var.
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                document = Jsoup.connect(url).get();

                h1Element = document.select("h1"); // h1 elementlerini alır.
                pElements = document.select("p"); // p elementleri içindekini alır.

                srcElements = document.select("img"); // <img> etiketi içindekileri alır.
                imageUrl = srcElements.attr("src"); // src kısmını aldık
                InputStream input = new java.net.URL(imageUrl).openStream();
                bitmap = BitmapFactory.decodeStream(input);

                //liElements = document.select("ol>li");// <ol> un içindeki <li> elementlerini alır.
                liElements = document.select("ul>li"); // <ul> un içindeki <li> elementlerini alır.
                //liElements = document.select("li");// <li> elementlerini alır.


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        // Sonuçların gösterilmesini sağlarız.
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Log.i("kaynak",""+document); // htmlparsing.html sayfasının kaynak kodları bize gelir.
            //Log.i("kaynak",""+document.title()); //Sadece Tittle'ı verir.
            textView.setText(document.title());

            h1Elemeti = h1Element.text();
            h1TextView.setText(h1Elemeti); // h1 elementi içindeki yazıları yazdırdık.

            pTextView.setText(pElements.text()); // <p> etiketi içindekileri yazdırır.

            /*Log.i("kaynak",""+srcElements);
            Log.i("kaynak",imageUrl);*/
            //resim.setImageBitmap(bitmap); // resim gösterme işlemi
            Picasso.get().load(imageUrl).into(resim);

            //Log.i("kaynak",""+liElements)
            for (int i = 0; i < liElements.size(); i++){
                //System.out.println(i+". li elementi = " + liElements.get(i).text());
                Log.i("li elementleri",(i+1) + ". li elementleri : " + liElements.get(i).text());
            }
        }
    }


}