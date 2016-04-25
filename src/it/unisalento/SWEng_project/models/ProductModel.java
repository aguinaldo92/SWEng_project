package it.unisalento.SWEng_project.models;

import java.math.BigDecimal;

public class ProductModel {
	private String barcode;
	private String title;
	private String description;
	private String sizes;
	private String weight;
	private String brandName;
	private String newBrand;
	private String modelName;
	private String newModel;
	private String categoryName;
	private String newCategory;
	private String sellingPrice;
	private String sellingDiscount;
	
	
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

	public String getNewBrand() {
		return newBrand;
	}
	public void setNewBrand(String newBrand) {
		this.newBrand = newBrand;
	}
	public String getNewModel() {
		return newModel;
	}
	public void setNewModel(String newModel) {
		this.newModel = newModel;
	}
	public String getNewCategory() {
		return newCategory;
	}
	public void setNewCategory(String newCategory) {
		this.newCategory = newCategory;
	}
	public String getBrandName() {
		if(brandName.equals("-1")){
			return newBrand;
		}
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		if(modelName.equals("-1")){
			return newModel;
		}
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCategoryName() {
		if(categoryName.equals("-1")){
			return newCategory;
		}
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getSellingDiscount() {
		return sellingDiscount;
	}
	public void setSellingDiscount(String sellingDiscount) {
		if (sellingDiscount.isEmpty()){
			this.sellingDiscount =(String) "0";
		}
		this.sellingDiscount = sellingDiscount;
	}

	

	
	
	
}
