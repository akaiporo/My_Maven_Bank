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
	<c:choose>
		<c:when test="${empty currentAccount}">		
	<form action="<c:url value="/accountDispatcher"/>" method="POST">
		<h3>Création d'un compte !</h3>
		<label>Numéro de compte</label>
		<input type='text' name='accountnumber' <c:out value=""></c:out>>
		<label>Date de création</label>
		<input type='date' name='creationdate' <c:out value=""></c:out>>
		<label>Solde initial</label>
		<input type='number' name='balance' <c:out value=""></c:out>>
		<label>Découvert autorisé</label>
		<input type='number' name='overdraft' <c:out value=""></c:out>>
		<label>Taux d'intérêt</label>
		<input type='number' step="0.1" name='interestrate' <c:out value=""></c:out>>
		<label>Agence</label>
		<select name='agency'>
			<c:forEach var="agency" items="${agencies}">
     			<option value="${agency.id}">${agency}</option>
    		</c:forEach>
		</select>
		<label>Type de compte</label>
		<select name='accounttype'>
			<c:forEach var="type" items="${accounttype}">
     			<option value="${type.id}">${type}</option>
    		</c:forEach>
		</select>
		<label>Seuil d'alerte(optionnel)</label>
		<input type='number' name='alert' <c:out value=""></c:out>>
		<button type='submit'>Submit</button>
	</form>
	</c:when>
	<c:otherwise>
	<h3>Edition du compte "${currentAccount}" !</h3>
	<form action="<c:url value="/EditAccount"/>" method="POST">
		<input type='hidden' name='id' value="${currentAccount.id}">
		<label>Numéro de compte</label>
		<input type='text' name='accountnumber' <c:out value="${currentAccount.accountNumber}"></c:out>>
		<label>Date de création</label>
		<input type='date' name='creationdate' <c:out value="${currentAccount.creationDate}"></c:out>>
		<label>Solde initial</label>
		<input type='number' name='balance' <c:out value="${currentAccount.firstTotal}"></c:out>>
		<label>Découvert autorisé</label>
		<input type='number' name='overdraft' <c:out value="${currentAccount.overdraft}"></c:out>>
		<label>Taux d'intérêt</label>
		<input type='number' step="0.1" name='interestrate' <c:out value="${currentAccount.interestRate}"></c:out>>
		<label>Agence</label>
		<select name='agency'>
			<c:forEach var="agency" items="${agencies}">
			<c:choose>
				<c:when test="${agency.id eq currentAccount.agency.id}">
						<option value="${agency.id}" selected="selected">${agency}</option>
				</c:when>
				<c:otherwise>
						<option value="${agency.id}">${agency}</option>
				</c:otherwise>
			</c:choose>
    		</c:forEach>
		</select>
		<label>Type de compte</label>
		<select name='accounttype'>
			<c:forEach var="type" items="${accounttype}">
			<c:choose>
				<c:when test="${type.id eq currentAccount.accountType.id}">
						<option value="${type.id}" selected="selected">${type}</option>
				</c:when>
				<c:otherwise>
						<option value="${type.id}">${type}</option>
				</c:otherwise>
			</c:choose>
    		</c:forEach>
		</select>
		<label>Seuil d'alerte(optionnel)</label>
		<input type='number' name='alert' <c:out value="${currentAccount.alertThresh}"></c:out>>
		<button type='submit'>Submit</button>
	</form>
	</c:otherwise>
	</c:choose>
</body>
</html>