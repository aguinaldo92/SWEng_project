package it.unisalento.SWEng_project.dao.impl;

import it.unisalento.SWEng_project.dao.BaseDao;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDaoImpl<T> implements BaseDao<T> {

	protected SessionFactory sf;
	private ServletContext ctx;

	public BaseDaoImpl() {
		 ctx = ServletActionContext.getServletContext(); 
		this.sf = (SessionFactory) ctx.getAttribute("SessionFactory");
	}

	@Override
	public int set(T entity) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int id = (int) session.save(entity);
		tx.commit();
		session.close();
		return id;
	}


	@Override
	public T get(int id, Class clazz){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		T entity= (T)session.get(clazz, id);
		tx.commit();
		session.close();
		return entity;
	}


	@Override
	public List<T> getAll(Class clazz) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<T> list= (List<T>)session.createQuery("from "+clazz.getName()).list();
		tx.commit();
		session.close();
		return list;
	}



}