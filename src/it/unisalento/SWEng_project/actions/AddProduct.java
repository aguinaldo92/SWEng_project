package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.domain.Product;
import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ProductModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddProduct extends ActionSupport implements ModelDriven<ProductModel>, SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6080237631998689309L;
	private ProductModel productModel = new ProductModel();
	private Product product = new Product();
	 private String term;
	private TypeOfProduct typeOfProduct = new TypeOfProduct();
	private Category category = new Category();
	private SessionMap<String, Object> userSession;
	private ArrayList<String> categoryNames = new ArrayList<String> ();
	private ArrayList<String> models = new ArrayList<String> ();
	private ArrayList<String> brands = new ArrayList<String> ();
	private ArrayList<TypeOfProduct> listOfTypesOfProduct = new ArrayList<TypeOfProduct> ();;
	private ArrayList<Category> categories = new ArrayList<Category> ();




	public String execute()  {
		System.out.println("AddProduct.execute()");

		this.categoryNames = (ArrayList<String>) this.userSession.get("categoryNames");
		//this.models = FactoryDao.getIstance().

		// riempiamo gli oggetti con il model.
		// riempiamo prodotto
		product.setBarCode(productModel.getBarcode());
		product.setTitle(productModel.getTitle());
		product.setDescription(productModel.getDescription());
		product.setSize(productModel.getSizes());
		product.setWeight(productModel.getWeight());
		product.setSellingPrice(productModel.getSellingPrice());
		product.setSellingDiscount(productModel.getSellingDiscount());
		//reimpiamo tipo di prodotto;
		typeOfProduct.setBrand(productModel.getBrand());
		typeOfProduct.setModel(productModel.getModel());
		// riempiamo la categoria
		category.setName(productModel.getCategoryName());

		// eseguiamo le query in ordine.
		// prima controllo che esistono le categorie, poi i tipi di prodotto e 


		try {
			if(!this.categoryNames.contains(category.getName())){
				// se non � gi� stata inserita una categoria con questo nome inseriscila nel DB
				category.setId(FactoryDao.getIstance().getCategoryDao().set(category));
			} else {
				category = (Category) FactoryDao.getIstance().getCategoryDao().getByName(productModel.getCategoryName());
			}
			// forse devo inserire un else per prendere dal database la categoria compresa di ID prima di settarla nel tipo di prodotto, stessa cosa per tipo di prodotto con prodotto
			// imposta la categoria del prodotto che stiamo inserendo
			//typeOfProduct.setCategory(category);

			if (!(this.brands.contains(typeOfProduct.getBrand()) && this.models.contains(typeOfProduct.getModel()))){
				// se non � gi� stata inserito un tipo di prodotto con questa marca e modello inseriscilo nel DB
				//typeOfProduct.setId(FactoryDao.getIstance().getTypeOfProductDao().set(typeOfProduct));
			} // forse devo inserire un else per prendere dal database la categoria compresa di ID prima di settarla nel tipo di prodotto, stessa cosa per tipo di prodotto con prodotto
			// imposta il tipo di prodotto del prodotto
			//product.setTypeOfProduct(typeOfProduct);
			// inserisce il prodotto e ne prende l'ID
			//product.setId(FactoryDao.getIstance().getProductDao().set(product));
		} catch (Exception e) {
			System.out.println("AddProduct.addProduct()");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println( e.getStackTrace());
		}

		return SUCCESS;
	}


	

	

	// faccio in modo da mostrare i modelli o aggiungerli
	public String addModel() {
		System.out.println("Sono entrato nella AddProduct Categories metodo  AddModel");
		try {
			Iterator<TypeOfProduct> listOfTypesOfProductIterator = getIteratorOfTypeOfProduct();
			while(listOfTypesOfProductIterator.hasNext()) {
				TypeOfProduct currentTypeOfProduct = (TypeOfProduct) listOfTypesOfProductIterator.next(); 
				models.add(currentTypeOfProduct.getModel());
			} 
		} catch (Exception e){
			System.out.println("AddProduct.addModel()");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println( e.getStackTrace());
		}

		return ActionSupport.NONE;
	}

	private Iterator<TypeOfProduct> getIteratorOfTypeOfProduct() throws Exception {
		if(listOfTypesOfProduct.isEmpty()){
			listOfTypesOfProduct = (ArrayList<TypeOfProduct>) FactoryDao.getIstance().getTypeOfProductDao().getAll(TypeOfProduct.class);
		}
		System.out.println("listOfTypesOfProduct ottenuta");
		Iterator<TypeOfProduct> listOfTypesOfProductIterator = listOfTypesOfProduct.iterator();
		return listOfTypesOfProductIterator;
	}

	public ArrayList<String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(ArrayList<String> categoryNames) {
		this.categoryNames = categoryNames;
	}
	public ArrayList<String> getModels() {
		return models;
	}

	public void setModels(ArrayList<String> models) {
		this.models = models;
	}

	public ArrayList<String> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}
	

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public ProductModel getModel() {
		return productModel;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = 	(SessionMap<String, Object>) map;
	}
}
