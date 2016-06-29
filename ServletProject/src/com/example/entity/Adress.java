package com.example.entity;

public class Adress extends IdEntity {
	private String city;
	private String country;
	private String userId;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Adress [city=" + city + ", country=" + country + ", userId=" + userId + ", id=" + id + "]";
	}
	

}
