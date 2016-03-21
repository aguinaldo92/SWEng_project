package it.unisalento.SWEng_project.domain;

// Generated 21-mar-2016 17.28.49 by Hibernate Tools 4.3.1

/**
 * Location generated by hbm2java
 */
public class Location implements java.io.Serializable {

	private LocationId id;
	private User user;
	private String cap;
	private String address;
	private String number;
	private String city;
	private String province;
	private String state;

	public Location() {
	}

	public Location(LocationId id, User user) {
		this.id = id;
		this.user = user;
	}

	public Location(LocationId id, User user, String cap, String address,
			String number, String city, String province, String state) {
		this.id = id;
		this.user = user;
		this.cap = cap;
		this.address = address;
		this.number = number;
		this.city = city;
		this.province = province;
		this.state = state;
	}

	public LocationId getId() {
		return this.id;
	}

	public void setId(LocationId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
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

}
