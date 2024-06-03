<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" href="CSS/tourGuide.css">
    <link rel="stylesheet" href="CSS/home.css">
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

	 <h1 id="topic">Tour Guide Login</h1>
     <form action="loginServlet" method="post">
     
         <p>Username:</p>
         <input type="text" name="name" required placeholder="someone">
         
         <p>Password:</p>
         <input type="password" name="pass" required placeholder="password" id="pass">
         
         <input type="submit" value="Login" id="submit">
          
     </form>
 
     <p id="p">Are you new ?</p><a href="register.jsp" id="a"><button>Register Here</button></a>
     
</body>
</html>