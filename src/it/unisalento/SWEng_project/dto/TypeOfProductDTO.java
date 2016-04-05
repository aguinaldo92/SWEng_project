package it.unisalento.SWEng_project.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Data Transfer Object Pattern peril tipo di prodotto con i relativi attributi ottenuti da unaquery di join
 * @author andrea
 *
 */
public class TypeOfProductDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 972688695678719126L;
	private Integer id;
	private String categoryName;
	private String model;
	private String brand;
	private BigDecimal minPrice;
	private BigDecimal maxSellingDiscount;
//	private HashSet<String> photoUris;
	private Long quantityAvailable;
	
	
	/**
	 * getters and setters
	 *
	 */
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	// scalo al centesimo di € il calcolo del prezzo scontato
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice.setScale(2, RoundingMode.CEILING);;
	}
	public Long getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(Long quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
