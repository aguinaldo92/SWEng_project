package it.unisalento.SWEng_project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.SWEng_project.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Override
	public int set(T entity) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int id = (int) session.save(entity);
		tx.commit();
		HibernateUtil.closeSession(session);
		return id;
	}


	@Override
	public T get(int id, Class clazz){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		T entity= (T)session.get(clazz, id);
		tx.commit();
		HibernateUtil.closeSession(session);
		return entity;
	}


	@Override
	public List<T> getAll(Class clazz) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<T> list= (List<T>)session.createQuery("from "+clazz.getName()).list();
		tx.commit();
		HibernateUtil.closeSession(session);
		return list;
	}

	

}