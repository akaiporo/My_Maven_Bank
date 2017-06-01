<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath}/choiceAccount" method="POST">
		<select name='accounts'>
			<c:forEach var="account" items="${accounts}">
     			<option value="${account.id}">${account}</option>
    		</c:forEach>
		</select>
		<button type='submit'>Selectionner</button>
	</form>
</body>
</html>