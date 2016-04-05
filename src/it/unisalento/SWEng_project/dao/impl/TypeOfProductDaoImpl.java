package it.unisalento.SWEng_project.dao.impl;

import it.unisalento.SWEng_project.dao.TypeOfProductDao;
import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.dto.TypeOfProductDTO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;

public class TypeOfProductDaoImpl extends BaseDaoImpl<TypeOfProduct> implements TypeOfProductDao {


 /**
  * Ottengo la lista di brands distinti per categoria
  * (da testare)
  */
	@Override
	public ArrayList<String> getBrandsByCategory(Category category) {
		ArrayList<String> brands = new ArrayList<String>();
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select distinct t.brand " + 
        		" from Category c inner join c.typeOfProducts  t  " + 
        		" where c.name = :category " + 
        		" order by t.brand asc";
        Query query = session.createQuery(hql);
        query.setString("category", category.getName());
        brands = (ArrayList<String>) query.list();
        tx.commit();
        session.close();
        return brands;
	}
	/**
	 * Quando clicco su un brand nella pagina jsp chiamo questo metodo dalla action interessata e passo com parametro il brand e la categoria
	 * (da testare)
	 */
	@Override
	public ArrayList<TypeOfProductDTO> getTypeOfProductsByCategoryAndBrand(String category, String brand) {
		
		ArrayList<TypeOfProductDTO> typeOfProductDTOs = new ArrayList<TypeOfProductDTO>();

		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select t.id as id, t.brand as brand, t.model as model , max(s.sellingDiscount) as maxSellingDiscount, min(s.sellingPrice - (s.sellingPrice * s.sellingDiscount)) as minPrice, sum(s.quantityAvailable) as quantityAvailable " + 
        		" from Category c inner join c.typeOfProducts t inner join t.products p inner join p.sellses s inner join s.shop sh inner join sh.user se " + 
        		" where c.name = :category and t.brand = :brand" + 
        		" group by t.model " +
        		" order by maxSellingDiscount desc";
        Query query = session.createQuery(hql);
        query.setString("category", category);
        query.setString("brand", brand);
        query.setResultTransformer(Transformers.aliasToBean(TypeOfProductDTO.class));
        typeOfProductDTOs = (ArrayList<TypeOfProductDTO>) query.list();
        tx.commit();
        session.close();
        return typeOfProductDTOs;
	}
	
	@Override
	public ArrayList<TypeOfProductDTO> getTypeOfProductsDTOByCategory(String category) {

		
		ArrayList<TypeOfProductDTO> typeOfProductDTOs = new ArrayList<TypeOfProductDTO>();
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
     // aggiungere le foto alla query dopo aver aggiornato il typeofproductDTO e decidere se mettere lo sconto
        // decdere benee quali operazioni fare sui campi aggregati
        String hql = "select t.id as id, t.brand as brand, t.model as model , max(s.sellingDiscount) as maxSellingDiscount, min(s.sellingPrice - (s.sellingPrice * s.sellingDiscount)) as minPrice, sum(s.quantityAvailable) as quantityAvailable " +
        		" from Category c inner join c.typeOfProducts t inner join t.products p inner join p.sellses s  inner join s.shop sh inner join sh.user se " + 
        		" where c.name = :category " + 
        		" group by t.model " +
        		" order by maxSellingDiscount desc"; 
        Query query = session.createQuery(hql);
        query.setString("category", category);
        query.setResultTransformer(new AliasToBeanResultTransformer(TypeOfProductDTO.class));
        typeOfProductDTOs = (ArrayList<TypeOfProductDTO>) query.list();
        tx.commit();
        session.close();
        return typeOfProductDTOs;
		
	}
	@Override
	public ArrayList<TypeOfProductDTO> getBestDeals() {
		
		ArrayList<TypeOfProductDTO> typeOfProductDTOs = new ArrayList<TypeOfProductDTO>();

		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "select t.id as id, t.brand as brand, t.model as model , max(s.sellingDiscount) as maxSellingDiscount, min(s.sellingPrice - (s.sellingPrice * s.sellingDiscount)) as minPrice, sum(s.quantityAvailable) as quantityAvailable " + 
        		" from Category c inner join c.typeOfProducts t inner join t.products p inner join p.sellses s " + 
        		" group by t.model " +
        		" order by maxSellingDiscount desc";
        Query query = session.createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(TypeOfProductDTO.class));
        typeOfProductDTOs = (ArrayList<TypeOfProductDTO>) query.list();
        tx.commit();
        session.close();
        return typeOfProductDTOs;
	}
	


}
