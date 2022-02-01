package com.example.activityornekuygulama;

public class Model {

    private String isim;
    private String soyisim;
    private String numara;

    public Model() {
    }

    public Model(String isim, String soyisim, String numara) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.numara = numara;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }
}
