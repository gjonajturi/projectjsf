package com.getTaxi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.getTaxi.beans.Taksi;
import com.getTaxi.dao.TaksiDAO;

@ManagedBean(name="taksiController")
@SessionScoped
public class TaksiController {

	private List<Taksi> taksi;
	private TaksiDAO taksidao;
	public String targa;
	public int shoferid;
	
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
	public TaksiController() throws Exception{
		taksi = new ArrayList<>();
		taksidao = TaksiDAO.getInstance();
	}
	public List<Taksi> getTaksi(){
		return taksi;
	}
	public void loadTaksi(){
		try{
			taksi = taksidao.getTaksi();
		}catch(Exception exc){
			System.out.println(exc);
		}
	}
	public String fshiTaksi(int id){
		try{
			taksidao.fshiTaksi(id);
		}catch(Exception exc){
			System.out.println(exc);
			return null;
		}
		return "taksi";
	}
	public String shtoTaksi(){
		try{
			taksidao.shtoTaksi(this.targa,this.shoferid);
		}catch(Exception exc){
			System.out.println(exc);
			return null;
		}
		return "taksi";
	}
	
}

