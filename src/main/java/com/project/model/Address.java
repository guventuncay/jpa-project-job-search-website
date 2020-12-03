package com.project.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String road;
	private String postalCode;
	private String city;

	public Address() {
	}

	public Address(String street, String road, String postalCode, String city) {
		this.street = street;
		this.road = road;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", road=" + road + ", postalCode=" + postalCode + ", city=" + city + "]";
	}

	

	
}
