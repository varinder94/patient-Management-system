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
	</header><br/><br/><br/><br/>
	<form:form method="POST"
		action="http://localhost:8080/Patient_Management/treatment"
		enctype="multipart/form-data">

		<table class="form">
			<tr>
				<td><h1>Treatment Report Form</h1></td>
			</tr>
			<tr>

			</tr>
			<tr>
				<td><label>Patient's First Name</label></td>
				<td><input type="text" name="patientFirstName"
					id="patientFirstName" /><br /> <br /></td>
			</tr>
			<tr>
				<td><label>Patient's Last Name</label></td>
				<td><input type="text" name="patientLastName"
					id="patientLastName" /><br /> <br /></td>
			</tr>
			<tr>
				<td>Select a Medicine</td>
				<td><select name="patientMedicine" id="patientMedicine">
						<option value="Alendronate">Alendronate</option>
						<option value="Busulfan">Busulfan</option>
						<option value="Calcium">Calcium</option>
						<option value="Clarithromycin">Clarithromycin</option>
						<option value="Clobazam">Clobazam</option>
						<option value="Crizotinib">Crizotinib</option>
						<option value="Busulfan">Busulfan</option>
						<option value="Calcium">Calcium</option>
						<option value="Clarithromycin">Clarithromycin</option>
						<option value="Daunorubicin">Daunorubicin</option>
						<option value="Etoposide">Etoposide</option>
						<option value="Erlotinib">Erlotinib</option>
						<option value="Famotidine">Famotidine</option>
						<option value="Foscarnet">Foscarnet</option>
						<option value="Ganciclovir">Ganciclovir</option>
						<option value="Hydrocortisone">Hydrocortisone</option>
						<option value="Immune globulin">Immune globulin</option>
						<option value="Lomustine">Lomustine</option>
						<option value="Tacrolimus">Tacrolimus</option>
						<option value="Vancomycin">Vancomycin</option>
						<option value="Warfarin">Warfarin</option>
						<option value="Zidovudine">Zidovudine</option>
						<option value="Zidovudine / Lamivudine">Zidovudine /
							Lamivudine</option>
				</select><br /> <br /></td>
			</tr>
			<tr>
				<td>Allergies</td>
				<td><input type="checkbox" id="patientAlleries"
					name="patientAlleries" value="diary Products"> <label
					for="patientAlleries"> diary Products</label><br> <input
					type="checkbox" id="patientAlleries" name="patientAlleries"
					value="Dust"> <label for="patientAlleries"> Dust</label><br>
					<input type="checkbox" id="patientAlleries" name="patientAlleries"
					value="Peanutss"> <label for="patientAlleries">
						Peanuts</label><br> <input type="checkbox" id="patientAlleries"
					name="patientAlleries" value="Raw Fruits and Vegetables"> <label
					for="patientAlleries"> Raw Fruits and Vegetables</label><br> <input
					type="checkbox" id="patientAlleries" name="patientAlleries"
					value="Sesame Seeds"> <label for="patientAlleries">
						Sesame Seeds</label><br> <input type="checkbox" id="patientAlleries"
					name="patientAlleries" value="Wheat"> <label
					for="patientAlleries"> Wheat</label><br> <input
					type="checkbox" id="patientAlleries" name="patientAlleries"
					value="shellfish"> <label for="patientAlleries">
						shellfish</label><br> <input type="checkbox" id="patientAlleries"
					name="patientAlleries" value="Tree Nuts"> <label
					for="patientAlleries"> Tree Nuts</label><br> <br></td>
			</tr>

			<tr>
				<td>Medicine Dose</td>
				<td><input type="range" name="medicinedoses" id="medicinedoses"
					min=1 max=5></td>
			</tr>
			<tr>
				<td>Special Note</td>
				<td><input type="text" name="specialNote" id="specialNote" /><br />
					<br /></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Confirm Report"
					class="btn" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>
