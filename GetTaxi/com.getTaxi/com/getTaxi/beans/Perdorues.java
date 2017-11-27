package com.getTaxi.beans;

public class Perdorues {
	private String username;
	private String roli;
	private int id;
	private String emri;
	private String mbiemri;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmri() {
		return emri;
	}
	public void setEmri(String emri) {
		this.emri = emri;
	}
	public String getMbiemri() {
		return mbiemri;
	}
	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Perdorues(String emri, String mbiemri, String username, String email, String emerRoli, int id) {
		this.username = username;
		this.roli= emerRoli;
		this.id=id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoli() {
		return roli;
	}
	public void setRoli(String roli) {
		this.roli = roli;
	}
	
}
