<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Booking</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
<style type="text/css">
html {
	height: 100%;
}

body {
	background-image: url("image/back1.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
}

.
Booking_data {
	width: 500px;
	float: right;
	background-position: center;
}
.BookingTable{
padding-left:250px;
}
tr,td{
border: 4px;
}

.btn {
	display: inline-block;
	padding: 15px 25px;
	font-size: 15px;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	outline: none;
	color: #fff;
	background-color:#008CBA;
	border: none;
	border-radius: 20px;
	box-shadow: 0 9px #999;
}
.head{
padding-left:450px;
}
.header{
padding-bottom:45px;

}
</style>
</head>
<body>
	<div class="container">


		
		<c:if test="${ message !=null }">
			<div class=Booking_data role="alert">${message}</div>
			
		</c:if>
		   <h1 class="head">Booking List</h1>
		<table class="BookingTable">
			<tr>
			<hr />	
			</tr>
			<tr class="header">


				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Booking Date</td>
				<td>Doctor</td>
				<td>Booking Time</td>
				<td>Download Files</td>


			</tr>
			<c:forEach var="books" items="${bookList}">
				<tr>
					<td>${books.id}</td>
					<td>${books.name}</td>
					<td>${books.last}</td>
					<td>${books.dateP}</td>
					<td>${books.doctor}</td>
					<td>${books.timeP}</td>
					<td><a href="download" class="btn"> Documents</a></td>
					<td><a href="download1" class="btn">Image</a></td>

				</tr>
			</c:forEach>
		</table>


	</div>





</body>
</html>