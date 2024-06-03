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

@WebServlet("/tourGuideDashboardServlet")
public class tourGuideDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		
		tourGuideDB.validate(username, password);
		
		try {
			
			List<TourGuide> tour = tourGuideDB.validate(username, password);
			request.setAttribute("tour", tour);
		} 
		
		catch (Exception e) {

			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
		dis.forward(request, response);
	}

}
