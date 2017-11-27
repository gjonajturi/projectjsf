package ServicesDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Util;

import ManagedBeans.Allowences;
import ManagedBeans.Employee;
import ManagedBeans.HomePage;
import ManagedBeans.Msg;
//import com.journaldev.jsf.util.DataConnect;
import ManagedBeans.Shift;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select uname, pasword from users where uname = ? and pasword = ?");
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
	
	public static ArrayList<Msg> getPosts () {
		
		ArrayList<Msg> posts=new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select * from posts,employee where posts.id_emp=employee.id_emp");
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//result found, means valid inputs
				String msg=rs.getString("post"); String n=rs.getString("name"); int i=rs.getInt("id");
				posts.add(new Msg(i,msg,n));
				
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
		} finally {
			DataConnect.close(con);
		}
		return posts;
	}
	
	//get allowences
	
public static ArrayList<Allowences> getAllowences () {
		
		ArrayList<Allowences> allowences=new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select * from pendingallowences,employee where pendingallowences.id_emp=employee.id_emp");
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//result found, means valid inputs
				int id=rs.getInt("allow_id"); int id_emp=rs.getInt("id_emp"); Date s=rs.getDate("date_start"); Date e=rs.getDate("date_end");
				String name=rs.getString("name");
				allowences.add(new Allowences(id,id_emp,s,e,name));
				
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
		} finally {
			DataConnect.close(con);
		}
		return allowences;
	}

//aprove allowences

public static void aprove(int id)  {
	Connection con = null;
	PreparedStatement ps = null;
	
	int u;
	
	try{
		con = DataConnect.getConnection();
		Statement s = con.createStatement();
		// 3. Execute SQL query
		 ps = con.prepareStatement("Select * from pendingallowences where allow_id='"+id+"' ");
			

			ResultSet rs = ps.executeQuery();
			int idEmp = 0;Date start = null,end = null;
			while(rs.next())
			{
			  idEmp=rs.getInt("id_emp");  start=rs.getDate("date_start");  end=rs.getDate("date_end");
			}
			
			u = s.executeUpdate("INSERT into allowences(allow_id,id_emp,date_start,date_end)"
		            +"values('"+id+"','"+idEmp+"','"+start+"','"+end+"')");
		 u = s.executeUpdate("DELETE from pendingallowences where allow_id='"+id+"' " );
		
		 
		 
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}

//disprove allowences

public static void disprove(int id)  {
	Connection con = null;
	PreparedStatement ps = null;
	
	int u;
	
	try{
		con = DataConnect.getConnection();
		Statement s = con.createStatement();
		// 3. Execute SQL query
		 ps = con.prepareStatement("Select * from pendingallowences where allow_id='"+id+"' ");
			

			ResultSet rs = ps.executeQuery();
			int idEmp = 0;Date start = null,end = null;
			while(rs.next())
			{
			  idEmp=rs.getInt("id_emp");  start=rs.getDate("date_start");  end=rs.getDate("date_end");
			}
			
			u = s.executeUpdate("INSERT into disprovedallowences(allow_id,id_emp,date_start,date_end)"
		            +"values('"+id+"','"+idEmp+"','"+start+"','"+end+"')");
		 u = s.executeUpdate("DELETE from pendingallowences where allow_id='"+id+"' " );
		
		 
		 
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}

public static void addMessageDB (Msg msg) {
		
		Connection con = null;
		PreparedStatement ps = null;
		Statement s = null;

		try {
			con = DataConnect.getConnection();
			
			 s = con.createStatement();

			int u = s.executeUpdate("INSERT into posts(post,id_emp)"
		            +"values('"+msg.getMsg()+"','"+2+"')");


			
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
		} finally {
			DataConnect.close(con);
		}
	}

public static  void deleteMessage(int id)  {
	Connection con = null;
	PreparedStatement ps = null;
	
	int u;
	
	try{
		con = DataConnect.getConnection();
		Statement s = con.createStatement();
		// 3. Execute SQL query
		 u = s.executeUpdate("DELETE from posts where id='"+id+"' " );
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}

public static ArrayList<Employee> getEmployees() {
	
	ArrayList<Employee> employees=new ArrayList();
	Connection con = null;
	PreparedStatement ps = null;

	try {
		con = DataConnect.getConnection();
		ps = con.prepareStatement("Select * from employee ");
		

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			//result found, means valid inputs
			String name=rs.getString("name"); int i=rs.getInt("id_emp");
			employees.add(new Employee(name,i));
			
		}
	} catch (SQLException ex) {
		System.out.println("Login error -->" + ex.getMessage());
	} finally {
		DataConnect.close(con);
	}
	return employees;
}

public static ArrayList<Shift> getShifts() {
	
	ArrayList<Shift> shifts=new ArrayList();
	Connection con = null;
	PreparedStatement ps = null;

	try {
		con = DataConnect.getConnection();
		ps = con.prepareStatement("Select * from shift ");
		

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			//result found, means valid inputs
	 int i=rs.getInt("shift_id"); Time start=rs.getTime("start_time"); Time end=rs.getTime("end_time");
			shifts.add(new Shift(i,start,end));
			
		}
	} catch (SQLException ex) {
		System.out.println("Login error -->" + ex.getMessage());
	} finally {
		DataConnect.close(con);
	}
	return shifts;
}

//assign schedule to employee

public static void assign(int id)
{
	Connection con = null;
	PreparedStatement ps = null;
	Statement s = null;

	try {
		con = DataConnect.getConnection();
		
		 s = con.createStatement();

		int u = s.executeUpdate("INSERT into test(id)"
	            +"values('"+id+"')");


		
	} catch (SQLException ex) {
		System.out.println("Login error -->" + ex.getMessage());
	} finally {
		DataConnect.close(con);
	}
}

/*public static void assignSchedule (int i,int iSh,Days d) {
	
	Connection con = null;
	PreparedStatement ps = null;
	Statement s = null;

	try {
		con = DataConnect.getConnection();
		
		 s = con.createStatement();

		int u = s.executeUpdate("INSERT into dateshift(date,shift_id)"
	            +"values('"+d.getFrom()+"','"+iSh+"')");
		
ps = con.prepareStatement("Select * from dateshift ");
		

		ResultSet rs = ps.executeQuery();
int id=0;
		while (rs.next()) {
			//result found, means valid inputs
	  id =rs.getInt("dateShift_id");}

		 u = s.executeUpdate("INSERT into emp_dateshift(id_emp,dateShift_id)"
	            +"values('"+i+"','"+id+"')");

		
	} catch (SQLException ex) {
		System.out.println("Login error -->" + ex.getMessage());
	} finally {
		DataConnect.close(con);
	}
}*/
	
/*
	public static void main(String args[]) throws Exception
	{
		
      LoginDAO.assign(1, 1, 1, 1, 1);
		
	}*/
	}
	
	


