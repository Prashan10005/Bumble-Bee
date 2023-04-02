<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.user"%>
<%
user auth = (user) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INVENTARY MANAGEMENT</title>
<jsp:include page="userHeader.jsp" />
</head>
<body>
	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price : Rs 452</h3>
			<a class="mx-3 btn btn-primary" href="#">Check Out</a>
		</div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Product Name</th>
					<th scope="col">Product Category</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Head Phone</td>
					<td>Mobile Accessories</td>
					<td>Rs 6750</td>
					<td>
					<a class="btn btn-sm btn-danger" href="">Remove</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>