package com.getTaxi.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.getTaxi.dao.RezervimDAO;

@ManagedBean(name = "rezervim")
@RequestScoped
public class Rezervim {
private int perdorues_id;
private Float startlat;
private Float startlng;
private Float endlat;
private Float endlng;
private Date time;
private Date date;
public Date currentDate = new Date();
private String email;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getCurrentDate() {
	return currentDate;
}

public void setCurrentDate(Date currentDate) {
	this.currentDate = currentDate;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Date getTime() {
	return time;
}


public void setTime(Date time) {
	this.time = time;
}

public Rezervim(){
	
}
public int getPerdorues_id() {
	return perdorues_id;
}
public void setPerdorues_id(int perdorues_id) {
	this.perdorues_id = perdorues_id;
}


public Float getStartlat() {
	return startlat;
}
public void setStartlat(Float startlat) {
	this.startlat = startlat;
}
public Float getStartlng() {
	return startlng;
}
public void setStartlng(Float startlng) {
	this.startlng = startlng;
}
public Float getEndlat() {
	return endlat;
}
public void setEndlat(Float endlat) {
	this.endlat = endlat;
}
public Float getEndlng() {
	return endlng;
}
public void setEndlng(Float endlng) {
	this.endlng = endlng;
}
public Rezervim returnRezervim(){
	return this;
}

public String addRezervim(Date date,Date time, Float startlat,Float startlng, Float endlat,Float endlng) throws Exception{
	String pageDirect = RezervimDAO.shtoRezervim(date, time, startlat, startlng,endlat,endlng);
	return pageDirect;
}
}
