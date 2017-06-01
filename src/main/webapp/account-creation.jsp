<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
<title>Création de compte</title>
</head>
<body>
	<form action="/account-creation.jsp" method="POST">
		<label>Numéro de compte</label>
		<input type='text' name='accountnumber' <c:out value=""></c:out>>
		<label>Date de création</label>
		<input type='date' name='creationdate' <c:out value=""></c:out>>
		<label>Solde initial</label>
		<input type='number' name='balance' <c:out value=""></c:out>>
		<label>Découvert autorisé</label>
		<input type='number' name='overdraft' <c:out value=""></c:out>>
		<label>Taux d'intérêt</label>
		<input type='number' name='interestrate' <c:out value=""></c:out>>
		<label>Agence</label>
		<select name='agency'>
			<c:forEach var="item" items="${agencies}">
     			<option value="${item.id}">${item}</option>
    		</c:forEach>
		</select>
		<label>Type de compte</label>
		<select name='accounttype'>
			<c:forEach var="item" items="${accounttype}">
     			<option value="${item.id}">${item}</option>
    		</c:forEach>
		</select>
		<label>Seuil d'alerte(optionnel)</label>
		<input type='number' name='alert' <c:out value=""></c:out>>
		<button type='submit'>Submit</button>
	</form>
</body>
</html>