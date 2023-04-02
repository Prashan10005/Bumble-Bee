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
<title>LOAN MANAGEMENT</title>
<jsp:include page="adminHeader.jsp" />
</head>
<body>
	<header>
		<nav>
			<div>
				<a>LOAN MANAGEMENT</a>
			
			<ul>
				<li><a href="<%=request.getContextPath()%>/src/main/java/Servlet/manageLoan/list">Loans</a></li>
			</ul>
			</div>
		</nav>
	</header>
	<br>
	<div>
		<!-- <div *ngIf='message'>{{message}}</div> -->
		
		<div>
		<h3>List Of User's Loans</h3>
		<hr>
			<div>
				<a href="<%=request.getContextPath()%>/manageLoan/new" > Grant New Loan</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
					<th>Customer NIC</th>
					<th>Loan Amount</th>
					<th>Used Amount</th>
					<th>Balance</th>
					<th>Installment</th>
					</tr>
				</thead>
				<tbody>
					<!--  for (Todo todo: todos) { -->
					<c:forEach var="loan" items="${listLoan }">
						<tr>
							<td><c:out value="${loan.cusNIC }"/></td>
							<td><c:out value="${loan.loanAmount }"/></td>
							<td><c:out value="${loan.usedAmount }"/></td>
							<td><c:out value="${loan.balance }"/></td>
							<td><c:out value="${loan.installment }"/></td>
							<td> <a href="edit?cusNIC=<c:out value='${loan.cusNIC }' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="delete?cusNIC=<c:out value='${loan.cusNIC }' />">Delete</a></td>
						</tr>
						</c:forEach>
						<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
</body>
<footer>
<jsp:include page="footer.jsp" />
</footer>
</html>