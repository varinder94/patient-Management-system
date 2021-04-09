<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Feedback</title>
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

. Report_data { width : 500px;
	float: right;
	background-position: center;
}
h1{padding-left:550px;}
.FeedbackTable{
padding-left:350px;}
tr,td{padding:10px;}
</style>
</head>
<body>
	<div class="container">

		<c:if test="${ message !=null }">
			<div class=feedback_data role="alert">${message}</div>
		</c:if>
		<h1>feedback Reports</h1>
		<table class="FeedbackTable">
			
			<tr>



				<td>First Name</td>
				<td>Last Name</td>
				<td>Doctor</td>
				<td>Good Points</td>
				<td>Ratings</td>
				<td>Experiences</td>
				<td>Suggestions</td>

			</tr>
			<c:forEach var="feeds" items="${feedList}">
				<tr>
					<td>${feeds.name}</td>
					<td>${feeds.last}</td>
					<td>${feeds.doctor}</td>
					<td>${feeds.goodPoint}</td>
					<td>${feeds.rating}</td>
					<td>${feeds.experience}</td>
					<td>${feeds.suggestions}</td>


				</tr>
			</c:forEach>
		</table>


	</div>


	
</body>
</html>