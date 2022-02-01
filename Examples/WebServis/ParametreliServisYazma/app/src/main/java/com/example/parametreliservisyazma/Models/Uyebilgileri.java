package com.example.parametreliservisyazma.Models;

public class Uyebilgileri{
	private String uyeokul;
	private String uyemailadres;
	private String uyeyas;
	private String uyeresim;
	private String uyeisim;

	public void setUyeokul(String uyeokul){
		this.uyeokul = uyeokul;
	}

	public String getUyeokul(){
		return uyeokul;
	}

	public void setUyemailadres(String uyemailadres){
		this.uyemailadres = uyemailadres;
	}

	public String getUyemailadres(){
		return uyemailadres;
	}

	public void setUyeyas(String uyeyas){
		this.uyeyas = uyeyas;
	}

	public String getUyeyas(){
		return uyeyas;
	}

	public void setUyeresim(String uyeresim){
		this.uyeresim = uyeresim;
	}

	public String getUyeresim(){
		return uyeresim;
	}

	public void setUyeisim(String uyeisim){
		this.uyeisim = uyeisim;
	}

	public String getUyeisim(){
		return uyeisim;
	}

	@Override
 	public String toString(){
		return 
			"Uyebilgileri{" + 
			"uyeokul = '" + uyeokul + '\'' + 
			",uyemailadres = '" + uyemailadres + '\'' + 
			",uyeyas = '" + uyeyas + '\'' + 
			",uyeresim = '" + uyeresim + '\'' + 
			",uyeisim = '" + uyeisim + '\'' + 
			"}";
		}
}
