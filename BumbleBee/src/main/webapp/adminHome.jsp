<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Dao.dbManager"%>
<%@page import="ModelBean.*"%>
<%@page import="java.util.*" %>
<%@page import="java.util.List" %>
<%
admin auth = (admin) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}
ArrayList<user> user_list = (ArrayList<user>) session.getAttribute("user-list");
List<user> userlist = null;
	dbManager proDao = new  dbManager();
	userlist = proDao.selectAllUser();
	request.setAttribute("user_list",user_list);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER MANAGEMENT</title>
<jsp:include page="adminHeader.jsp" />
</head>
<body>
	<div class="container">
		<div class="card-header my-3">All Users</div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">NIC</th>
					<th scope="col">Age</th>
					<th scope="col">Email</th>
					<th scope="col">Mobile</th>
					<th scope="col">Approve</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (user c :userlist) {
				%>
				<tr>
					<td><%=c.getfName()%></td>
					<td><%=c.getlName()%></td>
					<td><%=c.getNic()%></td>
					<td><%=c.getAge()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getMobile()%></td>
					<td><a class="btn btn-sm "
						href="acceptUser?nic=<%= c.getNic() %>">Accept User</a></td>
				</tr>
				<%
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