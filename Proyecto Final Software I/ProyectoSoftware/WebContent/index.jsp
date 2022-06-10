<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
 <head>
<title>Propiedades Horizontales app</title>
<style><%@include file="/css/indexStyle.css"%></style> 
 </head>
 <body>
 <div class = "top-div">
 <h1 class = "h1-title">Propiedades horizontales app</h1>
 </div>
 <div class = "image">
</div>
<div class = "container">
<form class="form" action="LoginServlet" method="post">
<div class = "login-form">
<div class = "login">
<h3>Log - In</h3>
</div>
<input name = "user_id" type = "text" placeholder = "User - ID" onkeydown="return validNumberInput(event, this.name)">
<input name = "user_password" type = "password" placeholder = "Password" >
<input class = "btn" type="submit" value="Login">
<c:choose>
<c:when test = "${validCredentialsSwitch == 1}">
<div id= "secret" class ="advice-div">
<h2 class ="hidden-advice">Invalid User or Password</h2>
</div>
</c:when>
</c:choose>
<div class = "shadow-div"></div>
</div>
</form>
</div>
</body>
</html>
