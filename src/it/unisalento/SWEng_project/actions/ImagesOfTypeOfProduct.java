package it.unisalento.SWEng_project.actions;

import it.unisalento.SWEng_project.domain.ProductPhoto;
import it.unisalento.SWEng_project.domain.TypeOfProduct;
import it.unisalento.SWEng_project.dto.ProductPhotoDTO;
import it.unisalento.SWEng_project.factories.FactoryDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ImagesOfTypeOfProduct extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4996786833528976285L;
	private Integer id;
	private SessionMap<String, Object> userSession;
	private String key;
	// mi serve questa radice per creare una chiave da salvare nella userSession dove conservare le foto di ogni tipo di prodotto
	private static final String radice = "photoPerTypeOfProductWithId";
	private ArrayList<ProductPhoto>  photos;


	public String execute() {
		System.out.println("Sono entrato nella action ImagesOfTypeOfProduct");
		key = radice.concat(id.toString());
		//if (!userSession.containsKey(key)) { 
			try {
				photos = new ArrayList<ProductPhoto>();
				System.out.println("ArrayList ottenuto");
				// ottengo le foto in base all'id del tipo di prodotto
				photos = (ArrayList<ProductPhoto>)FactoryDao.getIstance().getProductPhotoDao().getAllPhotosByIdTypeOfProduct(id);				
				Iterator photosIterator = photos.iterator();
				int index = 0;
				while(photosIterator.hasNext()) {
					System.out.println("elemento all'index " + index + " = " + photosIterator.next());
					index++;
				}


				userSession.put(key, photos );

			} catch (Exception e) {
				System.out.println("message  " + e.getLocalizedMessage());
				System.out.println("cause  " + e.getCause());
				System.out.println("cause  " + e.getStackTrace());
			}
		// }
		
		return SUCCESS;
	}

	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}
	

	public ArrayList<ProductPhoto> getPhotos() {
		return photos;
	}



	public void setPhotos(ArrayList<ProductPhoto> photos) {
		this.photos = photos;
	}



	@Override
	public void setSession(Map<String, Object> map) {
		this.userSession = (SessionMap<String,Object>)map;
	}

}
