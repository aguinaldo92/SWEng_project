package it.unisalento.SWEng_project.dao.impl;

import it.unisalento.SWEng_project.dao.ProductPhotoDao;
import it.unisalento.SWEng_project.domain.ProductPhoto;
import it.unisalento.SWEng_project.dto.ProductPhotoDTO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductPhotoDaoImpl extends BaseDaoImpl<ProductPhoto> implements ProductPhotoDao{

	@Override
	public ArrayList<ProductPhoto> getAllPhotosByIdTypeOfProduct(Integer id) {
		
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select f from TypeOfProduct t inner join t.products  p inner join p.productPhotos f where t.id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);
        ArrayList<ProductPhoto> photos = (ArrayList<ProductPhoto>) query.list();
        tx.commit();
        session.close();
        return photos;
       
	}

	@Override
	public ProductPhoto getPhotoByIdTypeOfProduct(Integer id) {
		
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select f from TypeOfProduct t inner join t.products  p inner join p.productPhotos f where t.id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);
        ProductPhoto photo = (ProductPhoto) query.uniqueResult();
        tx.commit();
        session.close();
        return photo;
	}

}
