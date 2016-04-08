package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.UserModel;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * è necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class AddUser extends ActionSupport implements ModelDriven<UserModel>, SessionAware{
	
	/***
	 * Dichiarare delle proprietà il cui nome corrisponde a quello specificato nel nome
	 * CREA IL GETTER E IL SETTER
	 */
	
	private UserModel userForm = new UserModel();
    private SessionMap<String, Object> userSession;
    
	public String execute () {
		boolean error=false;
		
		System.out.println("Sono entrato nella action");
		System.out.println("Nome inserito: "+userForm.getName());
		System.out.println("Password: "+userForm.getPassword());
		
		User user = new User();
		Date datenow = new Date();
		
		user.setSsn(userForm.getSsn());
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setCreateTime(datenow);
		user.setName(userForm.getName());
		user.setSurname(userForm.getSurname());
		user.setDateOfBirth(userForm.getDateOfBirth());
		user.setGender(userForm.getGender());
		user.setEmail(userForm.getEmail());
		user.setTelephone(userForm.getTelephone());
		user.setCellular(userForm.getCellular());
		try{
			user.setId(FactoryDao.getIstance().getUserDao().set(user));
		}catch(Exception  e){
			System.out.println("Errore nell'inserimento del nuovo utente: "+e.getMessage());
			error=true;
		}
		
		if(!error){		
			System.out.println("ID USER="+user.getId());
		}else{
			addFieldError("username", "Username non disponibile");
			return INPUT;
		}
				
		return SUCCESS;
	}
	
	public void validate() {
		
		boolean errors = false;
		
		if (!userForm.getPassword().equals(userForm.getConfirm_password())){
			addFieldError("confirm_password", "La password confermata � scorretta");
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
}
