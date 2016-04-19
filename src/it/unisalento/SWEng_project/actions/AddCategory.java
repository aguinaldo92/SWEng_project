package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;
import java.util.Iterator;

import com.opensymphony.xwork2.ActionSupport;

public class AddCategory extends ActionSupport  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5562916080391996403L;
	private ArrayList<Category> categories;
	private ArrayList<String> categoryNames;
	private String categoryName;
	
	public String execute() {
		
		categoryNames = new ArrayList<String>();
		System.out.println("AddCategory.execute()");
			try {
				categories = (ArrayList<Category>)FactoryDao.getIstance().getCategoryDao().getAllSorted(Category.class);
				System.out.println("categories ottenute dall ajax");
				categories.removeIf(e -> e.getName() == null);
				Iterator categoriesIterator = categories.iterator();
				
				while(categoriesIterator.hasNext()) {
					Category currentCategory = (Category) categoriesIterator.next(); 
					System.out.println(currentCategory.getName());
					categoryNames.add(currentCategory.getName());
				} 
				
			} catch (Exception e){
				System.out.println("AddProduct.addCategory()");
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.getCause());
				System.out.println( e.getStackTrace());
			}
		return "success";
	}
	
	public String getJSON(){
		return execute();
	}

	


	public ArrayList<String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(ArrayList<String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
