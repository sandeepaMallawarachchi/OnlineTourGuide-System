package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourGuide.TourGuide;
import com.tourGuide.tourGuideDB;

@WebServlet("/tourGuideDeleteServlet")
public class tourGuideDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		
		//creating object from tourGuideDB class
		tourGuideDB tgdb = new tourGuideDB();
		
		boolean isTrue;
		
		isTrue = tgdb.deleteTourGuide(id);
		
		
		if (isTrue) {
			
			List<TourGuide> tour = tourGuideDB.validate(username, password);
			request.setAttribute("tour", tour);
			
			RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
			dis.forward(request, response);
		} 
		
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccessful.jsp");
			dis.forward(request, response);
		}
	}

}
