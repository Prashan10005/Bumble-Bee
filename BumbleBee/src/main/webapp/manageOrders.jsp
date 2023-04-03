<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.DecimalFormat" %>	
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.user"%>
<%@page import="ModelBean.product"%>
<%@page import="ModelBean.cart"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf",dcf);
user auth = (user) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
List<cart> cartProduct = null;
if(cart_list != null){
	dbManager proDao = new  dbManager();
	cartProduct = proDao.displayCart(cart_list);
	double total = proDao.getTotal(cart_list);
	request.setAttribute("cart_list",cart_list);
	request.setAttribute("total",total);
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
			<h3>Total Price : Rs ${(total>0)?dcf.format(total):0}</h3>		
			<a class="mx-3 btn btn-primary" href="checkout">Check Out</a>
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
			<% if(cart_list != null){
					for(cart c:cartProduct){ %>
						<tr>
						<td><%= c.getProName() %></td>
						<td><%= c.getCategory() %></td>
						<td>Rs <%= dcf.format(c.getPrice()) %></td>
						<td>
						<a class="btn btn-sm btn-danger" href="cartRemove?proID=<%= c.getProID()%>">Remove</a>
						</td>
					</tr>	
				<%}
				}
				%>
			
				
			</tbody>
		</table>
	</div>
</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>