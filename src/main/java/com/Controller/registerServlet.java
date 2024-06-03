package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourGuide.tourGuideDB;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating object from tourGuideDB class
		tourGuideDB tgdb = new tourGuideDB();
		
		String username = request.getParameter("name");
		String pass = request.getParameter("pass");
		String repwd = request.getParameter("repwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		boolean isTrue;

		isTrue = tgdb.insertTourGuide(username, pass, repwd, phone, email, address);
		
		if (isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
			dis.forward(request, response);
		}
		
		else {
			RequestDispatcher dis = request.getRequestDispatcher("Error.jsp");
			dis.forward(request, response);
		}
	}

}
