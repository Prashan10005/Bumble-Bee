<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="Dao.dbManager" %>
 <%@page import="ModelBean.admin" %>
 <%
 admin  auth =(admin)request.getSession().getAttribute("auth");
 if(auth != null){
	 request.setAttribute("auth",auth);
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRODUCT MANAGEMENT</title>
<jsp:include page="adminHeader.jsp" />
</head>
<body>
manage product
</body>
<footer>
<jsp:include page="footer.jsp" />
</footer>
</html>