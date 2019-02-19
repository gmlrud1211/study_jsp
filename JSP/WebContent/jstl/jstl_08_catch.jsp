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
	<h1>JSTL c:catch</h1>
	<hr>
	
	<%-- 요청 파라미터 id를 "test"와 비교하기--%>
	id 파라미터 : ${param.id } 
	<c:catch var="e">
		<%--예외발생 코드 --%>
		<% request.getParameter("id").equals("test"); %>
		
	</c:catch>
	
	<c:if test="${not empty e }">
		예외발생됨ㅋㄷㅋㄷ<br>
		에러 구분 [${e }]<br>      
	</c:if>

	<c:if test="${not empty e }" var="idParamErr" scope="session" />

	</body>
</html>