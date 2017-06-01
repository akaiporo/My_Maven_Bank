<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New transaction</title>
	</head>
	<body>
		<h3>Nouvelle transaction :</h3>
		<form method="POST" action="">
			<div>
				<label>Débit</label>
				<input type="radio" name="rd-sign" checked="checked">
				<label>Crédit</label>
				<input type="radio" name="rd-sign">
				<label>Montant*</label>
				<input name="amount" type="number">
			</div>
			<div>
				<label>Compte*</label>
				<select name="slct-account">
					<c:forEach items="${accounts}" var="p">
						<option value="${p.id}">${p}</option>
					 </c:forEach>
				</select>
			</div>
			<div>
				<label>Destinataire</label>
				<select name="slct-target">
					<c:forEach items="${targets}" var="p">
				    	<option value="${p.id}">${p}</option>
					 </c:forEach>
				</select>
			</div>
			<div>
				<label>Libellé*</label>
				<input type="text" name="wording">
				<label>Description</label>
				<input type="text" name="description">
				<label>Categorie</label>
				<select name="slct-category">
					<c:forEach items="${categories}" var="p">
				    	<option value="${p.id}">${p}</option>
					 </c:forEach>
				</select>
			</div>
			<div>
			<label>Date</label>
			<input type="date" name="date">
			</div>
			<div>
				<label>Type</label>
				<select name="slct-type">
					<c:forEach items="${transactionTypes}" var="p">
				    	<option value="${p.id}">${p}</option>
					 </c:forEach>
				</select>
			</div>
			<button type="submit">Ajout</button>
		</form>
	</body>
</html>