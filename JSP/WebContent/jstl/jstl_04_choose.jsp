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
	
	<h1>c:choose 테스트 페이지</h1>
	
	<c:choose>
		<c:when test="${param.sel eq 1}">1선택함</c:when>
		<c:when test="${param.sel eq 2}">2선택함</c:when>
		<c:when test="${param.sel eq 3}">3선택함</c:when>
		<c:otherwise>1,2,3 중에 하나 선택하셈</c:otherwise>
	</c:choose>
	
	<h4><a href="jstl_04_form.jsp">돌아가기</a></h4>
	
	
	</body>
</html>