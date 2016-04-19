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
 * è necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class UpdateUser extends ActionSupport implements ModelDriven<UserModel>, SessionAware{
		
	private UserModel userForm = new UserModel();
    private SessionMap<String, Object> userSession;
	
	public String execute() {
		
		User newuser = (User) userSession.get("user");
		System.out.println("Sono entrato nella action UpdateUser - method updateProfile");
				
		newuser.setSsn(userForm.getSsn());
		newuser.setName(userForm.getName());
		newuser.setSurname(userForm.getSurname());
		newuser.setDateOfBirth(userForm.getDateOfBirth());
		newuser.setGender(userForm.getGender());
		newuser.setEmail(userForm.getEmail());
		newuser.setTelephone(userForm.getTelephone());
		newuser.setCellular(userForm.getCellular());
			
		//aggiorno lo user nel DB
		FactoryDao.getIstance().getUserDao().update(newuser);
		System.out.println("Aggiornato lo user nel DB. ID USER="+newuser.getId());
		
		//aggiorno lo user nella sessione
		userSession.replace("user", newuser);		
		System.out.println("Aggiornato lo user nella sessione");
		
		return SUCCESS;
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