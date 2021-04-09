<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC File Upload Example</title>
<style type="text/css">
#errorMessage {
	text-align: center;
	font-size: 25px;
	padding-top: 17px;
}

#errorMessage span {
	color: red;
}

html {
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
	float: right;
}
</style>
</head>

<body>
	<header> <a
		href="http://localhost:8080/Patient_Management/main"><img
		src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a> <a
		href="http://localhost:8080/Patient_Management/"><img
		src="image/BcHospital.png" class="icon2" /></a> </header>
	<center>
		<h2>Server Down</h2>
	</center>
	<br />
	<br />
	<div id="errorMessage">
		<strong>Sorry, There is a problem At the back end now the
			booking Process cannot be complete</strong> <span id="exceptionTrace">${exception.message}</span>
	</div>
</body>
</html>