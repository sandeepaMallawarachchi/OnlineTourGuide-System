package com.tourGuide;

@SuppressWarnings("serial")
public class CheckDBPassword extends Exception{ //custom exception class to check database password

	CheckDBPassword(String msg){
		super(msg);
	}
}
