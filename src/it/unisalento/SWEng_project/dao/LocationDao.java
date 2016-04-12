package it.unisalento.SWEng_project.dao;

import java.util.List;

import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.User;

public interface LocationDao extends BaseDao<Location>{
	

	public Location getLocationByName(User user, String location_name);
	
	public List<Location> getLocationsByUser(User user);
	
}