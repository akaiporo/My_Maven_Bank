<%@page pageEncoding="utf-8" contentType="text/html" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/bootstrap-theme.min.css" rel="stylesheet">
<script type="text/javascript" src="./js/lib/jquery-3.2.1.min.js"></script>
<title>Java EE</title>

</head>
<body>
<!--  <nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">
						<a class="navbar-brand" href="#"><img class="img-responsive2"
							src="css/images/gold.png" alt="My Personnal Bank"></a>
						<h4 class="navbar-text">My Personnal Bank</h4>
					</div>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
						<li><a
							onClick='window.location.href="<c:url value="/authentification"/>"'>Log
								out</a></li>
					</ul>
				</div>
			</div>
		</nav> --> 
	<div id='choiceAccount'>
	
	</div>
	<form style="margin-top: 50px;" action="<c:url value="/newAccount"/>" method='GET'>
		<h3 style="display:inline;">Les opérations pour ${currentAccount}</h3>
		<input type='hidden' name='accountId' value='${currentAccount.id}'>
    	<input type="submit" class="btn btn-primary" value='Editer le compte'>
	</form>
	<table style="margin-top: 50px;" class="table">
		<tbody>
			<tr>
				<th>Libellé</th>
				<th>Valeur</th>
				<th>Date</th>
				<th>Cible</th>
				<th>Description</th>
				<th>Type de transaction</th>
				<th>Categorie</th>
				<th><button style="margin-right: 50px;"  class="btn btn-primary pull-right" id='redirectAccount' onClick='includeCreateTransactionJsp()' value='${currentAccount.id}'>Créer une transaction</button>	
				</th>
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
				<form style="display:inline-block;" method="post" action="<c:url value="/transactionList"/>">
				<input id='transactionId' type="hidden" name="transaction" value="<c:out value="${p.id}"/>"></input>
				<input type="hidden" name="accountId" value="<c:out value="${currentAccount.id}"/>"></input>
				<button class="btn btn-default" type="submit">Supprimer</button>
				</form>
				<button class="btn btn-primary" id='editTransaction' onClick="$('#content').load('editTransaction?transaction='+this.value);" 
				        value='${p.id}'>Editer</button>
				</td>
			</tr> 
				</c:forEach>
		</tbody>
	</table>
	<div id="content"></div>
	<script type="text/javascript">
		function includeCreateTransactionJsp(){
			var id = document.getElementById('redirectAccount').value;
			$('#content').load('newTransaction?account='+id);
		}
		function includeChoiceAccountJsp(){
			$('#choiceAccount').load('choiceAccountServlet');
		}
		window.onload = includeChoiceAccountJsp;
	</script>
</body>
</html>