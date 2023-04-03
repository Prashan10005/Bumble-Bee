<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
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
<title>LOAN MANAGEMENT</title>
<jsp:include page="adminHeader.jsp" />
</head>
<body>
	<div class="container">

		<div class="card-header my-3">Create Loan Facility</div>

		<div class="container w-50">
			<form>
				<div class="form-group">
					<label for="productTitle">User NIC</label> <input type="text"
						class="form-control" id="cusNIC" name="cusNIC">
				</div>
				<div class="form-group">
					<label for="category">Loan Amount</label> <input type="text"
						class="form-control" id="loanAmount" name="loanAmount">
				</div>
				<div class="form-group">
					<label for="price">Used Amount</label> <input type="text"
						class="form-control" id="usedAmount" name="usedAmount">
				</div>
				<div class="form-group">
					<label for="price">Balance</label> <input type="text"
						class="form-control" id="balance" name="balance">
				</div>
				<div class="form-group">
					<label for="price">Installment Period</label> <input type="text"
						class="form-control" id="installment" name="installment">
				</div>
				<button type="submit" class="btn btn-primary btn-block"
					href="manageProduct">GRANT CREDIT LIMIT</button>
				<br> <br>
			</form>
		</div>
	</div>
</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>