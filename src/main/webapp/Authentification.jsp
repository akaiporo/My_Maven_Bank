<%@page pageEncoding="UTF-8" contentType="text/html" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
 	<meta charset="UTF-8">
    <title>Authentification</title>
  </head>
  <body>
  	<form action="<c:url value="/Authentification"/>" method="POST">
  		<h3>Welcome to your personnal Bank! Please authentificate and enjoy!</h3>
  		<label>Login</label>
  		<input type="text" name="login">
  		<label>Password</label>
  		<input type="password"  name="pwd">
  		<button type="submit">Connexion</button>
  	</form>
</body>
</html>