<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tour guide delete</title>
<link rel="stylesheet" href="CSS/tourGuideDelete.css">
</head>
<body>
    <%
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
    %>

    <h1>Delete Account</h1>

    <form action="tourGuideDeleteServlet" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        <input type="submit" value="Yes" id="yes">
    </form>

    <a href="Login.jsp"><button type="submit" id="no">No</button></a>

    <img id="dbg" src="CSS/images/deletebg.jpg" alt="">
</body>
</html>
