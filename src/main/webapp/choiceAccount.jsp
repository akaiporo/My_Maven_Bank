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
	<select onChange="window.location.href=this.value">
		<option selected>Choisissez un compte...</option>
		<c:forEach var="account" items="${accounts}">
     		<option value="${contextPath}/choiceAccount?account=${account.id}">${account}</option>
    	</c:forEach>
	</select>
</body>
</html>