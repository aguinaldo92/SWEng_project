package it.unisalento.SWEng_project.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unisalento.SWEng_project.dao.ShopDao;
import it.unisalento.SWEng_project.domain.Shop;
import it.unisalento.SWEng_project.domain.User;

public class ShopDaoImpl extends BaseDaoImpl<Shop> implements ShopDao {

	@Override
	    public List<Shop> getShopsByUser(User user){
		 	Session session = sf.openSession();
	        Transaction tx = session.beginTransaction();
	        Query query = session.createQuery("from Shop where seller_user_ID=:seller_ID");
	        query.setInteger("seller_ID", user.getId());
	        List<Shop> shops = (List<Shop>) query.list();
	        if(shops.isEmpty()){
	            System.out.println("L'utente non ha shops");
	        } else {
	        	System.out.println("L'utente ha "+shops.size()+" shop");
	        }
	        tx.commit();
	        session.close();
	        return shops;
	 }
}