<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<style type="text/css">
    table { border: 0; }
    table td { padding: 5px; }
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
.btn {
	background-color: #008CBA;
	color: white;
}
</style>
</head>
<body>
<header>
		<a href="http://localhost:8080/Patient_Management/main"><img
			src="image/HomeIcon.jpg" alt="homeicon" class="icon" /></a> <a
			href="http://localhost:8080/Patient_Management/"><img
			src="image/BcHospital.png" class="icon2" /></a>
	</header>
<div align="center">
    <h1>Please Review Before paying Booking Fee</h1>
    <form action="execute_payment" method="post">
    <table>
        <tr>
            <td colspan="2"><b>Transaction Details:</b></td>
            <td>
                <input type="hidden" name="paymentId" value="${param.paymentId}" />
                <input type="hidden" name="PayerID" value="${param.PayerID}" />
            </td>
        </tr>
        
        <tr>
            <td>Subtotal:</td>
            <td>${transaction.amount.details.subtotal} CAD</td>
        </tr>
        
        <tr>
            <td>Tax:</td>
            <td>${transaction.amount.details.tax} CAD</td>
        </tr>
        <tr>
            <td>Total:</td>
            <td>${transaction.amount.total} CAD</td>
        </tr>
        <tr><td><br/></td></tr>
        <tr>
            <td colspan="2"><b>Patient Information:</b></td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td>${payer.firstName}</td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>${payer.lastName}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${payer.email}</td>
        </tr>
        <tr><td><br/></td></tr>
        <tr>
            <td colspan="2"><b>Patient Address:</b></td>
        </tr>
        <tr>
            <td>Recipient Name:</td>
            <td>${shippingAddress.recipientName}</td>
        </tr>
        <tr>
            <td>Line 1:</td>
            <td>${shippingAddress.line1}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${shippingAddress.city}</td>
        </tr>
        <tr>
            <td>State:</td>
            <td>${shippingAddress.state}</td>
        </tr>
        <tr>
            <td>Country Code:</td>
            <td>${shippingAddress.countryCode}</td>
        </tr>
        <tr>
            <td>Postal Code:</td>
            <td>${shippingAddress.postalCode}</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Pay Now"  class="btn"/>
            </td>
        </tr>    
    </table>
    </form>
</div>
</body>
</html>