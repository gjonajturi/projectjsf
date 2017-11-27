package com.getTaxi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.getTaxi.beans.Perdorues;
import com.getTaxi.dao.PerdoruesDAO;

@ManagedBean(name="perdoruesController")
@SessionScoped
public class PerdoruesController {

	private List<Perdorues> perdorues;
	private PerdoruesDAO perdoruesdao;
	
	public PerdoruesController() throws Exception{
		perdorues = new ArrayList<>();
		perdoruesdao = PerdoruesDAO.getInstance();
	}
	public List<Perdorues> getPerdorues(){
		return perdorues;
	}
	public void loadPerdorues(){
		try{
			perdorues = perdoruesdao.getPerdorues();
		}catch(Exception exc){
			System.out.println(exc);
		}
	}
	public String fshiPerdorues(int id){
		try{
			perdoruesdao.fshiPerdorues(id);
		}catch(Exception exc){
			System.out.println(exc);
			return null;
		}
		return "menaxhimPerdorues";
	}
	
}
