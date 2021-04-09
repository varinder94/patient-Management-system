<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Booking</title>
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


	
	.Report_data { width : 500px;
	float: right;
	background-position: center;
}
.ReportTable{
padding-left:250px;
}
h1{padding-left:550px;}
tr,td{
padding:10px;
}
</style>
</head>
<body>
	<div class="container">

		<c:if test="${ message !=null }">
			<div class=Report_data role="alert">${message}</div>
		</c:if>
		<h1>Treatment Reports</h1>
		<table class="ReportTable">
			<tr>
				
			</tr>
			<tr>

	
				
				<td>First Name</td>
				<td>Last Name</td>
				<td>Patient Medicine</td>
				<td>Patient Allergies</td>
				<td>Medicine doses</td>
				<td>Special Note</td>
				
				
			</tr>
			<c:forEach var="treats" items="${TreatList}">
				<tr>
					<td>${treats.patientFirstName}</td>
					<td>${treats.patientLastName}</td>
					<td>${treats.patientMedicine}</td>
					<td>${treats.patientAlleries}</td>
					<td>${treats.medicinedoses}</td>
					<td>${treats.specialNote}</td>
					
					

				</tr>
			</c:forEach>
		</table>
		
			
			</div>
		



	
</body>
</html>