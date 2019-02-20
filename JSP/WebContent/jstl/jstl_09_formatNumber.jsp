<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
	</head>
	<body>
	<h1>JSTL fmt:formatNumber</h1>
	<hr>
	
	<fmt:formatNumber value="12345678" type="number"/><br>
	<fmt:formatNumber value="12345678" type="currency"/><br>
	<fmt:formatNumber value="120" type="percent"/><br>
	<hr>
	
	<fmt:formatNumber value="12345.67890" pattern="######.##"/><br>
	<fmt:formatNumber value="12345.67890" pattern="####.##"/><br>
	<fmt:formatNumber value="12345.67890" pattern="####,##.#####"/><br>
	<fmt:formatNumber value="12345.67890" pattern="0000,000.0000"/><br>
	<fmt:formatNumber value="12345.67890" pattern="00 00,000.000"/><br>
	<hr>
	
	<%--false로 지정했기때문에  --%>
	<fmt:formatNumber value="1234567890" groupingUsed="false"/><br>
	<fmt:formatNumber value="1234567890" currencyCode=""/><br>
	
	 
	</body>
</html>