package com.getTaxi.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.getTaxi.beans.Rezervim;
import com.getTaxi.dao.PuneDAO;
import com.getTaxi.utils.SessionUtils;

@ManagedBean(name="pune")
@SessionScoped
public class PuneController {
private ArrayList<Rezervim> jobs;

public ArrayList<Rezervim> getJobs() {
	return jobs;
}

public void setJobs(ArrayList<Rezervim> jobs) {
	this.jobs = jobs;
}

public void loadJobs(){
	int shoferID=SessionUtils.getUserId();
	try {
		jobs=PuneDAO.returnDayJobs(shoferID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public String toMap(Date data,Date time){
	int shoferID=SessionUtils.getUserId();
	Rezervim rezervimToMap=new Rezervim();
	try {
		rezervimToMap=PuneDAO.returnRezervim(data, time, shoferID);
		ExternalContext external= FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> requestMap=external.getRequestMap();
		System.out.println(rezervimToMap.getStartlat());
		requestMap.put("puna", rezervimToMap);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return "viewToMap";
	
}


public PuneController() {
	super();
jobs=new ArrayList<Rezervim>();
}
}
