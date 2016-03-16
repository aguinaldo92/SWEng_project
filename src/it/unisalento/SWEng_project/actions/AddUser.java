package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.dao.UserDao;
import it.unisalento.SWEng_project.dao.impl.UserDaoImpl;
import it.unisalento.SWEng_project.models.StudentModel;
import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/***
 * 
 * Per sfruttare il meccaniscmo di validazione all'interno della Action
 * è necessario estendere la classe con ActionSupport (ovviamente dovete fare l'import!!!!)
 *
 *	Per sfuttare l'interceptor ModelDriven la action deve implementare l'interfaccia ModelDriven
 */
public class AddUser extends ActionSupport implements ModelDriven<User>{
	
	/***
	 * Dichiarare delle proprietà il cui nome corrisponde a quello specificato nel nome
	 * CREA IL GETTER E IL SETTER
	 */
	
	private User userForm = new User();
	
	
	/* E' necessario implementare il metodo execute() 
	 * Deve ritornare una stringa che rappresenta il nostro "result"
	 * 
	 * */
	public String execute () {
		System.out.println("Sono entrato nella action");
		System.out.println("Nome inserito:"+userForm.getName());
		//System.out.println("Et� inserita:"+studentModel.getAge());
		
		User user = new User();
		
		user.setSsn(userForm.getSsn());
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		user.setCreateTime(userForm.getCreateTime());
		user.setName(userForm.getName());
		user.setSurname(userForm.getSurname());
		user.setDateOfBirth(userForm.getDateOfBirth());
		
		
		FactoryDao.getIstance().getUserDao().set(user);
		
		
		return "success";
	}
	
	// Se sono presenti errori viene ritornato result = "input";
	public void validate() {
		boolean errors = false;
		if (userForm.getName().equals("")) {
			addFieldError("name", "Campo richiesto");
			errors = true;
		}
		if (errors) {
			addActionError("Sono presenti errori all'interno del form");
		}
		
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return userForm;
	}	
}
