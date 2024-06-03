package com.tourGuide;

public class TourGuide {

	//attributes
	private int id;
	private String name;
	private String password;
	private String repwd;
	private String phone;
	private String email;
	private String address;
	
	//overloaded constructor
	public TourGuide(int id, String name, String password, String repwd, String phone, String email, String address) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.repwd = repwd;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	//getter methods
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public String getRepwd() {
		return repwd;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
}
