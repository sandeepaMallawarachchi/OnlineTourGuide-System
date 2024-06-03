package com.tourGuide;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class tourGuideDB implements ModelInterface{ //implements from interface
	
	private static Connection con = null;
	private static Statement stat = null;

	//inserting data to tour_guide_registration table
	@Override
    public boolean insertTourGuide(String username, String pass, String repwd, String phone, String email, String address) {
        
    	boolean isSuccess = false;
        
        try {
        	
        	con = DBConnect.getConnection();
        	stat = con.createStatement();
            
            String sql = "INSERT INTO tour_guide_registration VALUES(0, '"+username+"', '"+pass+"','"+repwd+"', '"+phone+"', '"+email+"', '"+address+"')";
            int rs = stat.executeUpdate(sql);
            
            if (rs > 0) {
                isSuccess = true;
            } 
            
            else {
                isSuccess = false;
            }
            
            con.close(); 
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }

    //retrieving data from tour_guide_registration table
    public static List<TourGuide> validate(String username, String pass){
		
		ArrayList<TourGuide> tour = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
            stat = con.createStatement();
            
            String sql = "SELECT * FROM tour_guide_registration WHERE username = '" + username + "' AND password = '" + pass + "'";
			ResultSet rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String repwd = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String address = rs.getString(7);
				 
				TourGuide t = new TourGuide(id, name, password, repwd, phone, email, address);
				tour.add(t);
			}
		} 
		
		catch (Exception e) {

			e.printStackTrace();
		}
		
		return tour;
	}
    
    //updating tour_guide_registration table
    @Override
	public boolean updateTourGuide(String id, String username, String pass, String phone, String email, String address) {
	
		  boolean isSuccess = false;
		  
		  try {
		      con = DBConnect.getConnection();
		      stat = con.createStatement();
		
		      String sql = "update tour_guide_registration set username = '" + username + "', password = '" + pass + "', phone = '" + phone + "', email = '"+email+"', address = '"+address+"'"
		    		  		+ "where id = '"+id+"'";
		      int rs = stat.executeUpdate(sql);
		
		      if (rs > 0) {
		          isSuccess = true;
		      } 
		      
		      else {
		          isSuccess = false;
		      }
		
		  } 
		  
		  catch (Exception e) {
		      e.printStackTrace();
		  }
	
		  return isSuccess;
	}
	
	//retrieving all data from tour_guide_registration table
	public static List<TourGuide> getDetails(String id) {
		
		int convert = Integer.parseInt(id);

		ArrayList<TourGuide> tourGuide = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
            stat = con.createStatement();
            
            String sql = "SELECT * FROM tour_guide_registration WHERE id = '" + convert + "'";
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String repwd = rs.getString(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String address = rs.getString(7);
				 
				TourGuide tg = new TourGuide(id1, name, password, repwd, phone, email, address);
				tourGuide.add(tg);	
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return tourGuide;
	}
	
	//deleting tour guide's details
	@Override
	public boolean deleteTourGuide(String id) {
		
		if (id == null || id.isEmpty()) {
	        return false;
	    }
		
		int convert = Integer.parseInt(id);
		
		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "delete from tour_guide_registration where id = '" + convert + "'";
			int rs = stat.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			}

			else {
				isSuccess = false;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	public static List<RecievedTours> getTourDetails(){
		
		ArrayList<RecievedTours> recieved = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
            stat = con.createStatement();
            
            String sql = "SELECT * FROM recieved_tours";
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				String id = rs.getString(1);
				String type = rs.getString(2);
				String destination = rs.getString(3);
				String date = rs.getString(4);
				String details = rs.getString(5);
				String status = rs.getString(6);
				 
				RecievedTours r = new RecievedTours(id, type, destination, date, details, status);
				recieved.add(r);
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return recieved;
	}
	
	@Override
	public boolean rejectTours(String id) {
		
		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "delete from recieved_tours where id = '" + id + "'";
			int rs = stat.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			}

			else {
				isSuccess = false;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	@Override
	public boolean acceptTours(String type, String destination, String date, String details) {
        
    	boolean isSuccess = false;
        
        try {
        	
        	con = DBConnect.getConnection();
        	stat = con.createStatement();
            
            String sql = "INSERT INTO accept_tours VALUES(0, '"+type+"', '"+destination+"','"+date+"', '"+details+"')";
            int rs = stat.executeUpdate(sql);
            
            if (rs > 0) {
                isSuccess = true;
            } 
            
            else {
                isSuccess = false;
            }
            
            con.close(); 
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
}
