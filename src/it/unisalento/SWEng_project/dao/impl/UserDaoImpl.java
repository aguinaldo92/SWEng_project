package it.unisalento.SWEng_project.dao.impl;

import it.unisalento.SWEng_project.dao.UserDao;
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
}
