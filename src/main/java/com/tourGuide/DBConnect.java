package com.tourGuide;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static String url = "jdbc:mysql://localhost:3306/online_tour_guide_system"; //create connection with online_tour_guide_system database
    private static String user = "root"; //db username
    private static String password = "Sandeepa123"; //db password
    private static Connection con;
    
    static Connection getConnection() {
    	
    	try { //use exception to validate the connection
			
    		if (password != "Sandeepa123") {
				throw new CheckDBPassword("Ivalid password!");
			}
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		con = DriverManager.getConnection(url, user, password);
		} 
    	
    	catch (CheckDBPassword e) {
    		System.out.println(e.getMessage()); // Print the custom exception message.
		}
    	
    	catch (Exception e) {
    		System.out.println("Database connection is not success!");
    	}
    	
		return con;
    }
}