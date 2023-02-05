<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%String amount=request.getParameter("price"); %>

<div align="center">
        <b><h1 style="color:Green;"> &#9989; Payment Successful ! </h1></b>
        <h3 style="color:Orange;">Your Order has been Booked.</h3><br><br>
       
		<br>
		
		<b><h4>Your Order details have been sent to your mail.</h4></b><br><br>
		<form action="Welcome.jsp"><input type="submit" value="Done"></form><br>
</div>
</body>
</html>