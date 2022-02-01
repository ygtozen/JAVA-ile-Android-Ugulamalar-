package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        //goster();
        gosterHtml();
    }

    public void tanimla(){
        webView = findViewById(R.id.webView);
    }

    public void goster()
    {
        webView.getSettings().setJavaScriptEnabled(true); // js kodlarının çalışmaına izin verir
        webView.loadUrl("https://www.google.com.tr");
    }

    public void gosterHtml()
    {
        String htmlKod = "<html><head>WebView Html Örneği</head>" +
                "<body><h1>Html Örneği</h1></body></html>";

        webView.loadData(htmlKod,"text/html","UTF-8");
    }
}