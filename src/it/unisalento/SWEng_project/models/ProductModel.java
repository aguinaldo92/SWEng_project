package it.unisalento.SWEng_project.models;

import java.math.BigDecimal;

public class ProductModel {
	private String barcode;
	private String title;
	private String description;
	private String size;
	private String weight;
	private String brand;
	private String model;
	private String category;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
