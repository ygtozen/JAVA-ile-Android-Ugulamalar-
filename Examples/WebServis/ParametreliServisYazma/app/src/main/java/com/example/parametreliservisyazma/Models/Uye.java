package com.example.parametreliservisyazma.Models;

public class Uye{
	private String password;
	private String id;
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Uye{" + 
			"id = '" + id + '\'' +
			",username = '" + username + '\'' +
			",password = '" + password + '\'' +
			"}";
		}
}
