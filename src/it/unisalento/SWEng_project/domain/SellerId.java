package it.unisalento.SWEng_project.domain;

// Generated 16-mar-2016 14.43.11 by Hibernate Tools 4.3.1

/**
 * SellerId generated by hbm2java
 */
public class SellerId implements java.io.Serializable {

	private String vatNumber;
	private int userId;

	public SellerId() {
	}

	public SellerId(String vatNumber, int userId) {
		this.vatNumber = vatNumber;
		this.userId = userId;
	}

	public String getVatNumber() {
		return this.vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SellerId))
			return false;
		SellerId castOther = (SellerId) other;

		return ((this.getVatNumber() == castOther.getVatNumber()) || (this
				.getVatNumber() != null && castOther.getVatNumber() != null && this
				.getVatNumber().equals(castOther.getVatNumber())))
				&& (this.getUserId() == castOther.getUserId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getVatNumber() == null ? 0 : this.getVatNumber().hashCode());
		result = 37 * result + this.getUserId();
		return result;
	}

}
