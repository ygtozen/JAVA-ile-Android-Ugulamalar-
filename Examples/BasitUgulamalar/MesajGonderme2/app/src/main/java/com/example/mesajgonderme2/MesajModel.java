package com.example.mesajgonderme2;

public class MesajModel {

    private String isim;
    private String tel;

    public MesajModel() {
    }

    public MesajModel(String isim, String tel) {
        this.isim = isim;
        this.tel = tel;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
