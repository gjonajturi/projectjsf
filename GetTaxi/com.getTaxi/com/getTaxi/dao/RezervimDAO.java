package com.getTaxi.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.getTaxi.utils.DataConnect;
import com.getTaxi.utils.SessionUtils;

public class RezervimDAO{
	

	public static String shtoRezervim(Date date,Date time, Float startlat,Float startlng, Float endlat,Float endlng)throws Exception{
		 PreparedStatement ps = null;
         Connection con = null;
         String status = "successConfirmation";
         try {
                 con = DataConnect.getConnection();
                 if (con != null) {
                     String sql = "INSERT INTO rezervimi(rezervim_id, startlat, startlng, endlat,endlng,data,oraFillim,klient_id, shofer_id) VALUES(?,?,?,?,?,?,?,?,?)";
                     ps = con.prepareStatement(sql);
                     String id=null;
                     int klientid=SessionUtils.getUserId();
                     GregorianCalendar c=new GregorianCalendar();
                     c.setTime(time);
                     c.add(GregorianCalendar.HOUR, 2);
                     Date time2= c.getTime();
                     int shoferid = taksistLire(time, time2, date);
                     System.out.println(shoferid);
                     if(shoferid == 0){
                    	 status="errorConfirmation";
                     }
                     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                     String time1 = sdf.format(time);
                     java.sql.Date sDate = convertUtilToSql(date);
                     ps.setString(1, id);
                     ps.setFloat(2,startlat);
                     ps.setFloat(3,startlng);
                     ps.setFloat(4,endlat);
                     ps.setFloat(5,endlng);
                     ps.setDate(6, sDate);
                     ps.setString(7,time1);
                     ps.setInt(8, klientid);
                     ps.setInt(9, shoferid);
                     ps.executeUpdate();
                     System.out.println("Data Added Successfully");
                 }
         } catch(Exception e)
         {
         	System.out.println(e); 
         	}finally{
         		DataConnect.close(con);
         	}
		return status;}
         private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
             java.sql.Date sDate = new java.sql.Date(uDate.getTime());
             return sDate;
         }
         private static int taksistLire(Date oraF, Date oraM, Date date){
        
             Connection con = null;
             Statement stmt; 
             ResultSet rs;
             int ajoqeduhet = 0;
             int shofer = 0;
             try {
                 con = DataConnect.getConnection();
                 if (con != null) {
                	 java.sql.Date sDate = convertUtilToSql(date);
                	 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                     String time1 = sdf.format(oraF);
                     String time2 = sdf.format(oraM);
                  String sql = "select k.perdorues_id from perdoruesi k where k.roli_id=3 AND k.perdorues_id NOT IN(select r.shofer_id from rezervimi r where NOT(r.oraMbarim<'"+time1+" 'OR r.oraFillim>'"+time2+"')AND data='"+sDate+"')";
                  System.out.println(sql);
                  stmt = con.createStatement();
                  rs=stmt.executeQuery(sql);
                  while(rs.next()){
                  shofer = rs.getInt("perdorues_id");
                  ajoqeduhet=shofer;
                     System.out.println("Cab Driver Selected Successfully");
                     break;} 	
                 }
         } catch(Exception e)
         {
         	System.out.println(e);
         	}finally{
         		DataConnect.close(con);
         	}
			return ajoqeduhet;    
         }
        
}
