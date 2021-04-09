<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="https://examples.javacodegeeks.com/wp-content/litespeed/localres/ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<title>Spring MVC File Upload Example</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#fileUploadErr").hide();

		// Hide The Error Message When The Attachment Btn Is Clicked.
		$('#pickUpFileAttachment').click(function(eObj) {
			$("#fileUploadErr").hide();
		});

		// Validating Whether The Attachment Is Uploaded Or Not.
		$('#fileUploadBtn').click(function(eObj) {
			var file = $("#pickUpFileAttachment").map(function() {
				return $(this).val().trim() ? true : false;
			}).get();
			if (file.includes(true)) {
				// Do Nothing...!                    
			} else {
				$("#fileUploadErr").css({
					'color' : 'red',
					'font-weight' : 'bold'
				}).show();
				eObj.preventDefault();
			}
		});
	});
</script>
<style type="text/css">
#fileUploadBtn {
	float: left;
	margin-top: 22px;
}

body {
	background-image: url("image/back1.jpg");
	background-repeat: no-repeat;
	height: 90%;
	background-position: center;
	background-size: cover;
}
.icon {
	height: 80px;
	width: 100px;
	border-radius: 50%;
}

.icon2 {
	height: 100px;
	width: 200px;
	border-radius: 50%;
	float: right;
}
.btn{
background-color:#008CBA;
color:white;
}
</style>
</head>
<body>
	<header> <a
		href="http://localhost:8080/Patient_Management/main"><img
		src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a> <a
		href="http://localhost:8080/Patient_Management/"><img
		src="image/BcHospital.png" class="icon2" /></a> </header>
	<center>

		<h2>Please Upload your Medical Supporting Documents</h2>
		<form id="fileUploadForm" method="post" action="uploadFile"
			enctype="multipart/form-data">
			<table id="fileUploadFormBeanTable" border="0" width="80%">
				<tr>
					<td>Description:</td>
					<td><input id="fileDescription" type="text" name="description"
						size="65" /></td>
				</tr>
				<tr>
					<td>Attachment:</td>
					<td><input id="pickUpFileAttachment" type="file"
						name="attachFileObj" size="60" /> <span id="fileUploadErr">Please
							Upload A File!</span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="fileUploadBtn"
						type="submit" value="Upload" class="btn" /></td>
				</tr>
				<tr></tr>
			</table>
		</form>
	</center>
</body>
</html>