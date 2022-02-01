package com.example.realmgrafik;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class Tansiyon extends RealmObject {

    private String buyukTansiyon;
    private String kucukTansiyon;

    public String getBuyukTansiyon() {
        return buyukTansiyon;
    }

    public void setBuyukTansiyon(String buyukTansiyon) {
        this.buyukTansiyon = buyukTansiyon;
    }

    public String getKucukTansiyon() {
        return kucukTansiyon;
    }

    public void setKucukTansiyon(String kucukTansiyon) {
        this.kucukTansiyon = kucukTansiyon;
    }

    @Override
    public String toString() {
        return "Tansiyon{" +
                "buyukTansiyon='" + buyukTansiyon + '\'' +
                ", kucukTansiyon='" + kucukTansiyon + '\'' +
                '}';
    }
}
