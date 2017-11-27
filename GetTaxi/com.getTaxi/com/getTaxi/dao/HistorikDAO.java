package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import com.getTaxi.beans.Historik;
import com.getTaxi.beans.Perdorues;
import com.getTaxi.utils.DataConnect;
import com.getTaxi.utils.SessionUtils;

public class HistorikDAO {
	private static HistorikDAO instance;
	int id;
	
	public static HistorikDAO getInstance() throws Exception{
		if (instance == null){
			instance = new HistorikDAO();
		}
		return instance;
	}
	
public List<Historik> getRezervime() throws Exception{
	List<Historik> rezervime = new ArrayList<>();
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	try{
		myConn=DataConnect.getConnection();
		int perdorues_id=SessionUtils.getUserId();
		String sql="select data, oraFillim from rezervimi where klient_id="+perdorues_id;
		System.out.print(sql);
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()){
			Date data=myRs.getDate("data");
			Date ora=myRs.getTime("oraFillim");
			Historik tempHistorik = new Historik();
			tempHistorik.setData(data);
			tempHistorik.setOra(ora);
			rezervime.add(tempHistorik);
			
		}
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
	return rezervime;
}
public void fshiRezervim(Date date, Date time) throws Exception{
	Connection myConn = null;
	Statement myStmt = null;
	try{
		myConn = DataConnect.getConnection();
		int id=SessionUtils.getUserId();
		String sql = "delete from rezervimi where data='"+date+"' and oraFillim='"+time+"' and klient_id="+id;
		System.out.println(sql);
		myStmt = myConn.createStatement();
		myStmt.execute(sql);
	}finally{
		DataConnect.close(myConn);
	}
}
}
