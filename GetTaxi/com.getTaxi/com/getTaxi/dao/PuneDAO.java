package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.getTaxi.beans.Rezervim;
import com.getTaxi.utils.DataConnect;

public class PuneDAO {
	
public static Rezervim returnRezervim(Date data,Date time,int idShoferi) throws SQLException{
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	Rezervim pune=new Rezervim();
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String time1 = sdf.format(time);
		myConn=DataConnect.getConnection();
		String sql="select * from rezervimi where data='"+data+"'AND oraFillim='"+time1+"' AND shofer_id='"+idShoferi+"'";
		System.out.println(sql);
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		myRs.next();
			pune.setStartlat(myRs.getFloat("startlat"));
			pune.setStartlng(myRs.getFloat("startlng"));
		
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
		return pune;

}
public static ArrayList<Rezervim> returnDayJobs(int idshoferi) throws SQLException{
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	ArrayList<Rezervim> dayJobs=new ArrayList<Rezervim>();
	
	try{
		myConn=DataConnect.getConnection();
		String sql="select * from rezervimi r inner join perdoruesi p on r.klient_id=p.perdorues_id where  shofer_id='"+idshoferi+"' and DATE(`data`) = DATE(NOW())";
		myStmt = myConn.createStatement();
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()){
			Rezervim job=new Rezervim();
			job.setTime(myRs.getTime("oraFillim"));
			 job.setDate(myRs.getDate("data"));
			 job.setEmail(myRs.getString("email"));
			dayJobs.add(job);
			
			
		}
	}catch(Exception exc){
		exc.printStackTrace();
		System.out.println(exc.getMessage());
	}
	finally{
		 myConn.close();
	}
	
	
	
	return dayJobs;
	
}

}
