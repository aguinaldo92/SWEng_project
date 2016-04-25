package it.unisalento.SWEng_project.actions.json;

import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class Brands extends ActionSupport{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1807947495742624445L;
	private String categoryName;
	private ArrayList<String> brandNames = new ArrayList<String> ();


	public String execute() {
		// se la categoria come presa dalla jsp è presente nella lista delle categorie possibili uso getbrands by category dal daoimpl, altrimenti uso quanto già implementato
		System.out.println("Sono entrato nella AddProduct Categories metodo  AddBrand");
		try {
			
			brandNames = (ArrayList<String>) FactoryDao.getIstance().getTypeOfProductDao().getBrandsByCategory(categoryName);
			//userSession.put("brands",brands);


		} catch (Exception e){
			System.out.println("AddProduct.addBrand() exception");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println( e.getStackTrace());

		}
		return ActionSupport.SUCCESS;
	}

	public String getJSON()
	{
		return execute();
	}



	

	public ArrayList<String> getBrandNames() {
		return brandNames;
	}

	public void setBrandNames(ArrayList<String> brandNames) {
		this.brandNames = brandNames;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	
 

}
