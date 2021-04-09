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
				<h2>Submitted Treatment Details</h2>
			</td>
		</tr>

		<tr>
			<td> Patient's First Name:</td>
			<td>${treats.patientFirstName}</td>
		</tr>
		<tr>
			<td> Patient's Last Name:</td>
			<td>${treats.patientLastName}</td>
		</tr>
		<tr>
			<td>Prescribed Medicine</td>
			<td>${treats.patientMedicine}</td>
		</tr>
		<tr>
			<td>Prescribed Allargies</td>
			<td>${treats.patientAlleries}</td>
		</tr>
		<tr>
			<td>Medicine Dose</td>
			<td>${treats.medicinedoses}</td>
		</tr>
		<tr>
			<td>Special Note</td>
			<td>${treats.specialNote}</td>
		</tr>
		
		<tr>
		<td>Returnn to home page</td>
				<td><a
					href="http://localhost:8080/Patient_Management/doctorLogin"><input type="submit"
					value="Back">
						</a><br/><br/></td>
		</tr>
				
	</table>
	
</body>
</html>

