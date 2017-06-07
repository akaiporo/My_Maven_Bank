<%@page pageEncoding="utf-8" contentType="text/html" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
<script type="text/javascript" src="./js/lib/jquery-3.2.1.min.js"></script>
<title>Java EE</title>
</head>
<body>
	<div id='choiceAccount'>
	</div>
	<h3>Les opérations pour ${currentAccount}</h3>
	<table>
		<tbody>
			<tr>
				<th>Wording</th>
				<th>Transaction Value</th>
				<th>Operation Date</th>
				<th>Target Transaction</th>
				<th>Description</th>
				<th>Transaction Type</th>
				<th>Category</th>
			</tr>
				<c:forEach items="${periodicTransaction}" var="p">
			<tr>
				<td><c:out value="${p.wording}" /></td>
				<td><c:out value="${p.transactionValue}"/></td>
				<td>
					<jsp:useBean id="dateOperation" class="java.util.Date"/>
					<fmt:formatDate value="${p.dateOperation}" pattern="dd MMMM YYYY" type="date"/>
				</td>
				<td><c:out value="${p.targetTransaction}" /></td>
				<td><c:out value="${p.description}"/></td>
				<td><c:out value="${p.transactionType}"/></td>
				<td><c:out value="${p.category}"/></td>
				<td>
				<form method="post" action="<c:url value="/transactionList"/>">
				<input type="hidden" name="transaction" value="<c:out value="${p.id}"/>"></input>
				<input type="hidden" name="accountId" value="<c:out value="${currentAccount.id}"/>"></input>
				<button type="submit">Delete</button>
				</form>
				<button id='editTransaction' onClick='includeEditTransactionJsp()' value='${p.id}'>Edit</button>
				</td>
			</tr>
				</c:forEach>
		</tbody>
	</table>
	<button id='redirectAccount' onClick='includeCreateTransactionJsp()' value='${currentAccount.id}'>Créer une transaction</button>	
	<div id="content"></div>
	<script type="text/javascript">
		function includeCreateTransactionJsp(){
			var id = document.getElementById('redirectAccount').value;
			$('#content').load('newTransaction?account='+id);
		}
		function includeChoiceAccountJsp(){
			$('#choiceAccount').load('choiceAccountServlet');
		}
		function includeEditTransactionJsp(){
			var id = document.getElementById('editTransaction').value;
			$('#content').load('editTransaction?transaction='+id);
		}
		window.onload = includeChoiceAccountJsp;
	</script>
</body>
</html>