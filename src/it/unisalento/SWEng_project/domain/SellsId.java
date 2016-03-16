package it.unisalento.SWEng_project.domain;

// Generated 16-mar-2016 14.43.11 by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * SellsId generated by hbm2java
 */
public class SellsId implements java.io.Serializable {

	private BigDecimal sellingPrice;
	private BigDecimal sellingDiscount;
	private Integer quantityAvailable;
	private int shopId;
	private int productId;

	public SellsId() {
	}

	public SellsId(BigDecimal sellingPrice, int shopId, int productId) {
		this.sellingPrice = sellingPrice;
		this.shopId = shopId;
		this.productId = productId;
	}

	public SellsId(BigDecimal sellingPrice, BigDecimal sellingDiscount,
			Integer quantityAvailable, int shopId, int productId) {
		this.sellingPrice = sellingPrice;
		this.sellingDiscount = sellingDiscount;
		this.quantityAvailable = quantityAvailable;
		this.shopId = shopId;
		this.productId = productId;
	}

	public BigDecimal getSellingPrice() {
		return this.sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public BigDecimal getSellingDiscount() {
		return this.sellingDiscount;
	}

	public void setSellingDiscount(BigDecimal sellingDiscount) {
		this.sellingDiscount = sellingDiscount;
	}

	public Integer getQuantityAvailable() {
		return this.quantityAvailable;
	}

	public void setQuantityAvailable(Integer quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public int getShopId() {
		return this.shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SellsId))
			return false;
		SellsId castOther = (SellsId) other;

		return ((this.getSellingPrice() == castOther.getSellingPrice()) || (this
				.getSellingPrice() != null
				&& castOther.getSellingPrice() != null && this
				.getSellingPrice().equals(castOther.getSellingPrice())))
				&& ((this.getSellingDiscount() == castOther
						.getSellingDiscount()) || (this.getSellingDiscount() != null
						&& castOther.getSellingDiscount() != null && this
						.getSellingDiscount().equals(
								castOther.getSellingDiscount())))
				&& ((this.getQuantityAvailable() == castOther
						.getQuantityAvailable()) || (this
						.getQuantityAvailable() != null
						&& castOther.getQuantityAvailable() != null && this
						.getQuantityAvailable().equals(
								castOther.getQuantityAvailable())))
				&& (this.getShopId() == castOther.getShopId())
				&& (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSellingPrice() == null ? 0 : this.getSellingPrice()
						.hashCode());
		result = 37
				* result
				+ (getSellingDiscount() == null ? 0 : this.getSellingDiscount()
						.hashCode());
		result = 37
				* result
				+ (getQuantityAvailable() == null ? 0 : this
						.getQuantityAvailable().hashCode());
		result = 37 * result + this.getShopId();
		result = 37 * result + this.getProductId();
		return result;
	}

}
