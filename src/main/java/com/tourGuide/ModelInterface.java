package com.tourGuide;

public interface ModelInterface { //interface
	
	//abstract methods
    public boolean insertTourGuide(String username, String pass, String repwd, String phone, String email, String address);
    public boolean updateTourGuide(String id, String username, String pass, String phone, String email, String address);
    public boolean deleteTourGuide(String id);
    public boolean rejectTours(String id);
	public boolean acceptTours(String type, String destination, String date, String details);
    
}
