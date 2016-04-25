package it.unisalento.SWEng_project.actions.json;

import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class Models extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1869214621597576197L;
	private String categoryName;
	private String brandName;
	private ArrayList<String> modelNames = new ArrayList<String>();
	
	// faccio in modo da mostrare i modelli o aggiungerli
	public String execute() {
        System.out.println("Models.execute()");
		try {
			modelNames = (ArrayList<String>) FactoryDao.getIstance().getTypeOfProductDao().getModelsByCategoryAndBrand(categoryName, brandName);
		} catch (Exception e){
			System.out.println("AddProduct.addModel()");
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


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public ArrayList<String> getModelNames() {
		return modelNames;
	}

	public void setModelNames(ArrayList<String> modelNames) {
		this.modelNames = modelNames;
	}
	
	
	
}
