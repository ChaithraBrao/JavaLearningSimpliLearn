<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewUser Login</title>
</head>
<body>


<div align="center">
<b><h3 style="color:Green;"> Hey NewUser,Please Register Here	</h3>
<form action="addregister">

<table>
              <tr>
              <td> Enter UserName:</td>
              <td><input type="text" name="username" ></td>
              </tr>
 
              <tr>
              <td> Enter Password:</td>
              <td><input type="password" name="password" ></td>
              </tr>
              
              <tr>
              <td> Enter Email Id:</td>
              <td><input type="email" name="emailid" ></td>
              </tr>
              
               <tr>
              <td>  Enter Address:</td>
              <td><input type="text" name="address" ></td>
              </tr>
              
              
               <tr>
              <td> Enter Place:</td>
              <td><input type="text" name="place" ></td>
              </tr>
              
               <tr>
              <td> Enter MobileNo:</td>
              <td><input type="text" name="mobno" ></td>
              </tr>
              
              
              <tr>
             <td><b>Gender</b></td>
             <td><select name="ugender">
               <option value="Male">Male</option>
               <option value="Female">Female</option>
               <option value="other">Other</option>
       
             </select> 
             </td>
             </tr>
              
              <tr>
              <td> Enter Age:</td>
              <td><input type="number" name="age" ></td>
              </tr>
              
              </table>
              <br><br><br>
              <input type= "submit"  name="add"  value="Register">


</div>

</body>
</html>