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
	<h1>JSTL c:choose</h1>
	<hr>
	<form action="jstl_04_choose.jsp" method="get">
		<select name="sel">
			<option value="0" selected>선택안함 </option>
			<option>1</option>
			<option>2</option>
			<option value="3">3</option>
		</select>
		<button>전송</button>
	</form>

	</body>
</html>