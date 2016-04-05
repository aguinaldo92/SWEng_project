package it.unisalento.SWEng_project.dto;

import it.unisalento.SWEng_project.domain.Product;

import java.io.Serializable;

public class ProductPhotoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5906280259435576412L;
	private Integer id;
	private Product product;
	private String photoUri;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getPhotoUri() {
		return photoUri;
	}
	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
		if (this.photoUri == null) {
			this.photoUri = "images/TypeOfProducts/immagineNonDisponibile.jpg";
		}
		
	}
}
