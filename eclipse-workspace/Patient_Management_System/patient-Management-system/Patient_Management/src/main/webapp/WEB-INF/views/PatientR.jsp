<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
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

.login {
	border-radius: 50%;
	width: 300px;
	height: 400px;
	float: right;
}

.form-horizontal {
	width: 500px;
	float: right;
	background-position: center;
}

.icon {
	height: 80px;
	width: 100px;
	border-radius: 50%;
}
.icon2 {
	height: 100px;
	width: 250px;
	border-radius: 50%;
	float:right;
}
</style>
</head>



<body>
	<header>
		<a href="http://localhost:8080/Patient_Management/main"><img
			src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a>
		<a href="http://localhost:8080/Patient_Management/"><img src="image/BcHospital.png" class="icon2"/></a>
	</header>
	<a href="http://localhost:8080/Patient_Management/patientlogin"><img
		src="image/Login.jpg" class="login" alt="Login" /></a>


	<form:form action="${pageContext.request.contextPath}/register/"
		cssClass="form-horizontal" method="post" modelAttribute="patients">
		<h2>Patient Registration form</h2>
		<div class="form-group">
			<label for="firstname" class="col-md-3 control-label">First
				Name</label>
			<div class="col-md-9">
				<form:input path="firstname" cssClass="form-control" />
			</div>
		</div><br/>

		<div class="form-group">
			<label for="lastname" class="col-md-3 control-label">Last
				Name</label>
			<div class="col-md-9">
				<form:input path="lastname" cssClass="form-control" />
			</div>
		</div>
		<br/>
		<div class="form-group">
			<label for="id" class="col-md-3 control-label"> Health Card
				Number</label>
			<div class="col-md-9">
				<form:input path="id" cssClass="form-control" />
			</div>
		</div>
		<br/>
		<div class="form-group">
			<label for="email" class="col-md-3 control-label">E-mail</label>
			<div class="col-md-9">
				<form:input path="email" cssClass="form-control" />
			</div>
		</div>
		<br/>
		<div class="form-group">
			<label for="password" class="col-md-3 control-label">Password</label>
			<div class="col-md-9">
				<form:input path="password" cssClass="form-control" />
			</div>
		</div>
<br/>
		<div class="form-group">
			<label for="sex" class="col-md-3 control-label">Sex</label>
			<form:radiobutton path="sex" value="Male" />
			Male
			<form:radiobutton path="sex" value="Female" />
			Female
			<form:errors path="sex" style="color:red" />
		</div>
<br/>
		<div class="form-group">
			<label>Date of birth</label><br/>
			<form:input type="date" path="birthDay" id="birthDay" />
			<form:errors path="birthDay" style="color:red" />
		</div>
<br/>
		<div class="form-group">
			<label for="telephone" class="col-md-3 control-label">Phone
				Number</label>
			<div class="col-md-9">
				<form:input path="telephone" cssClass="form-control" />
			</div>
		</div>
<br/>

		<div class="form-group">
			<!-- Button -->
			<div class="col-md-9">
				<form:button cssClass="btn btn-primary">Submit</form:button>
			</div>
		</div>
	</form:form>

</body>
</html>