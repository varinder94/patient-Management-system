<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient Login Form</title>
<style>
html{
height:100%;
}
body {
	background-image: url("image/back1.jpg");
	background-repeat: no-repeat;
	height: 90%;
	background-position: center;
	background-size: cover;
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
	float:right;
}
</style>
</head>
<body>
	<header>
		<a href="http://localhost:8080/Patient_Management/main"><img
			src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a>
			<a href="http://localhost:8080/Patient_Management/"><img src="image/BcHospital.png" class="icon2"/></a>
	</header>
	<form:form name="submitForm" method="POST">
		<div align="center">
			<table>
			<tr> <img src="image/logo1.png"/></tr><br/><br/>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr><br/>
				<tr>
					<td></td><br/>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			
			</table>
			

		</div>
	</form:form>
	
</body>
</html>
