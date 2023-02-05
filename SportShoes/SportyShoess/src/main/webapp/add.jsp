<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
</head>
<body>
<div align="center">
<b><h1>ADD Product </h1></b><br><br>
<form action="addin">
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
  <td>Enter Product Description:</td>
  <td><input type="text" name="description"></td>
  </tr>
  
  <tr>
  <td>Enter Category:</td>
  <td><input type="text" name="category"></td>
  </tr>
  
  <tr>
  <td>Price:</td>
  <td><input type="number" name="price"></td>
  </tr>
  
  <tr>
  <td>Quantity:</td>
  <td><input type="number" name="quantity"></td>
  </tr>
  
  <tr>
  <td>Size</td>
  <td><input type="number" name="size"></td>
  </tr>
  
  </table>
 <br><br><br>
 <input type="submit" value="proceed">








</form>
</div>

</body>
</html>