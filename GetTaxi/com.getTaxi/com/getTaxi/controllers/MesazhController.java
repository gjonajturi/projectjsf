package com.getTaxi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.getTaxi.beans.Mesazh;
import com.getTaxi.dao.MesazhDAO;

@ManagedBean(name="mesazheController")
@SessionScoped
public class MesazhController {

	private List<Mesazh> mesazhe;
	private MesazhDAO mesazhdao;
	
	public MesazhController() throws Exception{
		mesazhe = new ArrayList<>();
		mesazhdao = MesazhDAO.getInstance();
	}
	public List<Mesazh> getMesazhe(){
		return mesazhe;
	}
	public void loadMesazhe(){
		try{
			mesazhe= mesazhdao.getMesazhe();
		}catch(Exception exc){
			System.out.println(exc);
		}
	}
	
}
