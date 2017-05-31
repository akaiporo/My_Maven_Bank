<%@page pageEncoding="utf-8" contentType="text/html" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Java EE</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>Wording</th>
				<th>Transaction Value</th>
				<th>Operation Date</th>
				<th>Transaction End Date</th>
				<th>Day Number</th>
				<th>Description</th>
				<th>Transaction Type</th>
				<th>Category</th>
				<th>Period Unit</th>
				<th>Account</th>	
			</tr>
				<c:forEach items="${periodicTransaction}" var="p">
			<tr>
				<td><c:out value="${p.wording}" /></td>
				<td><c:out value="${p.transaction_value}"/></td>
				<td><c:out value="${p.date_operation}" /></td>
				<td><c:out value="${p.end_date_transaction}"/></td>
				<td><c:out value="${p.day_number}" /></td>
				<td><c:out value="${p.description}"/></td>
				<td><c:out value="${p.transactionType}"/></td>
				<td><c:out value="${p.category}"/></td>
				<td><c:out value="${p.periodUnit}"/></td>
				<td><c:out value="${p.account}"/></td>
			</tr>
				</c:forEach>
		</tbody>
	</table>
</body>
</html>