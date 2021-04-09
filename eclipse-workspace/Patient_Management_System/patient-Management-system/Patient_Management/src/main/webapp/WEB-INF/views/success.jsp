<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC File Upload Example</title>
<style type="text/css">
#fileUploadDiv {
	text-align: center;
	padding-top: 16px;
}

#fileUploadFormPage {
	text-decoration: none;
	text-align: center;
	cursor: pointer;
}

#successMessage {
	text-align: center;
	color: #008CBA;
	font-size: 35px;
	padding-top: 17px;
}

#payFee {
	text-align: center;
	font-size: 25px;
	width: 200px;
	color: Red;
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
	float:left;
}

.icon2 {
	height: 100px;
	width: 200px;
	border-radius: 50%;
	float: right;
}

.btn {
	background-color: #008CBA;
	color: white;
}
</style>
</head>
<body>
	<header> <a
		href="http://localhost:8080/Patient_Management/main"><img
		src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a> <a
		href="http://localhost:8080/Patient_Management/"><img
		src="image/BcHospital.png" class="icon2" /></a> </header><br/><br/><br/><br/><br/>
	<center>
		<h2>We Received your Additional Documents</h2>

		<div id="successMessage">
			<strong>${messageObj}</strong>
		</div>
		<div id="fileUploadDiv">
			<a id="fileUploadFormPage" href="fileupload">Go To File Upload
				Form Page</a>
		</div>
		<br />
		<div id="payFee">
			<a href="http://localhost:8080/Patient_Management/pay"><input
				type="submit" value="Pay Fee" class="btn" /></a>
		</div>
	</center>
</body>
</html>