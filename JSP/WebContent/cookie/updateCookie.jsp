<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Cookie</title>
	</head>
	<body>
		<h2>Cookie 수정 페이지</h2>
		<hr>
	
		<%
			Cookie c = new Cookie("ID","Ace");
			response.addCookie(c);
			
			response.addCookie(new Cookie("PASS","1234"));
			response.addCookie(new Cookie("Name","yeahree"));
			
			
		%>
		
		<h3><a href="main.jsp">메인으로</a></h3>
		<h3><a href="viewCookie.jsp">쿠키확인</a></h3>
		<h3><a href="updateCookie.jsp">쿠키수정</a></h3>
		<h3><a href="deleteCookie.jsp">쿠키삭제</a></h3>
	
	
	
	
	
	</body>
</html>