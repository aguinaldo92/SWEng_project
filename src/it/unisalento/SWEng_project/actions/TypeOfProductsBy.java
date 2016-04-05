package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.dto.TypeOfProductDTO;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TypeOfProductsBy extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<TypeOfProductDTO> typeOfProducts;
	private SessionMap<String, Object> userSession;
	private String categoryName;
	private String brand;

	public String execute() {
		System.out.println("Sono entrato nella action TypeOfProductsBy");

		// se nella sessione non sono presenti i prodotti divisi per categorie li devo ottenere

		try {
			typeOfProducts = new ArrayList<TypeOfProductDTO>();
			System.out.println("ArrayList ottenuto");

			if (this.brand == null) {
				typeOfProducts = (ArrayList<TypeOfProductDTO>)FactoryDao.getIstance().getTypeOfProductDao().getTypeOfProductsDTOByCategory(categoryName);
			} else {
				typeOfProducts  = (ArrayList<TypeOfProductDTO>)FactoryDao.getIstance().getTypeOfProductDao().getTypeOfProductsByCategoryAndBrand(categoryName, brand);
			}
			typeOfProducts.removeIf(e -> e.getModel() == null);
			//typeOfProducts.removeAll(Collections.singleton(null));
			// codice di debug
			Iterator<TypeOfProductDTO> typeOfProductsIterator = typeOfProducts.iterator();
			while(typeOfProductsIterator.hasNext()) {

				System.out.println(" modello " + typeOfProductsIterator.next().getModel());

			}
			System.out.println("categoria " + categoryName);
			// fine codice di debug

			userSession.put("typeOfProducts", typeOfProducts); 


		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}



		return SUCCESS;
	}






	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}




	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap<String, Object>) map;

	}

}
