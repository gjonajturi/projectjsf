package com.getTaxi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.getTaxi.beans.Shofer;
import com.getTaxi.dao.ShoferDAO;

@ManagedBean(name="shoferController")
@SessionScoped
public class ShoferController {

	private List<Shofer> shofer;
	private ShoferDAO shoferdao;
	public String targa;
	public int shoferid;
	public String emri;
	public String mbiemri;
	public String username;
	public String password;
	public String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ShoferDAO getShoferdao() {
		return shoferdao;
	}
	public void setShoferdao(ShoferDAO shoferdao) {
		this.shoferdao = shoferdao;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setShofer(List<Shofer> shofer) {
		this.shofer = shofer;
	}
	public ShoferController() throws Exception{
		shofer = new ArrayList<>();
		shoferdao = ShoferDAO.getInstance();
	}
	public List<Shofer> getShofer(){
		return shofer;
	}
	public void loadShofer(){
		try{
			shofer = shoferdao.getShofer();
		}catch(Exception exc){
			System.out.println(exc);
		}
	}
	public String shtoShofer(){
		try{
			shoferdao.shtoShofer(this.emri,this.mbiemri,this.username,this.password, this.email);
		}catch(Exception exc){
			System.out.println(exc);
			return null;
		}
		return "taksist";
	}
	
}

