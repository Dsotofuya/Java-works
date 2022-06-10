<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, edu.uptc.entity.Persona" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vehicle</title>
<style><%@include file="/css/vehStyle.css"%></style>
</head>
<div class="content"> 
<body>
<h1> PERSON APP</h1>
 <h2> Hola, por favor seleccione la persona a consultar</h2>
 <form action="FindPersonaServlet" method="post">
 <table cellspacing="3" cellpadding="3" border="1" >
 <tr>
 <td align="right"> Seleccione el documento de la persona a consultar </td>
 </tr>
 <tr>
 <td> 
 <select name="person_id">
<%  
	List<Persona> lista= (List<Persona>)request.getSession().getAttribute("listPersona");
	for (Persona p:lista){
		out.print("<option value=\""+p.getDocumento()+"\">"+p.getDocumento()+"</option>");	
	}
%>
 </select>
 </td>
  </tr>
 </table>
 <input type="submit" value="Enviar">
 </form>
</body>
</div>
</html>


