package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.getTaxi.utils.DataConnect;
import com.getTaxi.utils.SessionUtils;

public class KontaktFormDAO {
public static void sendMessage(String message){
	 Connection con = null;
	 PreparedStatement ps = null;
	try{
		 con = DataConnect.getConnection();
         if (con != null) {
        	String sql="insert into mesazhe(mesazh_id, mesazhi, perdorues_id) values(?,?,?)";
        	 ps = con.prepareStatement(sql);
        	 String id=null;
        	 int perdoruesid=SessionUtils.getUserId();
        	 ps.setString(1,id);
        	 ps.setString(2,message);
        	 ps.setInt(3,perdoruesid);	
        	 ps.executeUpdate();
        	 System.out.println("Data added successfully!");
         }
	}catch(Exception e)
    {
     	System.out.println(e); 
     	}finally{
     		DataConnect.close(con);
     	}
}
}
