package it.unisalento.SWEng_project.domain;

// Generated 15-mar-2016 15.20.49 by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * Includes generated by hbm2java
 */
public class Includes implements java.io.Serializable {

	private IncludesId id;
	private Order order;
	private Product product;
	private Shop shop;
	private String state;
	private String collectModality;
	private Integer quantityPurchased;
	private BigDecimal purchasePrice;
	private BigDecimal purchaseDiscount;
	private BigDecimal partialPrice;

	public Includes() {
	}

	public Includes(IncludesId id, Order order, Product product, Shop shop,
			String state) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.shop = shop;
		this.state = state;
	}

	public Includes(IncludesId id, Order order, Product product, Shop shop,
			String state, String collectModality, Integer quantityPurchased,
			BigDecimal purchasePrice, BigDecimal purchaseDiscount,
			BigDecimal partialPrice) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.shop = shop;
		this.state = state;
		this.collectModality = collectModality;
		this.quantityPurchased = quantityPurchased;
		this.purchasePrice = purchasePrice;
		this.purchaseDiscount = purchaseDiscount;
		this.partialPrice = partialPrice;
	}

	public IncludesId getId() {
		return this.id;
	}

	public void setId(IncludesId id) {
		this.id = id;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCollectModality() {
		return this.collectModality;
	}

	public void setCollectModality(String collectModality) {
		this.collectModality = collectModality;
	}

	public Integer getQuantityPurchased() {
		return this.quantityPurchased;
	}

	public void setQuantityPurchased(Integer quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getPurchaseDiscount() {
		return this.purchaseDiscount;
	}

	public void setPurchaseDiscount(BigDecimal purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	public BigDecimal getPartialPrice() {
		return this.partialPrice;
	}

	public void setPartialPrice(BigDecimal partialPrice) {
		this.partialPrice = partialPrice;
	}

}
