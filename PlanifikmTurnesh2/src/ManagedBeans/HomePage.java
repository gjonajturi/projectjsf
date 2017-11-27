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

@ManagedBean(name="newHomePage")
@SessionScoped
public class HomePage implements Serializable {

	private static final long serialVersionUID = 1094801825228386362L;
	
	private ArrayList<Msg> posts=new ArrayList();
	private ArrayList<Allowences> allowences=new ArrayList();

	//private String newMessage;
	//private int id;

	public  HomePage()
	{
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
	public ArrayList<Msg> getPosts() {
		return posts;
	}
	
	public ArrayList<Allowences> getAllowences() {
		return allowences;
	}
	
	
	
	public void loadPosts()
	{
	
		try
		{
			posts=LoginDAO.getPosts();
		}
		catch(Exception e)
		{}	}
	
	//load lejet
	
	public void loadAllowences()
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
	
	}
	
	

	
	
