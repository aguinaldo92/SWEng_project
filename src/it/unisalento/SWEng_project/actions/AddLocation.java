package it.unisalento.SWEng_project.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.LocationModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddLocation extends ActionSupport implements ModelDriven<LocationModel>, SessionAware{
	
	private LocationModel locationForm = new LocationModel();
    private SessionMap<String, Object> userSession;
    private List<Location> other_locations = new ArrayList<Location>();
	private Location residence;
	
	public String execute () throws Exception {
		
		System.out.println("Sono entrato nella action AddLocation");
		
		Location location=new Location();
		User user=(User)userSession.get("user");
		
		location.setName(locationForm.getName());
		location.setAddress(locationForm.getAddress());
		location.setCap(locationForm.getCap());
		location.setCity(locationForm.getCity());
		location.setNumber(locationForm.getNumber());
		location.setProvince(locationForm.getProvince());
		location.setState(locationForm.getState());
		location.setUser(user);
		
		//inserisco l'indirizzo nel DB
		location.setId(FactoryDao.getIstance().getLocationDao().set(location));
		
		return SUCCESS;
	}
	
	public void validate(){
		
		User user=(User)userSession.get("user");
		boolean errors=false;
		Location original_location=FactoryDao.getIstance().getLocationDao().getLocationByName(user, locationForm.getName());
		
		if(original_location != null){
			addFieldError("name", "L'indirizzo associato a "+locationForm.getName()+" esiste già");
			errors = true;
		}
		if (errors) {
			addActionError("Sono presenti errori nel form");
		}	
	}

	@Override
	public LocationModel getModel() {
		// TODO Auto-generated method stub
		return locationForm;
	}


	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap) map;
	}

	public List<Location> getOther_locations() {
		return other_locations;
	}

	public void setOther_locations(List<Location> other_locations) {
		this.other_locations = other_locations;
	}

	public Location getResidence() {
		return residence;
	}

	public void setResidence(Location residence) {
		this.residence = residence;
	}	
	
}