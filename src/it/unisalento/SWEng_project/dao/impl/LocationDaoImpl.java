package it.unisalento.SWEng_project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.SWEng_project.dao.LocationDao;
import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.User;


public class LocationDaoImpl extends BaseDaoImpl<Location> implements LocationDao {
	
	@Override
	 public Location getLocationByName(User user, String location_name){
		Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       Query query = session.createQuery("from Location where user_ID=:ID_user and name=:loc_name");
       query.setInteger("ID_user", user.getId()); 
       query.setString("loc_name", location_name);
       Location location = (Location) query.uniqueResult();
       tx.commit();
       session.close();
       return location;
	 }
	 
	 @Override
	 public List<Location> getLocationsByUser(User user){
	 	Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       Query query = session.createQuery("from Location where user_ID=:user_ID");
       query.setInteger("user_ID", user.getId());
       List<Location> locations = (List<Location>) query.list();
       if(locations.isEmpty()){
           System.out.println("L'utente non ha indirizzi");
       } else {
       	System.out.println("L'utente ha "+locations.size()+" indirizzi salvati");
       }
       tx.commit();
       session.close();
       return locations;
	 }
	 
}
