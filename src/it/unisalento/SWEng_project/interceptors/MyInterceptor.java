package it.unisalento.SWEng_project.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {
	
	String parametro;
	
	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("CODICE DA ESEGUIRE PRIMA DELLA INVOCAZIONE DELLA ACTION "+parametro);
		
		String result = action.invoke();
		
		System.out.println("CODICE CHE VIENE ESEGUITO DOPO L'INVOCAZIONE DELLA ACTION"+parametro);
		
		return result;
	}

}
