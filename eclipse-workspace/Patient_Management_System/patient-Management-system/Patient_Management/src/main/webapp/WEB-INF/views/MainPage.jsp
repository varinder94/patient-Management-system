<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
* {
  box-sizing: border-box;
}
body{
background-image:url("image/background.png");
}
.column {
  float: left;
  width: 23.33%;
  padding: 5px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}
img {
  border-radius: 50%;
  display: block;
  margin-left: auto;
  margin-right: auto;
   margin-top: 50px;
}
.back{

  background-image: url("image/background.png");

 
  height: 90%; 

  
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

h4 {text-align: center;}
p {text-align: center;}
div {text-align: center;}

</style>
<title>Patient Management</title>
</head>
<body class="back">
<h1></h1>
	<div class="row">
 <h1>Please select the appropirate role to proceed further</h1>
  <div class="column">
  <figure>
  <a href="http://localhost:8080/Patient_Management/register">
  <img src="<spring:url value="/image/Patienticon.png"/>" alt="Avatar" style="width:200px" height="200px"></a>
  <br/>
  <figcaption>Patient access</figcaption>
    </figure>
  </div>
  <div class="column">
  <figure>
  <a href="http://localhost:8080/Patient_Management/adminlogin">
  <img src="<spring:url value="/image/MedicalSymbol.png"/>" alt="Avatar" style="width:200px" height="200px"></a>
  <br/>
  <figcaption>Management access</figcaption>
  </figure>
  </div>
 <div class="column">
  <figure>
  <a href="http://localhost:8080/Patient_Management/register">
  <img src="<spring:url value="/image/doctorIcon.png"/>" alt="Avatar" style="width:200px" height="200px"></a>
  <br/>
  <figcaption>Doctor access</figcaption>
    </figure>
  </div>
 
</div>
</body>
</html>