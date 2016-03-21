package it.unisalento.SWEng_project.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import it.unisalento.SWEng_project.dao.UserDao;
import it.unisalento.SWEng_project.dao.impl.UserDaoImpl;
import it.unisalento.SWEng_project.models.UserModel;
import it.unisalento.SWEng_project.domain.*;
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
public class AddUser extends ActionSupport implements ModelDriven<UserModel>, ServletContextAware, SessionAware{
	
	/***
	 * Dichiarare delle proprietà il cui nome corrisponde a quello specificato nel nome
	 * CREA IL GETTER E IL SETTER
	 */
	
	private UserModel userForm = new UserModel();
    private ServletContext ctx;
    private SessionMap<String, Object> userSession ;
    
	
	
	/* E' necessario implementare il metodo execute() 
	 * Deve ritornare una stringa che rappresenta il nostro "result"
	 * 
	 * */
	public String execute () {
		System.out.println("Sono entrato nella action");
		System.out.println("Nome inserito: "+userForm.getName());
		
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		
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
		user.setTelephone(userForm.getTel());
		user.setCellular(userForm.getCell());
		user.setSeller(userForm.getSeller());
		user.setVatNumber(userForm.getVAT_number());
		
		Set<Location> user_location = new HashSet<Location>();
		LocationId locationID = new LocationId();
		
		locationID.setName("Residenza");
		
		Location location = new Location();
		
		location.setAddress(userForm.getAddress());
		location.setCap(userForm.getCap());
		location.setCity(userForm.getCity());
		location.setNumber(userForm.getNumber());
		location.setProvince(userForm.getProvince());
		location.setState(userForm.getState());
		location.setUser(user);
		
		user_location.add(location);
		user.setLocations(user_location);
		
		int iduser=FactoryDao.getIstance().getUserDao(sf).set(user);
		
		locationID.setUserId(iduser);
		location.setId(locationID);
		int iduser_loc=FactoryDao.getIstance().getLocationDao().set(location);
		
		System.out.println("ID USER="+iduser);
		System.out.println("ID USER IN LOCATION="+iduser_loc);
				
		return "success";
	}
	
	// Se sono presenti errori viene ritornato result = "input";
	public void validate() {
		boolean errors = false;
		
		if (userForm.getDateOfBirth().before(Date.from(LocalDateTime.now().minusYears(18).atZone(ZoneId.systemDefault()).toInstant()))
				&& userForm.getDateOfBirth().after(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))) {
			addFieldError("dateOfBirth", "Devi essere maggiorenne");
			errors = true;
		}
		if (userForm.getDateOfBirth().before(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))) {
			addFieldError("dateOfBirth", "Data di nascita non accettata");
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
	public void setServletContext(ServletContext sc) {
		 this.ctx = sc;
		
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap)map;
		
	}	
}
