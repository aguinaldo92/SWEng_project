package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;


public class Login extends ActionSupport implements ModelDriven<User>, SessionAware, ParameterNameAware  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private SessionMap<String, Object> userSession ;
	
	private String username;
	private String password;
	


	@Override
	public User getModel() {
		return user;
	}

	public String execute() {

		System.out.println("Sono entrato nella action Login");
		userSession.put("login", true);
		userSession.put("username",(String)user.getUsername());
		System.out.println(userSession.get("username"));
		System.out.println(userSession.get("login"));
		System.out.println("success final");
		return SUCCESS;
	}

	public void validate() {
		boolean errors = false;
		
		try {	 
			FactoryDao.getIstance().getUserDao().getUserByCredentials(user.getUsername(), user.getPassword()).getUsername();
			System.out.println(" login fatto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (NullPointerException enull){
			System.out.println("Utente non presente nel Database");
			errors = true;

		} catch (Exception egeneric) {
			System.out.println("errore generico" + egeneric.getMessage());
			errors = true;
		}	

		if (errors) {
			addActionError("Username or Password errati");
		}
	}

	public String logout(){  
		userSession.invalidate();  
		return SUCCESS;  
	}  

	@Override
	public void setSession(Map<String,Object> map) {  		 
		this.userSession = (SessionMap<String,Object>)map;

	}  

	@Override
	public boolean acceptableParameterName(String parameterName) {

		boolean allowedParameterName = true ;

		if ( parameterName.contains("session")  || parameterName.contains("request") ) {

			allowedParameterName = false ;

		} 

		return allowedParameterName;
	}
	
	public String getUsername() {
		return username;
	}

	@RequiredStringValidator(message = "Please enter your username.")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	@RequiredStringValidator(message = "Please enter your password.")
	public void setPassword(String password) {
		this.password = password;
	}


}
