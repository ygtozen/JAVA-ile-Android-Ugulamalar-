package com.example.realmveritabani1;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class KisilerTablosu extends RealmObject {

    private String kisiAd;
    private String kisiSoyad;
    private Integer maas;
    private Integer yas;

    public String getKisiAd() {
        return kisiAd;
    }

    public void setKisiAd(String kisiAd) {
        this.kisiAd = kisiAd;
    }

    public String getKisiSoyad() {
        return kisiSoyad;
    }

    public void setKisiSoyad(String kisiSoyad) {
        this.kisiSoyad = kisiSoyad;
    }

    public Integer getMaas() {
        return maas;
    }

    public void setMaas(Integer maas) {
        this.maas = maas;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    @Override
    public String toString() {
        return "KisilerTablosu{" +
                "kisiAd='" + kisiAd + '\'' +
                ", kisiSoyad='" + kisiSoyad + '\'' +
                ", maas=" + maas +
                ", yas=" + yas +
                '}';
    }
}
