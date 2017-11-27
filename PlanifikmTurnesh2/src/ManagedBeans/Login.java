package ManagedBeans;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import ServicesDB.AuthorizationFilter;
import ServicesDB.DataConnect;
import ServicesDB.LoginDAO;
import ServicesDB.SessionUtils;

//import com.journaldev.jsf.dao.LoginDAO;
//import com.journaldev.jsf.util.SessionUtils;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "index";
		} else {
			/*FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));*/
			
			return "login";
		}
	}

	/*public void validateLogin(FacesContext context,UIComponent component,Object value) throws ValidatorException
	{
		if(value==null)
		{
			return;
		}
		
		String data=value.toString();
		if(!data.equals("adam"))
		{
			FacesMessage message=new FacesMessage("Vendosni username dhe paswordin e sakte!");
			throw new ValidatorException(message); 
		}
	}*/
	
	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}