package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.LocationModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ListLocations extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Location> other_locations = new ArrayList<Location>();
	private Location residence;
    private SessionMap<String, Object> userSession;
	
	public String execute(){
		
		User user=(User)userSession.get("user");
		this.set_locations(user);

		return SUCCESS;
	}
	
	//metodo per impostare other_location e residence (viene richiamato anke da ManageLocations)
	public void set_locations(User user){
		
		this.other_locations=FactoryDao.getIstance().getLocationDao().getLocationsByUser(user);
		
		//metto da parte le info sulla residenza e le escludo dalla lsita "other_locations"
		for (int id=0; id<other_locations.size(); id++){
			if (other_locations.get(id).getName().equals("Residenza")){
				residence=other_locations.get(id);
				other_locations.remove(id);
			}
		}
		
		System.out.println("Caricata la lista delle locations. N° altri indirizzi: "+other_locations.size());
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap) map;
		
	}

	public Location getResidence() {
		return residence;
	}

	public void setResidence(Location residence) {
		this.residence = residence;
	}

	public List<Location> getOther_locations() {
		return other_locations;
	}

	public void setOther_locations(List<Location> other_locations) {
		this.other_locations = other_locations;
	}
}