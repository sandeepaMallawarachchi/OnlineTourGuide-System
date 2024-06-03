<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Tour guide registration page</title>
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

	<h1 id="topic">Tour Guide Registration</h1>
	<form action="registerServlet" method="post">
	
		<p>Username:</p>
		<input type="text" name="name" required placeholder="someone">
		
		<p>Password:</p>
		<input type="password" name="pass" required placeholder="password" id="pass">
		
		<p>Re-enter password:</p>
		<input type="password" name="repwd" required placeholder="Confirm password" id="repwd">

        <p>Phone:</p>
		<input type="text" name="phone" required minlength="10" maxlength="10" placeholder="+9412...">
		
		<p>Email:</p>
		<input type="email" name="email" required placeholder="someone@gmail.com">
		
		<p>Address:</p>
		
		<textarea name="address" cols="40" rows="5" required placeholder="no12..."></textarea>
		
		<input type="checkbox" required id="check">
		<p id="terms">I agree the terms and conditions</p>
		
		<input type="submit" value="Register" id="submit" onclick="check()">
		
	</form>
	
	<p id="p">If you already have an account </p><a href="Login.jsp" id="a"><button>Login Here</button></a>
	
	<script>

		function check() {
			var pass = document.getElementById("pass").value;
			var repwd = document.getElementById("repwd").value;
	
			if (pass !== repwd) {
				alert("Password not matched!");
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>