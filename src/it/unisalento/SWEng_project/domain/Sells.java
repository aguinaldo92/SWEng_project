package it.unisalento.SWEng_project.domain;

<<<<<<< HEAD
// Generated 21-mar-2016 17.28.49 by Hibernate Tools 4.3.1
=======
// Generated 18-mar-2016 23.51.26 by Hibernate Tools 4.3.1
>>>>>>> refs/remotes/origin/master

/**
 * Sells generated by hbm2java
 */
public class Sells implements java.io.Serializable {

	private SellsId id;
	private Product product;
	private Shop shop;

	public Sells() {
	}

	public Sells(SellsId id, Product product, Shop shop) {
		this.id = id;
		this.product = product;
		this.shop = shop;
	}

	public SellsId getId() {
		return this.id;
	}

	public void setId(SellsId id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
