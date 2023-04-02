<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="Dao.dbManager" %>
 <%@page import="ModelBean.user" %>
 <%
 user  auth =(user)request.getSession().getAttribute("auth");
 if(auth != null){
	 request.setAttribute("auth",auth);
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER HOME PAGE</title>
<jsp:include page="userHeader.jsp" /> 
</head>
<body>
	
</body>
<footer>
<jsp:include page="footer.jsp" />
</footer>
</html>