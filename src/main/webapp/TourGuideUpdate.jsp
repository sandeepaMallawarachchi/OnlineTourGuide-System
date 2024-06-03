<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Tour Guide Details</title>
<link rel="stylesheet" href="CSS/tourGuideUpdate.css">
</head>
<body>

	<%
		String id = request.getParameter("id"); 
		String name = request.getParameter("name"); 
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone"); 
		String email = request.getParameter("email"); 
		String address = request.getParameter("address"); 
	%>
	
	<h1 id="topic">Update Details</h1>

	<form action="tourGuideUpdateServlet" method="post">
			   	
	        <p>Tour guide id:</p>
	        <input type="text" name="id" value="<%= id %>" readonly>
	
	        <p>Username:</p>
	        <input type="text" name="name" value="<%= name %>" required>
	        
	        <p>Password:</p>
	        <input type="text" name="pass" value="<%= password %>" required>
	
	        <p>Phone:</p>
	        <input type="text" name="phone" required min="10" max="10" value="<%= phone %>">
	            
	        <p>Email:</p>
	        <input type="email" name="email" required value="<%= email %>">
	            
	        <p>Address:</p>
	        <input type="text" name="address" value="<%= address %>">
			
		    <input type="submit" value="Update" id="update">
		          
		    <button id="back">Back</button>          
        </form>
</body>
</html>