package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.getTaxi.beans.Perdorues;
import com.getTaxi.utils.DataConnect;

public class PerdoruesDAO {
	private static PerdoruesDAO instance;
	int id;
	
	public static PerdoruesDAO getInstance() throws Exception{
		if (instance == null){
			instance = new PerdoruesDAO();
		}
		return instance;
	}
	
public List<Perdorues> getPerdorues() throws Exception{
	List<Perdorues> perdorues = new ArrayList<>();
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	try{
		myConn=DataConnect.getConnection();
		String sql="select username, emerRoli, perdorues_id, emri, mbiemri, email from perdoruesi inner join roli on perdoruesi.roli_id=roli.roli_id where perdoruesi.roli_id != '2' and perdoruesi.roli_id != '3'";
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()){
			String username = myRs.getString("username");
			String emerRoli = myRs.getString("emerRoli");
			int id = myRs.getInt("perdorues_id");
			String emri = myRs.getString("emri");
			String mbiemri = myRs.getString("mbiemri");
			String email = myRs.getString("email");
			Perdorues tempPerdorues = new Perdorues(emri, mbiemri, username, email, emerRoli, id);
			perdorues.add(tempPerdorues);
			
		}
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
	return perdorues;
}
public void fshiPerdorues(int id) throws Exception{
	Connection myConn = null;
	Statement myStmt = null;
	try{
		myConn = DataConnect.getConnection();
		
		String sql = "delete from perdoruesi where perdorues_id="+id;
		
		myStmt = myConn.createStatement();
		myStmt.execute(sql);
	}finally{
		DataConnect.close(myConn);
	}
}
}
