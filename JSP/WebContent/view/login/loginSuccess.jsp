<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h2>로그인 성공함 ㅊㅊ~~</h2>
	<hr>
	<h4>세션확인</h4>
	Id : <%=session.getAttribute("userId") %><br>
	Session : <%=session.getAttribute("login") %>
	
	<br><br>
	
	<c:if test="${login==true }">
		<a href="/login/logout">로그아웃</a>
	</c:if> 
</body>
</html>