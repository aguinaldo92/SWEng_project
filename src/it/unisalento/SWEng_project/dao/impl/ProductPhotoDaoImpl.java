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
	public ArrayList<ProductPhotoDTO> getAllPhotosByIdProduct(Integer id) {
		
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select f from TypeOfProduct t inner join t.products  p inner join p.productPhotos f where t.id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);
        ArrayList<ProductPhotoDTO> photos = (ArrayList<ProductPhotoDTO>) query.list();
        tx.commit();
        session.close();
        return photos;
       
	}

	@Override
	public ProductPhotoDTO getPhotoByIdProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
