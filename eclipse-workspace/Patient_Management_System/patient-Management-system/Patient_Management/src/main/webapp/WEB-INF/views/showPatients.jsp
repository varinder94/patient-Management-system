<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Students</title>
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

.form-horizontal {
	width: 500px;
	background-position: center;
}

.Patient_data {
	width: 500px;
	float: right;
	background-position: center;
}

.patient_table {
	padding-left: 250px;
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
	background-color: #008CBA;
	border: none;
	border-radius: 20px;
	box-shadow: 0 9px #999;
}

.icon {
	height: 80px;
	width: 100px;
	border-radius: 50%;
	float: left;
}

.icon2 {
	height: 80px;
	width: 200px;
	border-radius: 50%;
	float: right;
}

h1 {
	padding-left: 550px;
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
	<div class="container">


		<c:if test="${ message !=null }">
			<div class="Patient_data" role="alert">${message}</div>
		</c:if>
		<h1 style="color:#008CBA;">Patient List</h1>
		<table class="patient_table">

			<tr>
				<td>Health Card Number</td>
				<td>First name</td>
				<td>Last Name</td>
				<td>sex</td>
				<td>BirthDay</td>
				<td>Email</td>
				<td>Telephone</td>
				<td>Password</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach var="patients" items="${PatientList}">
				<tr>
					<td>${patients.id}</td>
					<td>${patients.firstname}</td>
					<td>${patients.lastname}</td>
					<td>${patients.sex}</td>
					<td>${patients.birthDay}</td>
					<td>${patients.email}</td>
					<td>${patients.password}</td>
					<td>${patients.telephone}</td>

					<td><a
						href="${pageContext.request.contextPath}/editPatient/?id=${patients.id}"
						class="btn">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deletePatient/?id=${patients.id}"
						class="btn">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>