<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<html>
<head>
<style>
html {
	height: 100%;
	margin: auto;
}

body {
	background-image: url("image/back1.jpg");
	background-repeat: no-repeat;
	height: 90%;
	background-position: center;
	background-size: cover;
}

.form {
	margin: auto;
}
</style>
</head>
<body>


	<table class="form">
		<tr>
			<td>
				<h2>Submitted Details</h2>
			</td>
		</tr>
		<tr>
			<td>Health Card Number:</td>
			<td>${booking.id}</td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td>${booking.name}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${booking.last}</td>
		</tr>
		<tr>
			<td>Booking Date and Time</td>
			<td>${booking.dateP}</td>
		</tr>

		<tr>
			<td>Booking Time</td>
			<td>${booking.timeP}</td>
		</tr>
		<tr>
			<td>Booking Doctor</td>
			<td>${booking.doctor}</td>
		</tr>
		<tr>
			<td>Document Attached:</td>
			<td>${booking.file.originalFilename}</td>
		</tr>
		<tr>
			<td>Document AttachedType:</td>
			<td>${booking.file.contentType}</td>
		</tr>
		<tr></tr>
	</table>

</body>
</html>
