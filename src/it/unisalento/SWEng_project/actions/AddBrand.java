package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.domain.Product;
import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ProductModel;

import java.util.ArrayList;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

public class AddBrand extends ActionSupport{


	private ProductModel productModel = new ProductModel();
	private Product product = new Product();
	private String categoryName;
	private TypeOfProduct typeOfProduct = new TypeOfProduct();
	private Category category = new Category();
	private SessionMap<String, Object> userSession;
	private ArrayList<String> categoryNames = new ArrayList<String> ();
	private ArrayList<String> models = new ArrayList<String> ();
	private ArrayList<String> brands = new ArrayList<String> ();
	private ArrayList<TypeOfProduct> listOfTypesOfProduct = new ArrayList<TypeOfProduct> ();
	private ArrayList<Category> categories = new ArrayList<Category> ();


	public String execute() {
		// se la categoria come presa dalla jsp è presente nella lista delle categorie possibili uso getbrands by category dal daoimpl, altrimenti uso quanto già implementato
		System.out.println("Sono entrato nella AddProduct Categories metodo  AddBrand");
		try {
			
			brands = (ArrayList<String>) FactoryDao.getIstance().getTypeOfProductDao().getBrandsByCategory(categoryName);
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

	public ArrayList<String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(ArrayList<String> categoryNames) {
		this.categoryNames = categoryNames;
	}

	public ArrayList<String> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
 

}
