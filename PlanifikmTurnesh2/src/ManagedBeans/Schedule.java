package ManagedBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import ServicesDB.AuthorizationFilter;
import ServicesDB.DataConnect;
import ServicesDB.LoginDAO;
import ServicesDB.SessionUtils;

@ManagedBean(name="schedule")
@SessionScoped
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private ArrayList<Employee> employees=new ArrayList();
	private ArrayList<Shift> shifts=new ArrayList();
	//private Dates dates;
	//private ArrayList<Allowences> allowences=new ArrayList();
	private String n;
	//private String newMessage;
	//private int id;

	public  Schedule()
	{
		//dates=new Dates();
	}
	
	/*public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		this.id=i;
	}
	
	public void setNewMessage(String m)
	{
		this.newMessage=m;
	}
	
	public String getNewMessage()
	{
		return newMessage;
	}
	*/
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	public ArrayList<Shift> getShifts()
	{
		return shifts;
	}
	
	//public Dates getDates()
	{
		
		//return dates;
	}
	
	public void loadShifts()
	{
	
		try
		{
			shifts=LoginDAO.getShifts();
		}
		catch(Exception e)
		{}	}
	
	
	public void loadEmployees()
	{
	
		try
		{
			employees=LoginDAO.getEmployees();
		}
		catch(Exception e)
		{}	}
	
	
	public void assign(int id)
	{
		LoginDAO.assign(id);
	}
	
	//load lejet
	 
	/*public void loadAllowences()
	{
	
		try
		{
			allowences=LoginDAO.getAllowences();
		}
		catch(Exception e)
		{}	}
	
	public void addMessage(Msg msg)
	{
		LoginDAO.addMessageDB(msg);
	}
	
	public void deleteMessage(int id) throws Exception
	{
		LoginDAO.deleteMessage(id);
	}
	
	public void aprove(int id) throws Exception
	{
		LoginDAO.aprove(id);
	}
	
	public void disprove(int id) throws Exception
	{
		LoginDAO.disprove(id);
	}
	*/
	}
	
	

	
	
