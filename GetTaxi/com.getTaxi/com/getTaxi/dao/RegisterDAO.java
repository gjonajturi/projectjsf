package com.getTaxi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.getTaxi.utils.DataConnect;

public class RegisterDAO {
	 public static boolean shtoPerdorues(String username, String password, String emri, String mbiemri, String email) {
	        int i = 0;
	        if (username!= null) {
	            PreparedStatement ps = null;
	            Connection con = null;
	            try {
	                    con = DataConnect.getConnection();
	                    if (con != null) {
	                        String sql = "INSERT INTO perdoruesi(perdorues_id, emri, mbiemri, username, password,email, roli_id) VALUES(?,?,?,?,?,?,?)";
	                        ps = con.prepareStatement(sql);
	                        String perdoruesid=null;
	                        String roli="1";
	                        ps.setString(1, perdoruesid);
	                        ps.setString(2, emri);
	                        ps.setString(3, mbiemri);
	                        ps.setString(4, username);
	                        ps.setString(5, password);
	                        ps.setString(6, email);
	                        ps.setString(7, roli);
	                        i = ps.executeUpdate();
	                        System.out.println("Data Added Successfully");
	                    }
	            } catch(Exception e)
	            {
	            	System.out.println(e); 
	            	}finally{
	            		DataConnect.close(con);
	            	}
	        }
	        if (i > 0) {
	            return true;
	        } else
	            return false;
	    }
}
