<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type"
 	content="text/html; charset=UTF-8">
 	<style><%@include file="/css/vehStyle.css"%></style>
 <title> Formulario Persona</title>
 </head>
 <body>
 <div class="topnav">
	 <div class="dropdown">
	    <button class="dropbtn">Persona
	      <i class="fa fa-caret-down"></i>
	    </button>
	    <div class="dropdown-content">
			 <a href="addPerson.jsp">Crear Persona</a>
			 <a href="SelectPersonaServlet">Modificar Persona</a>
			 <a href="SelectFindPersonaServlet">Consultar Persona</a>
			 <a href="SelectDelPersonaServlet">Borrar Persona</a>
			 <a href="FindAllPersonaServlet">Consultar todas las personas</a>
		</div>
	</div>
	<div class="dropdown">
	    <button class="dropbtn">Historia Clinica
	      <i class="fa fa-caret-down"></i>
	    </button>
	    <div class="dropdown-content">
			 <a href="#">Crear Historia</a>
			 <a href="#">Modificar Historia</a>
			 <a href="#">Consultar Historia</a>
			 <a href="#">Borrar Historia</a>
			 <a href="#">Consultar todas las Historias</a>
		</div>
	</div>
	<div class="dropdown">
	    <button class="dropbtn">Enfermedad
	      <i class="fa fa-caret-down"></i>
	    </button>
	    <div class="dropdown-content">
			 <a href="#">Crear Enfermedad</a>
			 <a href="#">Modificar Enfermedad</a>
			 <a href="#">Consultar Enfermedad</a>
			 <a href="#">Borrar Enfermedad</a>
			 <a href="#">Consultar todas las Enfermedades</a>
		</div>
	</div>			 
</div>
 
 <div class="content"> 
 
 </div>
 
 <div class="footer">
  <p>Ingenieria de Software I - 2020 
  Copyright UPTC Tunja</p>
</div>
 
  </body>
</html>
