package com.getTaxi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.getTaxi.utils.DataConnect;

public class LoginDAO {
	private static int roli;
	private static int perdorues_id;
	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select username, password from perdoruesi where username = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
	public static int getRoliID(String user, String password){
		Connection con = null;
		PreparedStatement ps = null;
		try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "select roli_id from perdoruesi where username = '"
                        + user + "'";
                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                rs.next();
               roli=rs.getInt("roli_id");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }finally{
        	DataConnect.close(con);
        }
		return roli;
	}
	public static int getUserID(String user, String password){
		Connection con = null;
		PreparedStatement ps = null;
		try {
            con = DataConnect.getConnection();
            if (con != null) {
                String sql = "select perdorues_id from perdoruesi where username = '"
                        + user + "'";
                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                rs.next();
               perdorues_id=rs.getInt("perdorues_id");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
		return perdorues_id;
	}
}
