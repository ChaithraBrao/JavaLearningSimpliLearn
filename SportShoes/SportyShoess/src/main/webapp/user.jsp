<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user login</title>
</head>
<body>

<div align="center">
<b><h3> User Login </h3>
<form action="userlogin">

<table>

              <tr>
              <td> Enter UserName:</td>
              <td><input type="text" name="username" ></td>
              </tr>
              <tr>
              <td> Enter Password:</td>
              <td><input type="password" name="password"></td>
             </tr>
             </table>
             <br/><br/>
             <input type="submit" value="login"><br><br>
             <b><h5>If a new user, please register here</h5></b><a href="register.jsp"><b><h2 >Register Here</h2></b></a>
             
  
</form>
</div>
</body>
</html>