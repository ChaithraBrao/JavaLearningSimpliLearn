<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.example.demo.*" %>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view user details</title>
</head>
<body>
<div align="center">
<b><h1>All Users</h1></b>
<br><br><br>

    <%
	List<User> s = (List<User>) request.getAttribute("list");
	%>


<table border="1">
		<tr>
			<th>id</th>
			<th>username</th>
			<th>password</th>
			<th>emailid</th>
			<th>address</th>
			<th>place</th>
			<th>mobileno</th>
			<th>gender</th>
			<th>age</th>
			<th>editUsd</th>
			<th>deletedetails</th>
			
			
			
		</tr>

		<%
		for (User ss : s) {
		%>

		<tr>
			<td><%=ss.getId()%></td>
			<td><%=ss.getUsername() %></td>
			<td><%=ss.getPassword() %></td>
			<td><%=ss.getEmailid() %></td>
			<td><%=ss.getAddress() %></td>
			<td><%=ss.getPlace() %></td>
			<td><%=ss.getMobno() %></td>
			<td><%=ss.getUgender()%></td>
			<td><%=ss.getAge() %></td>
			<td><a href="edit.jsp">Edit</a></td>
            <td><a href="delete.jsp">Delete</a></td>
			
		</tr>

		<%
		}
		%>
	</table>







</div>





</body>
</html>