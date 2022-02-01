package com.example.firebase5;

public class UserBilgi {

    public String parola, yas, isim;

    public UserBilgi() {
    }

    public UserBilgi(String parola, String yas, String isim) {
        this.parola = parola;
        this.yas = yas;
        this.isim = isim;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
