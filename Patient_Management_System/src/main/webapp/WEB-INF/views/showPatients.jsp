<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Students</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
<style type="text/css">
html {
	height: 100%;
}

body {
	background-image: url("image/back1.jpg");
	background-repeat: no-repeat;

	background-position: center;
	background-size: cover;
}
.form-horizontal {
	width: 500px;
	background-position: center;
}
.Patient_data{
	width: 500px;
	float:right;
	background-position: center;
}

</style>
</head>
<body>
	<div class="container">

		
		<hr />
		<c:if test="${ message !=null }">
			<div class="Patient_data" role="alert">${message}</div>
		</c:if>
		<table class="patient table">
          <tr><td><h1>Patient List</h1></td></tr>
			<tr>
				<td>Health Card Number</td>
				<td>First name</td>
				<td>Last Name</td>
				<td>sex</td>
				<td>BirthDay</td>
				<td>Email</td>
				<td>Password</td>
				<td>Telephone</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach var="patient" items="${PatientList}">
				<tr>
					<td>${patient.id}</td>
					<td>${patient.firstname}</td>
					<td>${patient.lastname}</td>
					<td>${patient.sex}</td>
					<td>${patient.birthDay}</td>
					<td>${patient.email}</td>
					<td>${patient.password}</td>
					<td>${patient.telephone}</td>

					<td><a
						href="${pageContext.request.contextPath}/editPatient/?id=${patient.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deletePatient/?id=${patient.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
	
		<form:form action="${pageContext.request.contextPath}/createPatient/"
			cssClass="form-horizontal" method="post" modelAttribute="patient">
			<h2>New Patient Form</h2>
			<div class="form-group">
				<label for="id" class="col-md-3 controllabel">Health card
					Number</label>
				<div class="col-md-9">
					<form:input path="id" type="number" cssClass="form-control" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label for="firstname" class="col-md-3 controllabel">First
					Name</label>
				<div class="col-md-9">
					<form:input path="firstname" type="text" cssClass="form-control" />
				</div>
			</div>
			<br />

			<div class="form-group">
				<label for="lastname" class="col-md-3 controllabel">Last
					Name</label>
				<div class="col-md-9">
					<form:input path="lastname" type="text" cssClass="form-control" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label for="sex" class="col-md-3 control-label">Sex</label>
				<form:radiobutton path="sex" value="Male" />
				Male
				<form:radiobutton path="sex" value="Female" />
				Female
				<form:errors path="sex" style="color:red" />
			</div>
			<br />
			<div class="form-group">
				<label>Date of birth</label><br />
				<form:input type="date" path="birthDay" id="birthDay" />
				<form:errors path="birthDay" style="color:red" />
			</div>
			<br />
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email</label>
				<div class="col-md-9">
					<form:input path="email" type="email" placeholder="abc@gmail.com"
						cssClass="form-control" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label for="password" class="col-md-3 controllabel">Password</label>
				<div class="col-md-9">
					<form:input path="password" type="password" placeholder=" "
						cssClass="form-control" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label for="telephone" class="col-md-3 controllabel">Telephone</label>
				<div class="col-md-9">
					<form:input path="telephone" type="number" cssClass="form-control" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Submit</form:button>
				</div>
			</div>
		</form:form>



	</div>
</body>
</html>