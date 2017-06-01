<%@page pageEncoding="utf-8" contentType="text/html" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
</head>
<body>
	<Button onClick='window.location.href="<c:url value="/newAccount"/>"'>Creation de compte</Button>
	<Button onClick='window.location.href="<c:url value="/choiceAccountServlet"/>"'>Choix d'un compte</Button>
</body>
</html>