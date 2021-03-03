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

</head>
<body>
	<div class="container">
		
			<h1>Edit Patient - ${patient.id}</h1>
			<hr />

		<h3>Edit Patient</h3>
			
						<form:form action="${pageContext.request.contextPath}/editPatient" cssClass="form-horizontal"
						method="post" modelAttribute="patient">

						<div class="form-group">
						<label for="id" class="col-md-3 control-label">Health Card Number</label>
							<div class="col-md-9">
								<form:input path="id" value="${patient.id}" cssClass="form-control" readonly="true" />
							</div>
							<label for="firstname" class="col-md-3 control-label">First Name</label>
							<div class="col-md-9">
								<form:input path="firstname" value="${patient.firstname}" cssClass="form-control" />
							</div>
							<label for="lastname" class="col-md-3 control-label">Last Name</label>
							<div class="col-md-9">
								<form:input path="lastname" value="${patient.lastname}" cssClass="form-control" />
							</div>
							<label for="sex" class="col-md-3 control-label">sex</label>
							<div class="col-md-9">
								<form:input path="sex" value="${patient.sex}" cssClass="form-control" readonly="true"/>
							</div>
							<label for="birthDay" class="col-md-3 control-label">Birthday</label>
							<div class="col-md-9">
								<form:input path="birthDay" value="${patient.birthDay}" cssClass="form-control" />
							</div>
							<label for="email" class="col-md-3 control-label">E mail</label>
							<div class="col-md-9">
								<form:input path="email" value="${patient.email}" cssClass="form-control" />
							</div>
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<form:input path="password" value="${patient.password}" cssClass="form-control" />
							</div>
							
							<label for="telephone" class="col-md-3 control-label">Telephone</label>
							<div class="col-md-9">
								<form:input path="telephone" value="${patient.telephone}" cssClass="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
			
		</div>
		


</body>
</html>
