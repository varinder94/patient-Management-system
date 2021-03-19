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
	background-position: center; . Doctor_data { width : 500px;
	float: right;
	background-position: center;
}
</style>
</head>
<body>
	<div class="container">


		<hr />
		<c:if test="${ message !=null }">
			<div class="Doctor_data" role="alert">${message}</div>
		</c:if>
		<table class="Doctor_table">
			<tr>
				<td><h1>Available Doctors List</h1></td>
			</tr>
			<tr>

				<td>ID</td>
				<td>First name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Password</td>
				<td>Gender</td>
				<td>Specialization</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach var="doctor" items="${doctList}">
				<tr>
					<td>${doctor.id}</td>
					<td>${doctor.firstName}</td>
					<td>${doctor.lastName}</td>
					<td>${doctor.email}</td>
					<td>${doctor.password}</td>
					<td>${doctor.sex}</td>
					<td>${doctor.specialization}</td>

					<td><a
						href="${pageContext.request.contextPath}/editDoctors/?id=${doctor.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteDoctors/?id=${doctor.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <br />
		<form:form action="${pageContext.request.contextPath}/showDoctors/"
			cssClass="form-horizontal" method="post" modelAttribute="doctor">
			<h2>Doctor Form</h2>
			<div class="form-group">
				<label for="id" class="col-md-3 controllabel">Doctor Id</label>
				<div class="col-md-9">
					<form:input path="id" type="number" cssClass="form-control" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label for="firstName" class="col-md-3 controllabel">First
					Name</label>
				<div class="col-md-9">
					<form:input path="firstName" type="text" cssClass="form-control" />
				</div>
			</div>
			<br />

			<div class="form-group">
				<label for="lastName" class="col-md-3 controllabel">Last
					Name</label>
				<div class="col-md-9">
					<form:input path="lastName" type="text" cssClass="form-control" />
				</div>
			</div>
			<br />

			<br />
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email</label>
				<div class="col-md-9">
					<form:input path="email" type="email" placeholder="xyz@gmail.com"
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
				<label for="sex" class="col-md-3 control-label">Sex</label>
				<form:radiobutton path="sex" value="Male" />
				Male
				<form:radiobutton path="sex" value="Female" />
				Female
				<form:errors path="sex" style="color:red" />
			</div>
			<div class="form-group">
				<label for="specialization" class="col-md-3 controllabel">specialization</label>
				<div class="col-md-9">
					Heart
					<form:checkbox path="specialization" value="Heart" />
					Brain
					<form:checkbox path="specialization" value="Brain" />
					kidney
					<form:checkbox path="specialization" value="kidney" />
					Flu
					<form:checkbox path="specialization" value="Flu" />
					General Health
					<form:checkbox path="specialization" value="General Health" />

					<br>
					<br>
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