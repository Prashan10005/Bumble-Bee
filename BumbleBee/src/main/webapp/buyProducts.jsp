<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.user"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="ModelBean.product"%>
<%@page import="ModelBean.cart"%>
<%
user auth = (user) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
dbManager proDao1 = new  dbManager();
List<product> product = proDao1.getAllProduct();

ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
List<cart> cartProduct = null;
if(cart_list != null){
	request.setAttribute("cart_list",cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW PRODUCTS</title>
<jsp:include page="userHeader.jsp" />
</head>
<body>
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
		<%
			if(!product.isEmpty()){
				for(product p:product){ %>
					<div class="col-md-3 my-3">
					<div class="card w-100 " style="width: 18rem;">
						<img class="card-img-top" src="ProductImages/<%= p.getImage()%>" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title"><%= p.getProName()%></h5>
							<h6 class="price">Price : Rs <%= p.getPrice()%>  </h6>
							<h6 class="category">Category: <%= p.getCategory()%></h6>
							<div class="mt-3 d-flex justify-content-between">
							<a href="moveToCart?proID=<%= p.getProID() %>" class="btn btn-primary">Add to Cart</a>
							</div>
							
						</div>
					</div>
				</div>
				<% } 
			}
		%>
			
		</div>
	</div>
</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>