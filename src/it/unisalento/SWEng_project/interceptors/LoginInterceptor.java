package it.unisalento.SWEng_project.interceptors;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6805865333376694437L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		SessionMap<String, Object> userSession = (SessionMap<String, Object>)invocation.getInvocationContext().getSession();

        Boolean login = (Boolean) userSession.get("login");
		
		
		if (!login) 
        {
                return Action.LOGIN;
        } 
        else 
        {
                return invocation.invoke();
        }
        
        return null;
	}

}
