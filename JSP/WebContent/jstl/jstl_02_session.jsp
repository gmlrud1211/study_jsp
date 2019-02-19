
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>세션값 확인페이지</title>
	</head>
	<body>
		<h2>c:set 세션 확인 페이지</h2>	
		
		<hr>
		
		세션데이터 : ${sessionData }
	
		<hr>
		
	<h3>자바빈 데이터 확인</h3>
		<c:out value='<%=session.getAttribute("userSession") %>' ></c:out>
		${userSession}<br>
		${userSession.pw}<br>
		<c:out value='<%=((User)session.getAttribute("userSession")).getId() %>'></c:out>

	<hr>
	<h3>map 데이터 확인</h3>
	<c:out value='${sessionScope.m.get("A") }'/>
	<c:out value='${ m.get("B") }'/><br>
	
	${m.get('A') }<br>
	${m.B }
	
	<hr>
	<button onclick ="history.go(-1);">뒤로가기</button>
	
	</body>
</html>