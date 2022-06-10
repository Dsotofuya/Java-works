<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vehicle</title>
</head>
<body>
<div class="content"> 
<h1> PERSON APP</h1>
 <h2> Ingrese </h2>
 <form action="AddStateServlet" method="post">
 <table cellspacing="3" cellpadding="3" border="1" >
 <tr>
 <td align="right"> address: </td>
 <td><input type="text" name="address"></td>
 </tr>
 <tr>
 <td align="right"> block: </td>
 <td> <input type="text" name="block"> </td>
 </tr>
  <tr>
 <td align="right"> internal_id: </td>
 <td> <input type="text" name="internal_id"> </td>
 </tr>
 <tr>
 <td align="right"> RealStateEnum: </td>
 <td> <input type="text" name="RealStateEnum"> </td>
 </tr>
 </table>
 <input type="submit" value="Enviar">
 </form>
</div>
</body>
</html>