package it.unisalento.SWEng_project.actions;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport{
	
	private SessionMap<String, Object> userSession ;
	
	public String execute(){
		
		userSession=(SessionMap<String,Object>)ActionContext.getContext().getSession();
		
		userSession.invalidate();

		System.out.println("sessione invalidata");
		return SUCCESS;
	}
	
}