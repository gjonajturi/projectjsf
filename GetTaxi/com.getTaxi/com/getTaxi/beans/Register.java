package com.getTaxi.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.getTaxi.dao.RegisterDAO;


@ManagedBean(name = "register")
@RequestScoped
public class Register {

    private String username;
    private String password;
    private String emri;
    private String mbiemri;
    private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

public String shtoPerdorues(){
	 RegisterDAO.shtoPerdorues(username, password, emri, mbiemri, email);
	 emri = null;
	 username=null;
	 mbiemri=null;
	 email=null;
	    return null ;
}
public void info() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration successful", "Registration successful."));
}
}
