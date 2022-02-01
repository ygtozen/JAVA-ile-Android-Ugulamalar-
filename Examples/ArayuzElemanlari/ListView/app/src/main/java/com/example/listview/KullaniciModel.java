package com.example.listview;

public class KullaniciModel {

    String ad;
    String soyad;
    String yas;
    String takimi;

    public KullaniciModel() {
    }

    public KullaniciModel(String ad, String soyad, String yas, String takimi) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.takimi = takimi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getTakimi() {
        return takimi;
    }

    public void setTakimi(String takimi) {
        this.takimi = takimi;
    }
}
