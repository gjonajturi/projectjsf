package ManagedBeans;
import java.util.Date;
import java.sql.Time;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ServicesDB.LoginDAO;

@ManagedBean(name="dates")
@SessionScoped
public class Dates {

	private int[] day=new int[31];
	private int [] month=new int[12];
	private int[] year=new int[5];
	private String str;
	
	
	public Dates()
	{
		for(int i=0;i<31;i++)
		{
			day[i]=i+1;
		}
		for(int j=0;j<12;j++)
		{
			month[j]=j+1;
		}for(int k=0;k<5;k++)
		{
			year[k]=k+2016;
		}
	}

	public int[] getDay() {
		return day;
	}

	public void setDay(int[] day) {
		this.day = day;
	}

	public int[] getMonth() {
		return month;
	}

	public void setMonth(int[] month) {
		this.month = month;
	}

	public int[] getYear() {
		return year;
	}

	public void setYear(int[] year) {
		this.year = year;
	}
	
	public String getStr()
	{
		return str;
	}
	
	public void setStr(String str)
	{
		this.str=str;
	}
	
	

	

	

	

	

	
	
}

