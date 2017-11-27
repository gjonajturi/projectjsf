package com.getTaxi.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.getTaxi.dao.LoginDAO;
import com.getTaxi.utils.SessionUtils;

@ManagedBean(name = "login")
@SessionScoped
public class Login {
	private String pwd;
	private String user;
	private int role;
	private boolean valid;
	private int perdorues_id;
	
		public int getPerdorues_id() {
		return perdorues_id;
	}
	public void setPerdorues_id(int perdorues_id) {
		this.perdorues_id = perdorues_id;
	}
		public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	//validate login
	public String goToPageRegister(){
		return "register";
	}
	public String validateUsernamePassword() {
		valid = LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			perdorues_id=LoginDAO.getUserID(user, pwd);
			session.setAttribute("perdorues_id", perdorues_id);
			role = LoginDAO.getRoliID(user, pwd);	
			if (role==1){
			return "rezervim";}
			else if(role==2){
				return "admin";
			}
			else if (role==3){
				return "shoferi";
			}
			else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Incorrect Username and Password",
								"Please enter correct username and Password"));
				return "error";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Password",
							"Please enter correct username and Password"));
			return "error";
		}
			
	}
	
	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login.xhtml";
	}
	
}