package com.getTaxi.beans;

public class Taksi{
	private int taksi_id;
	private String targa;
	private String emerShoferi;
	private int shoferid;
	public int getTaksi_id() {
		return taksi_id;
	}
	public void setTaksi_id(int taksi_id) {
		this.taksi_id = taksi_id;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getShoferid() {
		return shoferid;
	}
	public void setShoferid(int shoferid) {
		this.shoferid = shoferid;
	}
	public String getEmerShoferi() {
		return emerShoferi;
	}
	public void setEmerShoferi(String emerShoferi) {
		this.emerShoferi = emerShoferi;
	}
	public Taksi(int taksi_id, String targa, String emri) {
		super();
		this.taksi_id = taksi_id;
		this.targa = targa;
		this.emerShoferi=emri;
	}
	
	
}

