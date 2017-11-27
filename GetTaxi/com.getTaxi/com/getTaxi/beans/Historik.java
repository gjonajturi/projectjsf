package com.getTaxi.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean

@RequestScoped
public class Historik {
private Date data;
private Date ora;
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public Date getOra() {
	return ora;
}
public void setOra(Date ora) {
	this.ora = ora;
}

public Historik(){
	
}

}
