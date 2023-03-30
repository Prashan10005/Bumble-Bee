<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER MANAGEMENT</title>
<jsp:include page="adminHeader.jsp" /> 
</head>
<body>

    <div align="center">
    	<h1>User Management</h1>
   		<p>List of Users</p>
        <table border="1" cellpadding="5">
            
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>NIC</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.fName}" /></td>
                    <td><c:out value="${user.lName}" /></td>
                    <td><c:out value="${user.nic}" /></td>
                    <td><c:out value="${user.email}" /></td>`
                    <td><c:out value="${user.mobile}" /></td>
                    <td>
                        <a href="/edit?nic=<c:out value='${user.nic}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?nic<c:out value='${user.nic}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p></p>
    </div>  
    </form> 
</body>
<footer>
<jsp:include page="footer.jsp" />
</footer>
</html>