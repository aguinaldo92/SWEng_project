package it.unisalento.SWEng_project.domain;

// Generated 16-mar-2016 14.43.11 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Integer id;
	private TypeOfProduct typeOfProduct;
	private String barCode;
	private String description;
	private String title;
	private String colour;
	private String weight;
	private String size;
	private Device device;
	private Set includeses = new HashSet(0);
	private Set productPhotos = new HashSet(0);
	private Set sellses = new HashSet(0);
	private Set shipments = new HashSet(0);

	public Product() {
	}

	public Product(TypeOfProduct typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	public Product(TypeOfProduct typeOfProduct, String barCode,
			String description, String title, String colour, String weight,
			String size, Device device, Set includeses, Set productPhotos,
			Set sellses, Set shipments) {
		this.typeOfProduct = typeOfProduct;
		this.barCode = barCode;
		this.description = description;
		this.title = title;
		this.colour = colour;
		this.weight = weight;
		this.size = size;
		this.device = device;
		this.includeses = includeses;
		this.productPhotos = productPhotos;
		this.sellses = sellses;
		this.shipments = shipments;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeOfProduct getTypeOfProduct() {
		return this.typeOfProduct;
	}

	public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Set getIncludeses() {
		return this.includeses;
	}

	public void setIncludeses(Set includeses) {
		this.includeses = includeses;
	}

	public Set getProductPhotos() {
		return this.productPhotos;
	}

	public void setProductPhotos(Set productPhotos) {
		this.productPhotos = productPhotos;
	}

	public Set getSellses() {
		return this.sellses;
	}

	public void setSellses(Set sellses) {
		this.sellses = sellses;
	}

	public Set getShipments() {
		return this.shipments;
	}

	public void setShipments(Set shipments) {
		this.shipments = shipments;
	}

}
