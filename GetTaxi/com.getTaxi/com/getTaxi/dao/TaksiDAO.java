package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.getTaxi.beans.Taksi;
import com.getTaxi.utils.DataConnect;

public class TaksiDAO {
	private static TaksiDAO instance;
	int id;
	
	public static TaksiDAO getInstance() throws Exception{
		if (instance == null){
			instance = new TaksiDAO();
		}
		return instance;
	}
	
public List<Taksi> getTaksi() throws Exception{
	List<Taksi> taksi = new ArrayList<>();
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	try{
		myConn=DataConnect.getConnection();
		String sql="select * from taxi inner join perdoruesi on taxi.perdorues_id=perdoruesi.perdorues_id";
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()){
			int taksi_id=myRs.getInt("idTaxi");
			String targa = myRs.getString("targa");
			String emri=myRs.getString("username");
			Taksi tempTaksi = new Taksi(taksi_id, targa, emri);
			taksi.add(tempTaksi);
			
		}
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
	return taksi;
}
public void fshiTaksi(int id) throws Exception{
	Connection myConn = null;
	Statement myStmt = null;
	try{
		myConn = DataConnect.getConnection();
		
		String sql = "delete from taxi where idTaxi="+id;
		
		myStmt = myConn.createStatement();
		myStmt.execute(sql);
	}finally{
		DataConnect.close(myConn);
	}
}
public void shtoTaksi(String targa, int idshofer) throws Exception{
	Connection myConn = null;
	Statement myStmt = null;
	try{
		myConn = DataConnect.getConnection();
		
		String sql = "insert into taxi values(null,'"+targa+"','"+idshofer+"')";
		
		myStmt = myConn.createStatement();
		myStmt.execute(sql);
	}finally{
		DataConnect.close(myConn);
	}
}
}
