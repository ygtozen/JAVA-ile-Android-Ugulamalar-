package com.example.firebase8;

public class MesajModel {

    private String from;
    private String mesaj;

    public MesajModel() {
    }

    public MesajModel(String from, String mesaj) {
        this.from = from;
        this.mesaj = mesaj;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
}
