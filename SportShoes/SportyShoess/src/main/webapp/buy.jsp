<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String productpp=request.getParameter("price"); %>
<%Random rand=new Random();
 int ran=rand.nextInt(130001,132000); %>

<div align="center">
		<b><h1>Sporty Shoes  &#128095; &#128095;  &#128095;</h1></b><br>
		<h2>PAY</h2>
		
			<table>
				
				<tr>
				<td><b>Order Number</b>&nbsp;&nbsp;&nbsp;<%=ran %></td>
				</tr>
				<tr>
					<td><b>Product Price </b>Rupees</td><td>&nbsp;&nbsp;&nbsp;<%=productpp %> /-</td>
				</tr>
			</table><br>
			<h3>Card Payment</h3>
			<table>
				
				<tr>
					<td><b>Card Number</b></td><td><input type ="number" name="cardno"></td>
				</tr>
				<tr>
					<td><b>Expiry Date</b></td><td><input type="month" name="month"  min="2022" max="2200"></td>
				</tr>
				<tr>
					<td><b>Password </b></td><td><input type ="password" name="psd"></td>
				</tr>
			</table><br>
		<form action="payment.jsp">	<input type="submit" value="Proceed to pay"></form><br><br>
			
			
			
			
			<input type="hidden" id="order" name="order" value=<%=ran %>>
			<input type="hidden" id ="amt" name="amt" value=<%=productpp %>>
			
		
		</form>
	</div>

</body>
</html>