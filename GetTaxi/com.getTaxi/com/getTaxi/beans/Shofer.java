package com.getTaxi.beans;

public class Shofer {
private int shofer_id;
private String emerShoferi;
public int getShofer_id() {
	return shofer_id;
}
public void setShofer_id(int shofer_id) {
	this.shofer_id = shofer_id;
}
public String getEmerShoferi() {
	return emerShoferi;
}
public void setEmerShoferi(String emerShoferi) {
	this.emerShoferi = emerShoferi;
}
public Shofer(int shofer_id, String emerShoferi) {
	super();
	this.shofer_id = shofer_id;
	this.emerShoferi = emerShoferi;
}

}
