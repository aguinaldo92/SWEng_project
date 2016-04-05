package it.unisalento.SWEng_project.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unisalento.SWEng_project.dao.UserDao;
import it.unisalento.SWEng_project.domain.Location;
import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	
	 @Override
	    public User getUserByCredentials(String username, String password) {
	        Session session = sf.openSession();
	        Transaction tx = session.beginTransaction();
	        Query query = session.createQuery("from User where username=:username and password=:password");
	        query.setString("username", username); 
	        query.setString("password", password);
	        User user = (User) query.uniqueResult();
	        if(user != null){
	            System.out.println("User Retrieved from DB::"+user);
	        } else {
	        	System.out.println("User non esistente");
	        }
	        tx.commit();
	        session.close();
	        return user;
	 }
	 
	 @Override
	 public Boolean LocationExists(User user, String location_name){
		Boolean loc_exists=false;
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Location where user_ID=:ID_user and name=:loc_name");
        query.setInteger("ID_user", user.getId()); 
        query.setString("loc_name", location_name);
        Location location = (Location) query.uniqueResult();
        if(location != null){
            loc_exists=true;
        }
        tx.commit();
        session.close();
        return loc_exists;
	 }
}
