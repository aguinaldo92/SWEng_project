package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Categories extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5326646070196603226L;
	private SessionMap<String, Object> userSession;
	private ArrayList<Category> categories;
	private ArrayList<String> categoryNames;
	// contiene i brands di una categoria (viene sovrascritto ad ogni ciclo dell'iterator)
	private ArrayList<String> brandsPerCategory;
	// contiene tutti i brands divisi per categoria
	private LinkedHashMap<String, ArrayList<String>> brandsPerCategories;


	public String execute() {
		if (!userSession.containsKey("categories")) { 	
			try {
				/**
				 * Ottengo una lista (arraylist) di categorie ordinate in modo ascendente 
				 */
				categories = (ArrayList<Category>)FactoryDao.getIstance().getCategoryDao().getAllSorted(Category.class);
				System.out.println("categories ottenute");
				categories.removeIf(e -> e.getName() == null);
				Iterator categoriesIterator = categories.iterator();
				//salvo le categorie nella sessione
				
				// creo un hashmap per salvare una lista di brand associata ad ogni categoria
				brandsPerCategories = new LinkedHashMap<String, ArrayList<String>>();
				System.out.println("iterator ottenuto");
				// fintanto che esiste una nuova categoria da popolare con i rispettivi brands..
				while(categoriesIterator.hasNext()) {
					Category currentCategory = (Category) categoriesIterator.next();
					// aggiungo il nome della categoria alla lista di nomi che andrà a finire nella sessione
					categoryNames.add(currentCategory.getName());
					// ottengo la lista di brands distinti dei vari tipi di prodotto della categoria oggetto della corrente iterazione
					brandsPerCategory = (ArrayList<String>)FactoryDao.getIstance().getTypeOfProductDao().getBrandsByCategory(currentCategory);
					// salvo il nome della categoria come chiave e la lista dei ripettivi brands come valore
					
					brandsPerCategories.put(currentCategory.getName(), brandsPerCategory);
					// da qui in poi è solo codice di debug che si può rimuovere fino a userSession.put(etc,..)
					Iterator productsIterator = brandsPerCategory.iterator();
					int index = 0;
					while(productsIterator.hasNext()) {

						System.out.println("elemento all'index "+ index + " brand = " + brandsPerCategories.get(currentCategory.getName()).get(index));
						productsIterator.next();
						index++;
					}
					System.out.println("categoria " + currentCategory.getName());

				}
				// salvo i nomi delle categorie
				userSession.put("categoryNames", categoryNames);
				userSession.put("categories", categories);
				// salvo i nomi dei brands per categoria
				userSession.put("brandsPerCategories", brandsPerCategories);

			} catch (Exception e) {
				System.out.println("message  " + e.getLocalizedMessage());
				System.out.println("cause  " + e.getCause());
				System.out.println("cause  " + e.getStackTrace());
			}
		}
		// non eseguo alcuna operazione alla fine della action (non devo caricare alcuna pagina o tiles in caso di successo)
		return ActionSupport.NONE;
	}

	






	public ArrayList<Category> getCategories() {
		return categories;
	}



	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}



	public ArrayList<String> getBrandsPerCategory() {
		return brandsPerCategory;
	}





	public void setBrandsPerCategory(ArrayList<String> brandsPerCategory) {
		this.brandsPerCategory = brandsPerCategory;
	}




	public LinkedHashMap<String, ArrayList<String>> getBrandsPerCategories() {
		return brandsPerCategories;
	}




	public void setBrandsPerCategories(
			LinkedHashMap<String, ArrayList<String>> brandsPerCategories) {
		this.brandsPerCategories = brandsPerCategories;
	}





	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap<String,Object>)map;

	}

}
