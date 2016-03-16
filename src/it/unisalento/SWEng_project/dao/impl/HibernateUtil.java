package it.unisalento.SWEng_project.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {
	
	SessionFactory sessionFactory;
	ServiceRegistry serviceRegistry;
	
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		serviceRegistry = serviceRegistryBuilder.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

}
