package com.persistance.jpa;

import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embeddable;

@Embeddable
//@AttributeOverrides({
//	AttributeOverride(name="streetName", column = @Column(name="street_name"))
//})
public class Address {
	private String streetName;
	private String city;
	private String zipCode;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
