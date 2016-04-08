package it.unisalento.SWEng_project.interceptors;

import it.unisalento.SWEng_project.domain.User;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6805865333376694437L;
	private SessionMap<String, Object> userSession;
	private  int role;
	private User user;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
			
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		userSession = (SessionMap<String, Object>)invocation.getInvocationContext().getSession();	
        try {
        	user = (User) userSession.get("user");
        	role = user.getRole();
        	if (role <= 2)
        		return invocation.invoke();
        	else
        		return "DENIED";
        } catch (NullPointerException nullException){
        	System.out.println("L'utente deve essere loggato per arrivare alla pagina ");
        	return Action.LOGIN;
        }

        
	}

}
