<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<b><h1>Update the product</h1></b><br><br>
<form action="uppro">


<table>
<tr>
<td>Enter ProductId:</td>
<td><input type="text" name="id"></td>
</tr>

<tr>
<td>Enter ProductName:</td>
<td><input type="text" name="productname"></td>
</tr>

<tr>
<td>Product Description:</td>
<td><input type="text" name="description"></td>
</tr>

<tr>
<td>Enter Category:</td>
<td><input type="text" name="category"></td>
</tr>

<tr>
<td>Enter Price:</td>
<td><input type="number" name="price"></td>
</tr>

<tr>
<td>Enter Size:</td>
<td><input type="number" name="size"></td>
</tr>

 <tr>
 <td>Enter Quantity:</td>
 <td><input type="number" name="quantity"></td>
 </tr>
 
 </table>
<br><br><br>
 
 <input type="submit" value="update product">
 

</form><br>

</div>

</body>
</html>