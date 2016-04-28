package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.Category;
import it.unisalento.SWEng_project.domain.Product;
import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.factories.FactoryDao;
import it.unisalento.SWEng_project.models.ProductModel;

import java.math.BigDecimal;
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
	private TypeOfProduct typeOfProduct = new TypeOfProduct();
	private Category category = new Category();
	private SessionMap<String, Object> userSession;
	private ArrayList<String> categoryNames = new ArrayList<String> ();
	private ArrayList<String> models = new ArrayList<String> ();
	private ArrayList<String> brands = new ArrayList<String> ();
	


	public void validate(){
		boolean errors = false;
		// effettuare controllo che la nuova categoria o brand o model non sia presente nell'array delle categorieo dei brand o dei models
		if (productModel.getCategoryName().isEmpty()){
			addFieldError("categoryName", "Scegli una categoria o inseriscine una nuova");
			errors = true;
		}
		if (productModel.getNewBrand().isEmpty() && productModel.getBrandName().isEmpty()){
			addFieldError("brandName", "Scegli una marca o inseriscine una nuova");
			errors = true;
		}
		if (productModel.getNewModel().isEmpty() && productModel.getModelName().isEmpty()){
			addFieldError("modelName", "Scegli un modello o inseriscine uno nuovo");
			errors = true;
		}
		if (errors) {
			addActionError("Sono presenti errori all'interno del form");
		}
	}

	public String execute()  {
		System.out.println("AddProduct.execute()");

		categoryNames = (ArrayList<String>) userSession.get("categoryNames");
		//this.models = FactoryDao.getIstance().

		// riempiamo gli oggetti con il model.
		// riempiamo prodotto
		product.setBarCode(productModel.getBarcode());
		product.setTitle(productModel.getTitle());
		product.setDescription(productModel.getDescription());
		product.setSize(productModel.getSizes());
		product.setWeight(productModel.getWeight());
		product.setSellingPrice(new BigDecimal(productModel.getSellingPrice()));
		product.setSellingDiscount(new BigDecimal(productModel.getSellingDiscount()));
		//reimpiamo tipo di prodotto;

		typeOfProduct.setBrand(productModel.getBrandName());
		typeOfProduct.setModel(productModel.getModelName());
		// riempiamo la categoria
		category.setName(productModel.getCategoryName());

		// eseguiamo le query in ordine.
		// prima controllo che esistono le categorie, poi i tipi di prodotto e 
		System.out.println("categoria scelta " + category.getName());
		System.out.println("brand scelto " + typeOfProduct.getBrand());
		System.out.println("model scelto " + typeOfProduct.getModel());

		try {
			if(!categoryNames.contains(category.getName())){
				// se non è già stata inserita una categoria con questo nome inseriscila nel DB
				category.setId(FactoryDao.getIstance().getCategoryDao().set(category));
			} else {
				category = (Category) FactoryDao.getIstance().getCategoryDao().getByName(productModel.getCategoryName());
			}
			// forse devo inserire un else per prendere dal database la categoria compresa di ID prima di settarla nel tipo di prodotto, stessa cosa per tipo di prodotto con prodotto
			// imposta la categoria del prodotto che stiamo inserendo


			if (!(brands.contains(productModel.getBrandName()) && models.contains(typeOfProduct.getModel()))){
				// se non è già stata inserito un tipo di prodotto con questa marca e modello inseriscilo nel DB
				typeOfProduct.setCategory(category);
				typeOfProduct.setId(FactoryDao.getIstance().getTypeOfProductDao().set(typeOfProduct));
			} else { // forse devo inserire un else per prendere dal database la categoria compresa di ID prima di settarla nel tipo di prodotto, stessa cosa per tipo di prodotto con prodotto
				typeOfProduct = (TypeOfProduct) FactoryDao.getIstance().getTypeOfProductDao().getTypeOfProductByBrandAndModel(productModel.getBrandName(), productModel.getModelName());
				System.out.println(typeOfProduct.getCategory().getName());
			}
			// imposta il tipo di prodotto del prodotto
			product.setTypeOfProduct(typeOfProduct);
			// inserisce il prodotto e ne prende l'ID
			product.setId(FactoryDao.getIstance().getProductDao().set(product));
		} catch (Exception e) {
			System.out.println("AddProduct.addProduct()");
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println( e.getStackTrace());
		}

		return SUCCESS;
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



	@Override
	public ProductModel getModel() {
		return productModel;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = 	(SessionMap<String, Object>) map;
	}


}
