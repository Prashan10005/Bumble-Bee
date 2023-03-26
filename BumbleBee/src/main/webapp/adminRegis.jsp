<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN REGISTRATION PAGE</title>
</head>
<body style="background-image:url(login.jpg); ">
	<div align="center">
	<div style="padding:4%">
	<div style=" width:500px; height:500px;  border: 2px solid black;">	
			<h1> WELCOME TO BUMBLEBEE</h1>
			<p>Admin Registration Form</p>
			
	<form name="form" action="adminRegis" method="post">
		<table>
			<tr><td>First Name</td><td><input style="height:20px; width:250px;" type="text" name="fName" id="fName" required></td></tr> 			
			<tr><td>Last Name</td><td><input style="height:20px; width:250px;" type="text" name="lName" id="lName" required></td></tr>
			<tr><td>NIC</td><td><input style="height:20px; width:250px;" type="text" name="nic" id="nic" required></td></tr>			
			<tr><td>Email</td><td><input style="height:20px; width:250px;"type="email" name="email" id="email" required></td></tr>
			<tr><td>Mobile</td><td><input style="height:20px; width:250px;" type="tel" name="mobile" pattern="[0-9]{10}{>18}" id="mobile" required></td></tr>
			<tr><td>Password</td><td><input style="height:20px; width:250px;" type="password" name="password" id="password" required></td></tr>
		</table>
		<br>
		<p><input style="height:30px; width:150px;" type="submit" value="REGISTER">&nbsp;&nbsp;&nbsp;<input style="height:30px; width:150px;" type="reset" value="RESET">
		<br>
		<br>
		<p> For Register as <a href="register.jsp"> User Sign Up</a>.</p>
		<p> If You Have an Account <a href="Login.jsp"> Sign In</a>.</p>
		</form>
		</div>	
	</div>		
	</div>
</body>
</html>