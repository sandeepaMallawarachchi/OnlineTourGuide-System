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

@WebServlet("/acceptToursServlet")
public class acceptToursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creating object from tourGuideDB class
		tourGuideDB tgdb = new tourGuideDB();
	
		String type = request.getParameter("type");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");
		String details = request.getParameter("details");
		
		boolean isTrue;

		isTrue = tgdb.acceptTours(type, destination, date, details);
		
		if (isTrue == true) {
			
			List<RecievedTours> recieved = tourGuideDB.getTourDetails();
			request.setAttribute("recieved", recieved);
			RequestDispatcher dis = request.getRequestDispatcher("recievedTours.jsp");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis = request.getRequestDispatcher("Error.jsp");
			dis.forward(request, response);
		}
	}

}
