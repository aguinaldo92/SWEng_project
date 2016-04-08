package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.UserModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;


public class Login extends ActionSupport implements ModelDriven<UserModel>, SessionAware, ParameterNameAware  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserModel userLogin = new UserModel();
	private User user= new User();
	private SessionMap<String, Object> userSession ;
	
	private String username;
	private String password;
	
	@Override
	public UserModel getModel() {
		return userLogin;
	}

	public String execute() {

		System.out.println("Sono entrato nella action Login");
		userSession.put("user", user);
		System.out.println("username: "+user.getUsername());
		System.out.println("login: "+userSession.get("login"));
		System.out.println("role: "+user.getRole());
		System.out.println("success final");
		return SUCCESS;
	}

	public void validate() {
		boolean errors = false;
		
		if (!(userSession.containsKey("login"))){//controllo se la userSession è stata impostata
			try {	 
				//ottengo anagrafica e indirizzi salvati dallo user loggato
				user=FactoryDao.getIstance().getUserDao().getUserByCredentials(userLogin.getUsername(), userLogin.getPassword());
				System.out.println(" login fatto!!!");
			} catch (NullPointerException enull){
				System.out.println("Utente non presente nel Database");
				errors = true;
	
			} catch (Exception egeneric) {
				System.out.println("errore generico" + egeneric.getMessage());
				errors = true;
			}	
	
			if (errors) {
				addActionError("Username o Password errati");
			}
		}
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

	@RequiredStringValidator(message = "Username richiesto")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	@RequiredStringValidator(message = "Password richiesta")
	public void setPassword(String password) {
		this.password = password;
	}


}
