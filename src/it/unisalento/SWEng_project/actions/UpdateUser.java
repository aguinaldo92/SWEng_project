package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.UserModel;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * √® necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class UpdateUser extends ActionSupport implements ModelDriven<UserModel>, SessionAware{
	
	/***
	 * Dichiarare delle propriet√† il cui nome corrisponde a quello specificato nel nome
	 * CREA IL GETTER E IL SETTER
	 */
	private String old_password="", confirm_password="";
	
	private UserModel userForm = new UserModel();
    private SessionMap<String, Object> userSession;
    
	public String execute () {
		
		User user_loggato = (User) userSession.get("user");
		System.out.println("Sono entrato nella action UpdateUser");
		
		User newuser = new User();
		
		if(old_password.length()>0){//sto modificando solo la password
			newuser.setId(user_loggato.getId());
			newuser.setSsn(user_loggato.getSsn());
			newuser.setCreateTime(user_loggato.getCreateTime());
			newuser.setUsername(user_loggato.getUsername());
			newuser.setName(user_loggato.getName());
			newuser.setSurname(user_loggato.getSurname());
			newuser.setDateOfBirth(user_loggato.getDateOfBirth());
			newuser.setGender(user_loggato.getGender());
			newuser.setEmail(user_loggato.getEmail());
			newuser.setTelephone(user_loggato.getTelephone());
			newuser.setCellular(user_loggato.getCellular());
			newuser.setRole(user_loggato.getRole());
			newuser.setPassword(userForm.getPassword());
		}
		else{//sto modificando l'anagrafica e/o i contatti
			newuser.setId(user_loggato.getId());
			newuser.setSsn(userForm.getSsn());
			newuser.setCreateTime(user_loggato.getCreateTime());
			newuser.setUsername(user_loggato.getUsername());
			newuser.setName(userForm.getName());
			newuser.setSurname(userForm.getSurname());
			newuser.setDateOfBirth(userForm.getDateOfBirth());
			newuser.setGender(userForm.getGender());
			newuser.setEmail(userForm.getEmail());
			newuser.setTelephone(userForm.getTelephone());
			newuser.setCellular(userForm.getCellular());
			newuser.setRole(user_loggato.getRole());
			newuser.setPassword(user_loggato.getPassword());
		}
		
		//aggiorno lo user nel DB
		FactoryDao.getIstance().getUserDao().update(newuser);
		System.out.println("Aggiornato lo user nel DB. ID USER="+newuser.getId());
		
		//aggiorno lo user nella sessione
		userSession.put("user", newuser);		
		System.out.println("Aggiornato lo user nella sessione");
		
		return SUCCESS;
	}
	
	public void validate() {
		
		User user_loggato = (User) userSession.get("user");
		boolean errors = false;
		
		if ((!userForm.getPassword().equals(confirm_password)) && old_password.length()>0){
			addFieldError("confirm_password", "La password confermata non Ë corretta");
			errors = true;
		}
		else if((!old_password.equals(user_loggato.getPassword())) && old_password.length()>0){
			addFieldError("old_password", "La password non Ë corretta");
			errors = true;
		}
		if (errors) {
			addActionError("Sono presenti errori all'interno del form");
		}
	}

	@Override
	public UserModel getModel() {
		// TODO Auto-generated method stub
		return userForm;
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
}
