package ManagedBeans;

import java.util.Date;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Allowences {

	private int id;
	private int id_emp;
	private Date start,end;
	private String name;
	
	
	public Allowences()
	{
		
	}
	
	public Allowences(int id,int id_emp,Date start,Date end,String name)
	{
		this.id=id;
		this.id_emp=id_emp;
		this.start=start;
		this.end=end;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	
	
}
