package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.dto.TypeOfProductDTO;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BestDeals extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2979810075973708785L;
	private ArrayList<TypeOfProductDTO> typeOfProducts;
	private SessionMap<String, Object> userSession;
	
	
	
	public String execute() {
		System.out.println("Sono entrato nella action TypeOfProductsBy");

		// se nella sessione non sono presenti i prodotti divisi per categorie li devo ottenere

		try {
			typeOfProducts = new ArrayList<TypeOfProductDTO>();
			System.out.println("ArrayList ottenuto");

			
				typeOfProducts  = (ArrayList<TypeOfProductDTO>)FactoryDao.getIstance().getTypeOfProductDao().getBestDeals();
			
			typeOfProducts.removeIf(e -> e.getModel() == null);
			// codice di debug
			Iterator<TypeOfProductDTO> typeOfProductsIterator = typeOfProducts.iterator();
			while(typeOfProductsIterator.hasNext()) {

				System.out.println(" modello " + typeOfProductsIterator.next().getModel());

			}
			// fine codice di debug

			userSession.put("typeOfProducts", typeOfProducts); 


		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

		return SUCCESS;
	}
	
	

	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap<String, Object>) map;
	}

}
