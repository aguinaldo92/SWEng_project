package it.unisalento.SWEng_project.interceptors;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

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
		SessionMap<String, Object> userSession = (SessionMap)invocation.getInvocationContext().getSession();

        Boolean login = (Boolean) userSession.get("login");
        
        
	}

}
