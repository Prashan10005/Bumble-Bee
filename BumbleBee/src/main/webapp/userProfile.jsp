<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.user"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModelBean.product"%>
<%@page import="ModelBean.cart"%>
<%
user auth = (user) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");
List<cart> cartProduct = null;
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
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
	<div class="container">
		<div class="container w-75">
		<div class="card-header my-3 ">USER PROFILE</div>
		</div>
		<div class="container w-50">
			<form>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">First Name</label>
					<div class="col-sm-9">
						<input type="text"  class="form-control"
							id="fName" name="fName">
					</div>
				</div>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">Last Name</label>
					<div class="col-sm-9">
						<input type="text"  class="form-control-plaintext"
							id="lName" name="lName">
					</div>
				</div>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">Email</label>
					<div class="col-sm-9">
						<input type="text" class="form-control-plaintext"
							id="email" name="email">
					</div>
				</div>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">Mobile</label>
					<div class="col-sm-9">
						<input type="text"  class="form-control-plaintext"
							id="mobile" name="mobile">
					</div>
				</div>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">Credit Limit</label>
					<div class="col-sm-9">
						<input type="text"  class="form-control-plaintext"
							id="laonAmount" name="laonAmount">
					</div>
				</div>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">Used Amount</label>
					<div class="col-sm-9">
						<input type="text" class="form-control-plaintext"
							id="usedAmount" name="usedAmount">
					</div>
				</div>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-3 col-form-label">Balance</label>
					<div class="col-sm-9">
						<input type="text" class="form-control-plaintext"
							id="balance" name="balance">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>