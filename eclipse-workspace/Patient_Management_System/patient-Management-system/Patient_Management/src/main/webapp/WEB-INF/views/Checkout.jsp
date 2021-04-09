<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Check Out</title>
<style type="text/css">
table {
	border: 0;
}

table td {
	padding: 10px;
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
		<h1>Process Booking Payment</h1>
		<br />
		<form action="authorize_payment" method="post">
			<table>
				<tr>
					<td>Service:</td>
					<td><input type="text" name="Service" value="Booking Fee" /></td>
				</tr>
				<tr>
					<td>Sub Total:</td>
					<td><input type="text" name="subtotal" value="100" /></td>
				</tr>

				<tr>
					<td>Tax:</td>
					<td><input type="text" name="tax" value="10" /></td>
				</tr>
				<tr>
					<td>Total Amount:</td>
					<td><input type="text" name="total" value="110" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Process Payment" class="btn"  /><i class="fa fa-paypal"  style="font-size:16px;color: #253B80; ">PayPal</i></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>