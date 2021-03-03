<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit Doctors</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">

		<h1>Edit Doctor - ${doctor.id}</h1>
		<hr />

		<h3>Edit Patient</h3>

		<form:form action="${pageContext.request.contextPath}/editDoctors"
			cssClass="form-horizontal" method="post" modelAttribute="doctor">

			<div class="form-group">
				<label for="id" class="col-md-3 control-label">Doctor ID</label>
				<div class="col-md-9">
					<form:input path="id" type="number" value="${doctor.id}" cssClass="form-control"
						readonly="true" />
				</div>
				<label for="firstName" class="col-md-3 control-label">First
					Name</label>
				<div class="col-md-9">
					<form:input path="firstName" value="${doctor.firstName}"
						cssClass="form-control" />
				</div>
				<label for="lastName" class="col-md-3 control-label">Last
					Name</label>
				<div class="col-md-9">
					<form:input path="lastName" value="${doctor.lastName}"
						cssClass="form-control" />
				</div>
				<label for="email" class="col-md-3 control-label">Email</label>
				<div class="col-md-9">
					<form:input path="email" value="${doctor.email}"
						cssClass="form-control" readonly="true" />
				</div>
				<label for="password" class="col-md-3 control-label">Password</label>
				<div class="col-md-9">
					<form:input path="password" value="${doctor.password}"
						cssClass="form-control" />
				</div>
				<div class="form-group">
					<label for="sex" class="col-md-3 control-label">Sex</label>
					<form:radiobutton path="sex" value="Male" />
					Male
					<form:radiobutton path="sex" value="Female" />
					Female
					<form:errors path="sex" style="color:red" />
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
