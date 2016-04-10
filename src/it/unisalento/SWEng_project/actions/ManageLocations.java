package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Location;
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

public class ManageLocations extends ActionSupport implements ModelDriven<LocationModel>, SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationModel locationForm = new LocationModel();
	private List<Location> other_locations = new ArrayList<Location>();
	private Location residence;
    private SessionMap<String, Object> userSession;
	private int idlocation;
	private String submit_name;
	
	public void validate(){
		
		User user=(User)userSession.get("user");
		
		ListLocations listlocat = new ListLocations();
		//ottengo le informazioni relative a other_locations e recidence
		listlocat.set_locations(user);
		other_locations=listlocat.getOther_locations();
		residence=listlocat.getResidence();
		
		if("Aggiungi indirizzo".equals(submit_name) || "Aggiorna indirizzo".equals(submit_name)){
			Location original_location=FactoryDao.getIstance().getLocationDao().getLocationByName(user, locationForm.getName());
			
			if(original_location != null && idlocation != original_location.getId()){
				addActionError("L'indirizzo associato a "+locationForm.getName()+" esiste già.");
			}
		}
	}
    
    public String addLocation(){
    	System.out.println("Sono entrato nel metodo addLocation della action ListLocations");
    	
		User user=(User)userSession.get("user");
    	
		Location location=new Location();
		
		location.setName(locationForm.getName());
		location.setAddress(locationForm.getAddress());
		location.setCap(locationForm.getCap());
		location.setCity(locationForm.getCity());
		location.setNumber(locationForm.getNumber());
		location.setProvince(locationForm.getProvince());
		location.setState(locationForm.getState());
		location.setUser(user);
		
		//inserisco l'indirizzo nel DB
		try {
			location.setId(FactoryDao.getIstance().getLocationDao().set(location));
		} catch (SQLException e) {
			System.out.println("Errore: "+e.getMessage());
		}
		
		return SUCCESS;
    }
    
    public String updateLocation(){
    	
    	User user_loggato = (User) userSession.get("user");
		System.out.println("Sono entrato nel metodo updateLocation della action ListLocations");
		
		Location newlocation = new Location();

		newlocation.setId(idlocation);
		newlocation.setName(locationForm.getName());
		newlocation.setAddress(locationForm.getAddress());
		newlocation.setNumber(locationForm.getNumber());
		newlocation.setCap(locationForm.getCap());
		newlocation.setCity(locationForm.getCity());
		newlocation.setProvince(locationForm.getProvince());
		newlocation.setState(locationForm.getState());
		newlocation.setUser(user_loggato);
		
		//aggiorno lo user nel DB
		FactoryDao.getIstance().getLocationDao().update(newlocation);
		System.out.println("Aggiornato l'indirizzo "+newlocation.getName()+" nel DB. ID LOCATION="+newlocation.getId());
				
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

	public String getSubmit_name() {
		return submit_name;
	}


	public void setSubmit_name(String submit_name) {
		this.submit_name = submit_name;
	}

	public int getIdlocation() {
		return idlocation;
	}

	public void setIdlocation(int idlocation) {
		this.idlocation = idlocation;
	}
}