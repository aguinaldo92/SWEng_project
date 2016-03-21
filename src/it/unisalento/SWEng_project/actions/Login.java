package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

public class Login extends ActionSupport implements ModelDriven<User>, SessionAware, ServletContextAware, ParameterNameAware  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
     private ServletContext ctx;
     private SessionMap<String, Object> userSession ;
	
     @Override
     public void setServletContext(ServletContext sc) {
         this.ctx = sc;
     }
     
     @Override
     public User getModel() {
         return user;
     }
     
	public String execute() throws Exception {
		System.out.println("Sono entrato nella action Login");
		 SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
				 
		  if(!FactoryDao.getIstance().getUserDao(sf).getUserByCredentials(user.getUsername(), user.getPassword()).equals(null)) {
			  System.out.println(" login fatto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			  userSession.put("login", true);
			  userSession.put("username",(String)user.getUsername());
		  }
		  
	
		
		return SUCCESS;
	}

	public String logout(){  
		 userSession.invalidate();  
	    return SUCCESS;  
	}  

	@Override
	public void setSession(Map<String,Object> map) {  		 
		this.userSession = (SessionMap)map;
		  
	}  

	@Override
	public boolean acceptableParameterName(String parameterName) {
	     
	    boolean allowedParameterName = true ;
	     
	    if ( parameterName.contains("session")  || parameterName.contains("request") ) {
	     
	        allowedParameterName = false ;
	         
	    } 
	     
	    return allowedParameterName;
	}
	
	
}
