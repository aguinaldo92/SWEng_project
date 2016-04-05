package it.unisalento.SWEng_project.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;

public interface UserDao extends BaseDao<User>{
	
	public User getUserByCredentials(String email, String password);
	
	public Boolean LocationExists(User user, String location_name);
}
