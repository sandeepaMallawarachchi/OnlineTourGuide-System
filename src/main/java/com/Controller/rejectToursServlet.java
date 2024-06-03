package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourGuide.RecievedTours;
import com.tourGuide.tourGuideDB;

@WebServlet("/rejectToursServlet")
public class rejectToursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		//creating object from tourGuideDB class
		tourGuideDB tgdb = new tourGuideDB();
		
		boolean result;
		
		result = tgdb.rejectTours(id);
		
		try {
            if (result) {

            	List<RecievedTours> getTourDetails = tourGuideDB.getTourDetails();
                request.setAttribute("getTourDetails", getTourDetails);

                if (getTourDetails.isEmpty()) {
                    RequestDispatcher dis2 = request.getRequestDispatcher("unsuccessful.jsp");
                    dis2.forward(request, response);
                } 
                
                else {
                    request.setAttribute("recieved", getTourDetails);
                    RequestDispatcher dis2 = request.getRequestDispatcher("recievedTours.jsp");
                    dis2.forward(request, response);
                }
            } 
            
            else {
                RequestDispatcher dis = request.getRequestDispatcher("unsuccessful.jsp");
                dis.forward(request, response);
            }
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
