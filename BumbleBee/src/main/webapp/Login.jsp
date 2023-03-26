<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body style="background-image:url(login.jpg); ">
<form name="form" action="login" method="post">
	<div align="center">
		<div style="padding:8%;">
			<div style="text-align:center; width:500px; height:400px;  border: 2px solid black; ">
			<h1> LOGIN TO BUMBLEBEE</h1>
					
					<br>
					<br>
					<input style="height:20px;" type="text" name="nic" id="nic" placeholder="Enter NIC "required> &nbsp; <span>Username</span>
					<br>
					<br>
					<br>
					<input style="height:25px;" type="password" id="password" name= "password" placeholder="**********" required> &nbsp; <span>Password</span>&nbsp;
					<br>
					<br>
					<br>					
					<input style="height:25px; width:100px"type="submit" value = "Sign In">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input style="height:25px; width:100px" type="reset" value = "Reset" >
					<br>
					<br>
					<p> If You Don't Have an Account <a href="register.jsp"> Sign Up</a>.</p>
			</div>
		</div>
	</div>
</form>
</body>
</html>