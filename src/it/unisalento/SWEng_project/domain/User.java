package it.unisalento.SWEng_project.domain;

<<<<<<< HEAD
// Generated 21-mar-2016 17.28.49 by Hibernate Tools 4.3.1
=======
// Generated 18-mar-2016 23.51.26 by Hibernate Tools 4.3.1
>>>>>>> refs/remotes/origin/master

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer id;
	private String ssn;
	private String username;
	private String password;
	private Date createTime;
	private String name;
	private String surname;
	private Date dateOfBirth;
	private String gender;
	private String telephone;
	private String cellular;
	private String email;
	private Boolean seller;
	private String vatNumber;
	private Set shops = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set locations = new HashSet(0);

	public User() {
	}

	public User(String ssn, String username, String password) {
		this.ssn = ssn;
		this.username = username;
		this.password = password;
	}

	public User(String ssn, String username, String password, Date createTime,
			String name, String surname, Date dateOfBirth, String gender,
			String telephone, String cellular, String email, Boolean seller,
			String vatNumber, Set shops, Set orders, Set locations) {
		this.ssn = ssn;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.telephone = telephone;
		this.cellular = cellular;
		this.email = email;
		this.seller = seller;
		this.vatNumber = vatNumber;
		this.shops = shops;
		this.orders = orders;
		this.locations = locations;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellular() {
		return this.cellular;
	}

	public void setCellular(String cellular) {
		this.cellular = cellular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getSeller() {
		return this.seller;
	}

	public void setSeller(Boolean seller) {
		this.seller = seller;
	}

	public String getVatNumber() {
		return this.vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public Set getShops() {
		return this.shops;
	}

	public void setShops(Set shops) {
		this.shops = shops;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getLocations() {
		return this.locations;
	}

	public void setLocations(Set locations) {
		this.locations = locations;
	}
}
