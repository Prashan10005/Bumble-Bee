<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body style="background-image:url(login.jpg); ">
<form name="form" action="resetPassowrd" method="post">
	<div align="center">
		<div style="padding:8%;">
			<div style="text-align:center; width:500px; height:400px;  border: 2px solid black; ">
			<h1> PASSWORD RESET </h1>
					
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
					<input style="height:25px; width:150px"type="submit" value = "Change Password">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input style="height:25px; width:100px" type="reset" value = "Reset" >
					<br>
					<br>
					<p>  <a href="Login.jsp"> To Sign In</a>.</p>
					
			</div>
		</div>
	</div>
</form>
</body>
</html>