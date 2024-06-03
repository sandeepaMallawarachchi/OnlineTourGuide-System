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

@WebServlet("/recievedToursServlet")
public class recievedToursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            List<RecievedTours> recieved = tourGuideDB.getTourDetails();

            if (recieved.isEmpty()) {

            	RequestDispatcher errorDispatcher = request.getRequestDispatcher("unsuccessful.jsp");
                errorDispatcher.forward(request, response);
            } 
            
            else {

            	request.setAttribute("recieved", recieved);
                RequestDispatcher successDispatcher = request.getRequestDispatcher("recievedTours.jsp");
                successDispatcher.forward(request, response);
            }
        } 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
