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
import com.getTaxi.beans.Mesazh;
import com.getTaxi.beans.Perdorues;
import com.getTaxi.utils.DataConnect;
import com.getTaxi.utils.SessionUtils;

public class MesazhDAO {
	private static MesazhDAO instance;
	int id;
	
	public static MesazhDAO getInstance() throws Exception{
		if (instance == null){
			instance = new MesazhDAO();
		}
		return instance;
	}
	
public List<Mesazh> getMesazhe() throws Exception{
	List<Mesazh> mesazhe = new ArrayList<>();
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	try{
		myConn=DataConnect.getConnection();
		String sql="select * from mesazhe inner join perdoruesi on mesazhe.perdorues_id=perdoruesi.perdorues_id";
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()){
			String emri=myRs.getString("emri");
			String mbiemri=myRs.getString("mbiemri");
			String mesazhi=myRs.getString("mesazhi");
			Mesazh tempMesazh = new Mesazh();
			tempMesazh.setEmri(emri);
			tempMesazh.setMbiemri(mbiemri);
			tempMesazh.setMesazhi(mesazhi);
			mesazhe.add(tempMesazh);
			
		}
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
	return mesazhe;
}

}
