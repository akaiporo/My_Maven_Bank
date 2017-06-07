<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New transaction</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${empty currentTransaction}">				
			
		<form method="POST" action="<c:url value="/newTransaction"/>">
		<h3>Nouvelle transaction pour ${currentAccount}</h3>
			<input type='hidden' value="${param['account']}" name="account">
			<div>
				<label>Débit</label>
				<input type="radio" name="rd-sign" value="moins" checked="checked">
				<label>Crédit</label>
				<input type="radio" name="rd-sign" value="plus">
				<label>Montant*</label>
				<input name="amount" type="number" step="0.01">
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
		</c:when>
		<c:otherwise>
		<form method="POST" action="<c:url value="/editTransaction"/>">
		<h3>Editer une transaction</h3>
			<input type='hidden' value="${currentTransaction.account.id}" name="account">
			<input type='hidden' value="${currentTransaction.id}" name="id">
			<div>
				<label>Débit</label>
				<input type="radio" name="rd-sign" value="moins" checked="checked">
				<label>Crédit</label>
				<input type="radio" name="rd-sign" value="plus">
				<label>Montant*</label>
				<input name="amount" type="number" value="${amount}" step="0.01">
			</div>
			<div>
				<label>Destinataire</label>
				<select name="slct-target">
					<c:forEach items="${targets}" var="p">
						<c:choose>
							<c:when test="${p.id eq currentTransaction.targetTransaction.id}">
								<option value="${p.id}" selected="selected">${p}</option>
							</c:when>
							<c:otherwise>
								<option value="${p.id}">${p}</option>
							</c:otherwise>
						</c:choose>
					 </c:forEach>
				</select>
			</div>
			<div>
				<label>Libellé*</label>
				<input type="text" value="${currentTransaction.wording}" name="wording">
				<label>Description</label>
				<input type="text" value="${currentTransaction.description}" name="description">
				<label>Categorie</label>
				<select name="slct-category">
					<c:forEach items="${categories}" var="p">
						<c:choose>
							<c:when test="${p.id eq currentTransaction.category.id}">
								<option value="${p.id}" selected="selected">${p}</option>
							</c:when>
							<c:otherwise>
								<option value="${p.id}">${p}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div>
			<label>Date</label>
			<input type="date" value="${date}" name="date">
			</div>
			<div>
				<label>Type</label>
				<select name="slct-type">
					<c:forEach items="${transactionTypes}" var="p">
				    	<c:choose>
							<c:when test="${p.id eq currentTransaction.transactionType.id}">
								<option value="${p.id}" selected="selected">${p}</option>
							</c:when>
							<c:otherwise>
								<option value="${p.id}">${p}</option>
							</c:otherwise>
						</c:choose>
					 </c:forEach>
				</select>
			</div>
			<button type="submit">Sauver</button>
		</form>
			</c:otherwise>
		</c:choose>
	</body>
</html>