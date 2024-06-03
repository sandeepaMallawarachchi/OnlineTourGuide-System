<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tour Guide User Account</title>
<link rel="stylesheet" href="CSS/home.css">
<link rel="stylesheet" href="CSS/tourGuideDashboard.css">
</head>
<body>
	
	<section id="navbar">

        <div id="logo"><a href="home.jsp"><img src="CSS/images/logo.png"></a></div>
        <div id="navbtn">

            <a href="home.jsp"><button style="text-decoration: underline;">Home</button></a>
            <a href="#"><button>Tours</button></a>
            <a href="#"><button>Contact us</button></a>
            <a href="#"><button>About us</button></a>
            <a href="Login.jsp"><img src="CSS/images/profile.png" alt="" id="profile"></a>
        </div>
    </section>

	<h1 id="topic">Tour Guide User Account</h1>
    <a href="Login.jsp" id="lo"><button id="logout">Logout</button></a>
    <div id="details">
    
	    	<c:forEach var="tourguide" items="${tour}">
	    	
		    	<c:set var="id" value="${tourguide.id }"/>
			   	<c:set var="name" value="${tourguide.name }"/>
			   	<c:set var="password" value="${tourguide.password }"/>
			   	<c:set var="phone" value="${tourguide.phone }"/>
			   	<c:set var="email" value="${tourguide.email }"/>
			   	<c:set var="address" value="${tourguide.address }"/>
			
			<div id="p"><p>Welcome <br> ${tourguide.name} </p></div>

            <table>

                <tr>
                    <td id="td">Tour guide id</td>
                    <td id="td">${tourguide.id}</td>
                </tr>

                <tr>
                    <td>Username</td>
                    <td>${tourguide.name}</td>
                </tr>

                <tr>
                    <td id="td">Phone</td>
                    <td id="td">${tourguide.phone}</td>
                </tr>

                <tr>
                    <td>Email</td>
                    <td>${tourguide.email}</td>
                </tr>

                <tr>
                    <td id="td">Address</td>
                    <td id="td">${tourguide.address}</td>
                </tr>
            </table>
	        
	        </c:forEach>
	        
	        <div id="buttons">
	        
	        <c:url value="TourGuideUpdate.jsp" var="tourUpdate">
		    
		   		<c:param name="id" value="${id }"/>
		   		<c:param name="name" value="${name }"/>
		   		<c:param name="pass" value="${password }"/>
		   		<c:param name="phone" value="${phone }"/>
		   		<c:param name="email" value="${email }"/>
		   		<c:param name="address" value="${address }"/>
			</c:url> 
			
		    <a href="${tourUpdate }">
		    	<input type="submit" value="Update" id="update">
		    </a>
	
        
        <c:url value="deleteTourGuide.jsp" var="tourDelete">
		    
		   	<c:param name="id" value="${id }"/>
		   	<c:param name="name" value="${name }"/>
		   	<c:param name="pass" value="${password }"/>
		   	<c:param name="phone" value="${phone }"/>
		   	<c:param name="email" value="${email }"/>
		   	<c:param name="address" value="${address }"/>
		</c:url> 
		<a href="${tourDelete}">
			<input type="button" value="Delete" id="delete">	
		</a>
		 
		<form action="recievedToursServlet" method="post">
			<input type="submit" value="Received Tours" id="tours">
		</form>
		</div>
    </div>
	
</body>
</html>