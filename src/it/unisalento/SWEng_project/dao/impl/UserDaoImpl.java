package it.unisalento.SWEng_project.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.SWEng_project.dao.UserDao;
import it.unisalento.SWEng_project.domain.User;


public class UserDaoImpl implements UserDao {
	
	public int set(User user) {
		// Tramite l'oggetto session è possibile eseguire le operazioni sul db come insert delete etc
		HibernateUtil hb = new HibernateUtil();
		Session session = hb.sessionFactory.openSession();
		// TUTTE LE OPERAZINIONI SUL DB DEVONO ESSERE CONTENUTE ALL'INTERNDO DI UNA TRANSAZIONE
		Transaction tx = session.beginTransaction();
		session.save(user);
		//FINE TRANSAZIONE
		tx.commit();
		return user.getId();
	}

}
