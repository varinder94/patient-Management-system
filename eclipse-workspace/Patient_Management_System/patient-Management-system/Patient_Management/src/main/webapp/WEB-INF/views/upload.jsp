<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Multiple File Request Page</title>
</head>
<body>

	<form:form method="POST"
		action="http://localhost:8080/Patient_Management/booking"
		enctype="multipart/form-data">

		<table class="form">
			<tr>
				<td><h1>Booking Form</h1></td>
			</tr>
			<tr>
				<td><label> Health Card Number</label></td>
				<td><input type="number" name="id" id="id" /></td>
			</tr>
			<tr>
				<td><label> First Name</label></td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><label> Last Name</label></td>
				<td><input type="text" name="last" id="last" /></td>
			</tr>
			<tr>
				<td>Booking Date</td>
				<td><input type="date" name="dateP" id="dateP" /></td>
			</tr>
			<tr>
				<td><label for="timeP">Booking Time</label></td>
				<td><input type="time" name="timeP" id="timeP" min="09:00"
					max="18:00" required /></td>
			</tr>
			<tr>
				<td>Select a Doctor</td>
				<td><select name="doctor" id="doctor">
						<option value="Dr.shegal-Heart Specialist">Dr.shegal-Heart
							Specialist</option>
						<option value="Dr.Desai- General Checkup">Dr.Desai-
							General Checkup</option>
						<option value="Dr.singh-Flu checkup">Dr.singh-Flu checkup</option>
						<option value="Mr.desousa- Eye Checkup">Mr.desousa- Eye
							Checkup</option>
				</select></td>
			</tr>

			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="file" id="file" /></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
