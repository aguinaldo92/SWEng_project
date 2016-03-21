package it.unisalento.SWEng_project.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.SWEng_project.dao.LocationDao;
import it.unisalento.SWEng_project.domain.Location;


public class LocationDaoImpl implements LocationDao {
	
	public int set(Location location) {
		// Tramite l'oggetto session è possibile eseguire le operazioni sul db come insert delete etc
		HibernateUtil hb = new HibernateUtil();
		Session session = hb.sessionFactory.openSession();
		// TUTTE LE OPERAZINIONI SUL DB DEVONO ESSERE CONTENUTE ALL'INTERNDO DI UNA TRANSAZIONE
		Transaction tx = session.beginTransaction();
		session.save(location);
		//FINE TRANSAZIONE
		tx.commit();
		session.close();
		
		return location.getId().getUserId();
	}

}
