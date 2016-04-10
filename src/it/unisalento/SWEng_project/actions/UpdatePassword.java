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
	
	private String old_password, confirm_password, password, submit_name;
	
    private SessionMap<String, Object> userSession;
    
	
	public void validate() {

		User user_loggato = (User) userSession.get("user");
		boolean errors = false;
	
		if (!password.equals(confirm_password)){
			addFieldError("confirm_password", "La password confermata non è corretta");
			errors = true;
		}
		else if(!old_password.equals(user_loggato.getPassword())){
			addFieldError("old_password", "La password non è corretta");
			errors = true;
		}
		if (errors) {
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

	@RequiredStringValidator(message = "Vecchia password richiesta")
	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	@RequiredStringValidator(message = "Conferma della nuova password richiesta")
	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getSubmit_name() {
		return submit_name;
	}

	public void setSubmit_name(String submit_name) {
		this.submit_name = submit_name;
	}

	@RequiredStringValidator(message = "Nuova password richiesta")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
