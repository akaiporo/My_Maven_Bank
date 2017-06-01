<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<label>Numéro de compte</label>
		<label>"${account.account_number}"</label>
		<label>Date de création</label>
		<label>"${account.creation_date}"</label>
		<label>Solde initial</label>
		<label>"${account.first_total}"</label>
		<label>Découvert autorisé</label>
		<label>"${account.overdraft}"</label>
		<label>Taux d'intérêt</label>
		<label>"${account.interest_rate}"</label>
		<label>Agence</label>
		<label>"${account.agency.agency_name}"</label>
		<label>Type de compte</label>
		<label>"${account.accountType}"</label>
		<label>Seuil d'alerte(optionnel)</label>
		<label>"${account.alert_thresh}"</label>
</body>
</html>