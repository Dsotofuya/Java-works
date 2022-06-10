<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 <h2> Los siguientes son datos de las personas registradas</h2>
  <table cellspacing="3" cellpadding="3" border="1" >
  <tr>
 <td align="right"> Documento: </td>
 <td align="right"> Tipo documento: </td>
 <td align="right"> Nombres: </td>
 <td align="right"> Apellidos: </td> 
 <c:forEach items="${listPersona}" var="persona">
 <tr>
 <td><c:out value="${persona.documento}"></c:out></td>
 <td><c:out value="${persona.tipo_documento}"></c:out></td>
 <td><c:out value="${persona.nombres}"></c:out></td>
  <td><c:out value="${persona.apellidos}"></c:out></td>
 </tr>
 </c:forEach>
 </table>
 <h2><a href="index.jsp"> Volver a la página inicial!</h2> 
</body>
</div>
</html>