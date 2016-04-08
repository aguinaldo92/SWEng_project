package it.unisalento.SWEng_project.actions;

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
	
	public String execute () throws Exception {
		
		System.out.println("Sono entrato nella action");
		Location location=new Location();
		User user=(User)userSession.get("user");
		
		
		if(!(FactoryDao.getIstance().getUserDao().LocationExists(user, locationForm.getName()))){
			location.setName(locationForm.getName());
			location.setAddress(locationForm.getAddress());
			location.setCap(locationForm.getCap());
			location.setCity(locationForm.getCity());
			location.setNumber(locationForm.getNumber());
			location.setProvince(locationForm.getProvince());
			location.setState(locationForm.getState());
			location.setUser(user);
		}
		
		return SUCCESS;
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
	
}