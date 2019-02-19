<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
	</head>
	<body>
	<h1>JSTL c:forTokens</h1>
	<hr>
	
	<% String fruits ="apple, banana, cherry, durian"; %>

	<c:forTokens items="<%=fruits %>" delims="," var="fruit">
		${fruit }<br>
	</c:forTokens>
	
	</body>
</html>