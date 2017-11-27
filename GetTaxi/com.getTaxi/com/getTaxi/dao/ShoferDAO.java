package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.getTaxi.beans.Shofer;
import com.getTaxi.utils.DataConnect;

public class ShoferDAO {
	private static ShoferDAO instance;
	int id;
	
	public static ShoferDAO getInstance() throws Exception{
		if (instance == null){
			instance = new ShoferDAO();
		}
		return instance;
	}
	
public List<Shofer> getShofer() throws Exception{
	List<Shofer> shofer = new ArrayList<>();
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	try{
		myConn=DataConnect.getConnection();
		String sql="select perdorues_id, emri from perdoruesi where roli_id=3";
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()){
			int shofer_id=myRs.getInt("perdorues_id");
			String emri=myRs.getString("emri");
			Shofer tempShofer = new Shofer(shofer_id, emri);
			shofer.add(tempShofer);
			
		}
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
	return shofer;
}
public void shtoShofer(String emri, String mbiemri, String username, String password, String email) throws Exception{
	Connection myConn = null;
	Statement myStmt = null;
	try{
		myConn = DataConnect.getConnection();
		int roli=3;
		String sql = "insert into perdoruesi values(null,'"+emri+"','"+mbiemri+"','"+username+"','"+password+"','"+email+"','"+roli+"')";
		
		myStmt = myConn.createStatement();
		myStmt.execute(sql);
	}finally{
		DataConnect.close(myConn);
	}
}
}
