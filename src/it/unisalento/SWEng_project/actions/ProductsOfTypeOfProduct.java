package it.unisalento.SWEng_project.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProductsOfTypeOfProduct extends ActionSupport implements SessionAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7407380899763767577L;
	private SessionMap<String, Object> userSession;
	private Integer id;


	
	public String execute() {
		System.out.println("sono dentro la action");
		System.out.println("id = " + id);
		
		return SUCCESS;
		
	}
	
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = 	(SessionMap<String, Object>) map;	
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
}
