<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER REGISTRATION PAGE</title>
</head>

<script>
function validateemail()  
{  
var x=document.myform.email.value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);  
  return false;  
  }  
}  
</script>

<body style="background-image:url(login.jpg); ">
	<div align="center">
	<div style="padding:4%">
	<div style=" width:500px; height:550px;  border: 2px solid black;">	
			<h1> WELCOME TO BUMBLEBEE</h1>
			<p>User Registration Form</p>
			
	<form name="form" action="regisUser" method="post">
	
		<table>
			<tr><td>First Name</td><td><input style="height:20px; width:250px;" type="text" name="fName" id="fName" required></td></tr> 			
			<tr><td>Last Name</td><td><input style="height:20px; width:250px;" type="text" name="lName" id="lName" required></td></tr>
			<tr><td>NIC</td><td><input style="height:20px; width:250px;" type="text" name="nic" id="nic" required></td></tr>
			<tr><td>Age</td><td><input style="height:20px; width:250px;" type="text" name="age" id="age" required pattern="[0-9]{2}"></td></tr>
			<tr><td>Address</td><td><input style="height:20px; width:250px;" type="text" name="address" id="address" required></td></tr>
			<tr><td>Email</td><td><input style="height:20px; width:250px;"type="email" name="email" id="email" required></td></tr>
			<tr><td>Mobile</td><td><input style="height:20px; width:250px;" type="tel" name="mobile" pattern="[0-9]{10}" id="mobile" required></td></tr>
			<tr><td>Password</td><td><input style="height:20px; width:250px;" type="password" name="password" id="password" required></td></tr>
		</table>
		<br>
		<p><input style="height:30px; width:150px;" type="submit" value="REGISTER">&nbsp;&nbsp;&nbsp;<input style="height:30px; width:150px;" type="reset" value="RESET">
		<br>
		<p> For Register as <a href="adminRegis.jsp"> Admin Sign Up</a>.</p>
		<p> If You Have an Account <a href="Login.jsp"> Sign In</a>.</p>
		</form>
		</div>	
	</div>		
	</div>	
</body>
</html>