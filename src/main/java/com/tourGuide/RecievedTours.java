package com.tourGuide;

public class RecievedTours {

	private String id;
	private String type;
	private String destination;
	private String date;
	private String details;
	private String status;
	
	public RecievedTours(String id,  String type, String destination, String date, String details, String status) {

		this.id = id;
		this.type = type;
		this.destination = destination;
		this.date = date;
		this.details = details;
		this.status = status;
	}

	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}

	public String getDestination() {
		return destination;
	}

	public String getDate() {
		return date;
	}

	public String getDetails() {
		return details;
	}
	
	public String getStatus() {
		return status;
	}
	
}
