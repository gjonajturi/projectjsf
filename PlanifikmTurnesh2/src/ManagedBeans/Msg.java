package ManagedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Msg {

	private int id;
	private String msg,name;
	
	public Msg()
	{
		
	}
	
	public Msg(int id,String msg,String name)
	{
		this.id=id;
		this.msg=msg;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String msg) {
		this.name=name;
	}
	
}
