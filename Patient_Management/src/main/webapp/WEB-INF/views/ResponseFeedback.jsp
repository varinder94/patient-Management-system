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
				<h2>Feedback response</h2>
			</td>
		</tr>

		<tr>
			<td>First Name:</td>
			<td>${feeds.name}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${feeds.last}</td>
		</tr>
		<tr>
			<td>Doctor </td>
			<td>${feeds.doctor}</td>
		</tr>
		<tr>
			<td>Doctor Rating</td>
			<td>${feeds.rating}</td>
		</tr>
		<tr>
			<td>Service Points:</td>
			<td>${feeds.goodPoint}</td>
		</tr>
		<tr>
			<td>Patient Experience:</td>
			<td>${feeds.experience}</td>
		</tr>
		<tr>
			<td>Patient's valuable suggestions</td>
			<td>${feeds.suggestions}</td>
		</tr>
		
				
	</table>
	
</body>
</html>

