package it.unisalento.SWEng_project.domain;

// Generated 15-mar-2016 15.20.49 by Hibernate Tools 4.3.1

/**
 * ProductPhoto generated by hbm2java
 */
public class ProductPhoto implements java.io.Serializable {

	private ProductPhotoId id;
	private Product product;

	public ProductPhoto() {
	}

	public ProductPhoto(ProductPhotoId id, Product product) {
		this.id = id;
		this.product = product;
	}

	public ProductPhotoId getId() {
		return this.id;
	}

	public void setId(ProductPhotoId id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
