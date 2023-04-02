<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Management Form</title>
</head>
<body>
	<header>
		<nav>
			<div>
				<a>LOAN MANAGEMENT</a>
			</div>
			<ul>
				<li><a href="<%request.getContextPath();%>/list">Loans</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<div>
			<c:if test="${loan != null }">
				<form action="update" method="post">
			</c:if>
			<c:if test="${loan == null }">
				<form action="insert" method="post">
			</c:if>
			
			<caption>
				<h2>
				<c:if test="${loan != null }">
					Edit Loan
				</c:if>	
				<c:if test="${loan == null }">
					Grant Loan
				</c:if>
				</h2>
			</caption>
				<c:if test="${loan != null }">
					<input type="hidden" name="cusNIC" value="<c:out value='${loan.cusNIC}' />"/>
				</c:if>
				<fieldset>
				<lable>Loan Amount</lable> <input type="text" value="<c:out value='${loan.loanAmount}' />" name="loanAmount" required="required"/>
				</fieldset> 
				<fieldset>
				<lable>Used Amount</lable> <input type="text" value="<c:out value='${loan.usedAmount}' />" name="usedAmount" required="required"/>
				</fieldset> 
				<fieldset>
				<lable>Balance</lable> <input type="text" value="<c:out value='${loan.balance}' />" name="balance" required="required"/>
				</fieldset> 
				<fieldset>
				<lable>Installment</lable> <input type="text" value="<c:out value='${loan.installment}' />" name="installment" required="required"/>
				</fieldset> 
				
				<button type="submit" >SAVE</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>