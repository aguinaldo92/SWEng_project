package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ResidenceModel;
import it.unisalento.SWEng_project.models.UserModel;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * Ã¨ necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class UpdatePassword extends ActionSupport implements SessionAware{
	
	private String old_password, confirm_password, password;
	
    private SessionMap<String, Object> userSession;
    
	
	public void validate() {
		User user_loggato = (User) userSession.get("user");
		boolean errors = false;
	 System.out.println("1");
		if (!password.equals(confirm_password)){
			 System.out.println("2");
			addFieldError("confirm_password", "La password confermata non è corretta");
			errors = true;
		}
		if(!old_password.equals(user_loggato.getPassword())){
			 System.out.println("3");
			addFieldError("old_password", "La password non è corretta");
			errors = true;
		}
		 System.out.println("4");
		if (errors) {
			 System.out.println("5");
			addActionError("Sono presenti errori all'interno del form");
		}
	}
    
	public String execute(){
		
		User newuser = (User) userSession.get("user");
		System.out.println("Sono entrato nella action UpdateUser - method updatePassword");
		
		newuser.setPassword(password);
		
		//aggiorno lo user nel DB
		FactoryDao.getIstance().getUserDao().update(newuser);
		System.out.println("Aggiornato lo user nel DB. ID USER="+newuser.getId());
		
		//aggiorno lo user nella sessione
		userSession.replace("user", newuser);		
		System.out.println("Aggiornato lo user nella sessione");
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap) map;
		
	}

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
