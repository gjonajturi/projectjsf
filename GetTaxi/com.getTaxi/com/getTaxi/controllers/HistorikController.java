package com.getTaxi.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.getTaxi.beans.Historik;
import com.getTaxi.beans.Perdorues;
import com.getTaxi.dao.HistorikDAO;
import com.getTaxi.dao.PerdoruesDAO;

@ManagedBean(name="historikController")
@SessionScoped
public class HistorikController {

	private List<Historik> rezervime;
	private HistorikDAO historikdao;
	
	public HistorikController() throws Exception{
		rezervime = new ArrayList<>();
		historikdao = HistorikDAO.getInstance();
	}
	public List<Historik> getRezervime(){
		return rezervime;
	}
	public void loadRezervime(){
		try{
			rezervime = historikdao.getRezervime();
		}catch(Exception exc){
			System.out.println(exc);
		}
	}
	public String fshiRezervim(Date date, Date time){
		try{
			historikdao.fshiRezervim(date, time);
		}catch(Exception exc){
			System.out.println(exc);
			return null;
		}
		return "historik";
	}
	
}
