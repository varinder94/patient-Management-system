<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Receipt</title>
<style type="text/css">
table {
	border: 0;
}

table td {
	padding: 5px;
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

.btn {
	background-color: #008CBA;
	color: white;
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
	<div align="center">
		<h1>Payment Done. Thank you for Booking Appointment In our
			Hospital</h1>
		<br />
		<h2>Receipt Details:</h2>
		<table>
			<tr>
				<td><b>Hospital Name:</b></td>
				<td>BC Hospital</td>
			</tr>
			<tr>
				<td><b>Payer:</b></td>
				<td>${payer.firstName}${payer.lastName}</td>
			</tr>

			<tr>
				<td><b>Subtotal:</b></td>
				<td>${transaction.amount.details.subtotal}CAD</td>
			</tr>

			<tr>
				<td><b>Tax:</b></td>
				<td>${transaction.amount.details.tax}CAD</td>
			</tr>
			<tr>
				<td><b>Total:</b></td>
				<td>${transaction.amount.total}CAD</td>
			</tr>
		</table>
	</div>
</body>
</html>
