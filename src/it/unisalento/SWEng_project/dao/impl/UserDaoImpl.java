package it.unisalento.SWEng_project.dao.impl;

import it.unisalento.SWEng_project.dao.UserDao;
import it.unisalento.SWEng_project.domain.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UserDaoImpl implements UserDao {
	
	private SessionFactory sf;
    
    public UserDaoImpl(SessionFactory sf){
        this.sf = sf;
    }
	
	public int set(User user) {
		// Tramite l'oggetto session è possibile eseguire le operazioni sul db come insert delete etc
		
		Session session = sf.openSession();
		// TUTTE LE OPERAZINIONI SUL DB DEVONO ESSERE CONTENUTE ALL'INTERNDO DI UNA TRANSAZIONE
		Transaction tx = session.beginTransaction();
		session.save(user);
		//FINE TRANSAZIONE
		tx.commit();
		return user.getId();
	}

	 @Override
	    public User getUserByCredentials(String email, String password) {
	        Session session = sf.openSession();
	        Transaction tx = session.beginTransaction();
	        Query query = session.createQuery("from User where username=:username and password=:password");
	        query.setString("email", email); 
	        query.setString("password", password);
	        User user = (User) query.uniqueResult();
	        if(user != null){
	            System.out.println("User Retrieved from DB::"+user);
	        }
	        tx.commit();
	        session.close();
	        return user;
	    }
	@Override
	public User get(int id, Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
