package com.example.urunlerlisteleme.Models;

public class Urunler{
	private String urunResim;
	private String urunAdi;
	private String urunFiyat;
	private String id;

	public void setUrunResim(String urunResim){
		this.urunResim = urunResim;
	}

	public String getUrunResim(){
		return urunResim;
	}

	public void setUrunAdi(String urunAdi){
		this.urunAdi = urunAdi;
	}

	public String getUrunAdi(){
		return urunAdi;
	}

	public void setUrunFiyat(String urunFiyat){
		this.urunFiyat = urunFiyat;
	}

	public String getUrunFiyat(){
		return urunFiyat;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Urunler{" + 
			"id = '" + id + '\'' +
			",urunAdi = '" + urunAdi + '\'' + 
			",urunFiyat = '" + urunFiyat + '\'' + 
			",urunResim = '" + urunResim + '\'' +
			"}";
		}
}
