package it.unisalento.SWEng_project.models;

import java.math.BigDecimal;

public class ProductModel {
	private String barcode;
	private String title;
	private String description;
	private String sizes;
	private String weight;
	private String brand;
	private String model;
	private String categoryName;
	private BigDecimal sellingPrice;
	private BigDecimal sellingDiscount;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public BigDecimal getSellingDiscount() {
		return sellingDiscount;
	}
	public void setSellingDiscount(BigDecimal sellingDiscount) {
		this.sellingDiscount = sellingDiscount;
	}
	

	
	
	
}
