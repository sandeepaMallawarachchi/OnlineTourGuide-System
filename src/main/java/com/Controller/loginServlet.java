package com.Controller;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tourGuide.TourGuide;
import com.tourGuide.tourGuideDB;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("name");
        String password = request.getParameter("pass");

        List<TourGuide> tour = tourGuideDB.validate(username, password);
        
        if (tour.isEmpty()) {

        	PrintWriter out = response.getWriter();
            
            out.println("<script type='text/javascript'>");
            out.println("alert('Your username or password is incorrect');");
            out.println("location='Login.jsp'");
            out.println("</script>");

        } else {

        	request.setAttribute("tour", tour);
        	RequestDispatcher successDispatcher = request.getRequestDispatcher("tourGuideDashboard.jsp");
            successDispatcher.forward(request, response);
        }
	}

}