package com.tourGuide;

public class Login {

	//attributes
	private int id;
	private String name;
	private String password;
	
	//overloaded constructor
	public Login(int id, String name, String password) {

		this.id = id;
		this.name = name;
		this.password = password;
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

	
}
