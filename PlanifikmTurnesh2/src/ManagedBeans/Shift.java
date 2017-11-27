package ManagedBeans;
import java.sql.Time;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="shift")
@SessionScoped
public class Shift {

	private Time start,end;
	private int id;
	
	public Shift()
	{
		
	}
	
	public Shift(int id,Time start,Time end)
	{
		
		this.id=id;
		this.start=start;
		this.end=end;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}

