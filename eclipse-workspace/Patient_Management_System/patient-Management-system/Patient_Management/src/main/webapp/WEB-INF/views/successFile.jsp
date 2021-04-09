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

.icon {
	height: 80px;
	width: 100px;
	border-radius: 50%;
}

.icon2 {
	height: 100px;
	width: 200px;
	border-radius: 50%;
	float: right;
}
.btn{
background-color:#008CBA;
color:white;
}
</style>
</head>
<body>
	<header>
		<a href="http://localhost:8080/Patient_Management/main"><img
			src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a> <a
			href="http://localhost:8080/Patient_Management/"><img
			src="image/BcHospital.png" class="icon2" /></a>
	</header>

	<table class="form">
		<tr style="text-align:center;">
			<td>
				<h2>Submitted Details</h2>
			</td>
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
		<tr>
			<td>Additional documents(such as medical history etc.)</td>
			<td><a
				href="http://localhost:8080/Patient_Management/fileupload"><input
					type="submit" value="Submit additional documents" class="btn"> </a><br />
			<br /></td>
		</tr>

	</table>

</body>
</html>

