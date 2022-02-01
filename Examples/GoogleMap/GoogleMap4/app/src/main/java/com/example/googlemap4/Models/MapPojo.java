package com.example.googlemap4.Models;

public class MapPojo{
	private String lot;
	private String title;
	private String lat;

	public void setLot(String lot){
		this.lot = lot;
	}

	public String getLot(){
		return lot;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"MapPojo{" + 
			"lot = '" + lot + '\'' + 
			",title = '" + title + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}
