package it.unisalento.SWEng_project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.SWEng_project.dao.CategoryDao;
import it.unisalento.SWEng_project.domain.Category;

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@Override
	public List<Category> getAllSorted(Class categoryClass) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Category> sortedList= (List<Category>)session.createQuery("from Category c order by c.name asc").list();
		tx.commit();
		session.close();
		return sortedList;
	}

	// getall category è già presente in basedaoimpl, adesso devo testarlo in una pagina (meglio se una tile) con struts ed una action che usa quei dati

}
