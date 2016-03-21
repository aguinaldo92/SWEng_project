package it.unisalento.SWEng_project.domain;

// Generated 21-mar-2016 17.28.49 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Shop generated by hbm2java
 */
public class Shop implements java.io.Serializable {

	private Integer id;
	private User user;
	private String name;
	private BigDecimal lat;
	private BigDecimal long_;
	private String address;
	private String cap;
	private String city;
	private String province;
	private String state;
	private String typology;
	private Date registrationDate;
	private Set sellses = new HashSet(0);
	private Set includeses = new HashSet(0);

	public Shop() {
	}

	public Shop(User user, String name) {
		this.user = user;
		this.name = name;
	}

	public Shop(User user, String name, BigDecimal lat, BigDecimal long_,
			String address, String cap, String city, String province,
			String state, String typology, Date registrationDate, Set sellses,
			Set includeses) {
		this.user = user;
		this.name = name;
		this.lat = lat;
		this.long_ = long_;
		this.address = address;
		this.cap = cap;
		this.city = city;
		this.province = province;
		this.state = state;
		this.typology = typology;
		this.registrationDate = registrationDate;
		this.sellses = sellses;
		this.includeses = includeses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLong_() {
		return this.long_;
	}

	public void setLong_(BigDecimal long_) {
		this.long_ = long_;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypology() {
		return this.typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Set getSellses() {
		return this.sellses;
	}

	public void setSellses(Set sellses) {
		this.sellses = sellses;
	}

	public Set getIncludeses() {
		return this.includeses;
	}

	public void setIncludeses(Set includeses) {
		this.includeses = includeses;
	}

}
