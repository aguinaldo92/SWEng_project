package it.unisalento.SWEng_project.dao.impl;

import it.unisalento.SWEng_project.dao.CategoryDao;
import it.unisalento.SWEng_project.domain.Category;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
	private Category category;
	private Session session;
	private Transaction tx;

	@Override
	public ArrayList<Category> getAllSorted(Class categoryClass) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		ArrayList<Category> sortedList = (ArrayList<Category>)session.createQuery("from Category c order by c.name asc").list();
		tx.commit();
		session.close();
		return sortedList;
	}

	@Override
	public Category getByName(String categoryName) {
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			String hql = "from Category c where c.name = :categoryName" ;
			Query query = session.createQuery(hql);
			query.setString("categoryName", categoryName);
			category = (Category) query.uniqueResult();
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("catch");
			if (tx != null) tx.rollback();
			throw e;
		}
		finally {
			System.out.println("finally");
			session.close();
		}
		return category;
	}


	// getall category è già presente in basedaoimpl, adesso devo testarlo in una pagina (meglio se una tile) con struts ed una action che usa quei dati

}

