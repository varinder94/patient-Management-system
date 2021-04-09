<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	box-sizing: border-box;
}

html {
	background-image: url("image/back1.jpg");
	background-repeat: no-repeat;
	height: 100%;
	background-position: center;
	background-size: cover;
}

.column {
	float: left;
	width: 23.33%;
	padding: 5px;
	
}

/* Clearfix (clear floats) */
.row::after {
	content: "";
	clear: both;
	display: table;
}

.img {
	height: 300px;
	width: 300px;
	border-radius: 50%;
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
}

div {
	text-align: center;
}
.icon {
	height: 80px;
	width: 100px;
	border-radius: 50%;
	float:left;
}

.icon2{
   height: 100px;
	width: 200px;
	border-radius: 50%;
	float:right;
}

</style>
<meta charset="ISO-8859-1">
<title>Patients Dashboard</title>
</head>
<body>
	<header>
		<a href="http://localhost:8080/Patient_Management/main"><img
			src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a>
			<a href="http://localhost:8080/Patient_Management/"><img src="image/BcHospital.png" class="icon2"/></a>
	
	</header>
	
	<div class="row">
		<div class="column">
			<figure>
			
				<a href="http://localhost:8080/Patient_Management/booking"> <img
					src="image/BookingIcon.jpg" class="img" /></a>
				<br />
				<figcaption>Book An AppointMent</figcaption>
			</figure>
		</div>
		<div class="column">
			<figure>
				<a href="http://localhost:8080/Patient_Management/feedback"> <img
					src="image/TreatmentReportIcon.jpg" class="img" /></a>
				<br />
				<figcaption>Provide Feedback</figcaption>
			</figure>

		</div>
	</div>
</body>
</html>