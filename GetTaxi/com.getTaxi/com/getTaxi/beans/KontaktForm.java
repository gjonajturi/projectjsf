package com.getTaxi.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.getTaxi.dao.KontaktFormDAO;
@RequestScoped
@ManagedBean(name="mail")
public class KontaktForm {
private String message;


public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public void sendMessage(String message){
	KontaktFormDAO.sendMessage(message);
}
}
