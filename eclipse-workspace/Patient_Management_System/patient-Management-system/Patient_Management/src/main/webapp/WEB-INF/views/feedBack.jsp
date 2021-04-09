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
	text-align:center;
}

.icon {
	height: 80px;
	width: 100px;
	border-radius: 50%;
	float: left;
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

a {
	text-decoration: none;
}

.form {
	padding-left: 200px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Treatment report Page</title>
</head>
<body>
	<header>
		<a href="http://localhost:8080/Patient_Management/main"><img
			src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a> <a
			href="http://localhost:8080/Patient_Management/"><img
			src="image/BcHospital.png" class="icon2" /></a>
	</header>
	<br />
	<br />
	<br />
	<br />
	<form:form method="POST"
		action="http://localhost:8080/Patient_Management/feedback"
		enctype="multipart/form-data">

		<table class="form">
			<tr>
				<td><h1>Feedback Form</h1></td>
			</tr>
			<tr>

			</tr>
			<tr>
				<td><label>your First name</label></td>
				<td><input type="text" name="name" id="name" /><br /> <br /></td>
			</tr>
			<tr>
				<td><label>your last Name</label></td>
				<td><input type="text" name="last" id="last" /><br /> <br /></td>
			</tr>
			<tr>
				<td>Select Doctor's Name</td>
				<td><select name="doctor" id="doctor">
						<option value="Dr.shegal-Heart Specialist">Dr.shegal-Heart
							Specialist</option>
						<option value="Dr.Desai- General Checkup">Dr.Desai-
							General Checkup</option>
						<option value="Dr.singh-Flu checkup">Dr.singh-Flu checkup</option>
						<option value="Mr.desousa- Eye Checkup">Mr.desousa- Eye
							Checkup</option>
				</select><br /> <br /></td>
			</tr>
			<tr>
				<td>Pick your feeling toward doctor</td>
				<td><input type="checkbox" id="goodPoint" name="goodPoint"
					value="Time-bound"> <label for="goodPoint">
						Time-bound</label><br> <input type="checkbox" id="goodPoint"
					name="goodPoint" value="Friendly"> <label for="goodPoint">Friendly</label><br>
					<input type="checkbox" id="goodPoint" name="goodPoint"
					value="Good knowledge"> <label for="goodPoint">Good
						knowledge</label><br> <input type="checkbox" id="goodPoint"
					name="goodPoint" value="Treated well"> <label
					for="goodPoint">Treated well</label><br> <br></td>
			</tr>

			<tr>
				<td>Rate Your Experience</td>
				<td><input type="range" name="rating" id="rating" min=1 max=5></td>
			</tr>
			<tr>
				<td>How's Your Experience</td>
				<td><input type="radio" name="experience" value="Excellent">Excellent
					<input type="radio" name="experience" value="Very Good">Very
					Good <input type="radio" name="experience" value="Good">Good
					<input type="radio" name="experience" value="Average">Average
					<input type="radio" name="experience" value="Poor">Poor</td>
			</tr>
			<tr>
				<td>Any Recommendation</td>
				<td><input type="text" name="suggestions" id="suggestions" /><br />
					<br /></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Submit Response" class="btn" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>
