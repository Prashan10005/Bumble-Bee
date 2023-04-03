<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.admin"%>
<%
admin auth = (admin) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
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
	<div class="container">

		<div class="card-header my-3">Create Loan Facility</div>

		<div class="container w-50">
			<form >
				<div class="form-group">
					<label for="productTitle">Product Title</label> <input type="text"
						class="form-control" id="proName" name="proName">
				</div>
				<div class="form-group">
					<label for="category">Product Category</label> <input type="text"
						class="form-control" id="category" name="category">
				</div>
				<div class="form-group">
					<label for="price">Product Price</label> <input type="text"
						class="form-control" id="price" name="price">
				</div>
				<div class="form-group">
					<label for="Image">Upload Product Image</label> <input
						type="file" class="form-control-file" id="image" name="image">
				</div>
				<button type="submit" class="btn btn-primary btn-block" href="manageProduct">INSERT
					PRODUCT</button>
				<br>
				<br>
			</form>
		</div>
	</div>

</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>