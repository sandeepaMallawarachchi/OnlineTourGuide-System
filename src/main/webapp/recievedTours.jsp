<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Received Tours</title>
    <link rel="stylesheet" href="CSS/home.css">
    <link rel="stylesheet" href="CSS/recievedTours.css">
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

    <div id="details">

        <table>

            <tr>
                <th id="th">Tour type</th>
                <th id="th">Destination</th>
                <th id="date">Date</th>
                <th id="de">Details</th>
                <th id="th">Action</th>
            </tr>

            <c:forEach var="recievedTours" items="${recieved}">
                <tr>
                    <td>${recievedTours.type}</td>
                    <td>${recievedTours.destination}</td>
                    <td>${recievedTours.date}</td>
                    <td>${recievedTours.details}</td>
                    <td>
                        <form action="acceptToursServlet" method="post">
                            <input type="text" name="id" value="${recievedTours.id}" hidden>
                            <input type="submit" value="Accept" id="accept${recievedTours.id}" class="accept">
                        </form>

                        <form action="rejectToursServlet" method="post">
                            <input type="text" name="id" value="${recievedTours.id}" hidden>
                            <input type="submit" value="Reject" id="reject${recievedTours.id}" class="reject">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script>
        function acceptTour(tourId) {
            alert("Tour accepted with ID: " + tourId);
        }

        function rejectTour(tourId) {
            alert("Tour rejected with ID: " + tourId);
        }
    </script>
</body>

</html>
