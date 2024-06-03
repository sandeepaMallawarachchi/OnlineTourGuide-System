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

@WebServlet("/tourGuideUpdateServlet")
public class tourGuideUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("name");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

      //creating object from tourGuideDB class
        tourGuideDB tgdb = new tourGuideDB();
        
        boolean isTrue;

        isTrue = tgdb.updateTourGuide(id, username, pass, phone, email, address);

        try {
            if (isTrue) {

            	List<TourGuide> tourGuide = tourGuideDB.getDetails(id);
                request.setAttribute("tourGuide", tourGuide);

                if (tourGuide.isEmpty()) {
                    RequestDispatcher dis2 = request.getRequestDispatcher("Error.jsp");
                    dis2.forward(request, response);
                } 
                
                else {
                    request.setAttribute("tour", tourGuide);
                    RequestDispatcher dis2 = request.getRequestDispatcher("tourGuideDashboard.jsp");
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
