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
			<td>${books.id}</td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td>${books.name}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${books.last}</td>
		</tr>
		<tr>
			<td>Booking Date and Time</td>
			<td>${books.dateP}</td>
		</tr>
		<tr>
			<td>Booking Time</td>
			<td>${books.timeP}</td>
		</tr>
		<tr>
			<td>Document Attached:</td>
			<td>${books.file.originalFilename}</td>
		</tr>
		<tr>
			<td>Document AttachedType:</td>
			<td>${books.file.contentType}</td>
		</tr>
		<tr>
			<td>Booking Doctor</td>
			<td>${books.doctor}</td>
		</tr>

	</table>

</body>
</html>
