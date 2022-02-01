package com.example.realminsertview;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class KisiBilgileri extends RealmObject {

    private String kullaniciAdi;
    private String isim;
    private String sifre;
    private String cinsiyet;

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @Override
    public String toString() {
        return "KisiBilgileri{" +
                "kullaniciAdi='" + kullaniciAdi + '\'' +
                ", isim='" + isim + '\'' +
                ", sifre='" + sifre + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                '}';
    }
}
