<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>view page</title>
	</head>
	<body>
	
	<h2>세션확인</h2>
	<hr>
	
	${test }<br>
	${sessionScope.test }<br>
	
	<hr>
	Id : <%=session.getId() %><br>
	<%-- CreateTime : ${session.getCreateTime() }<br> 동작안함 --%>
	CreateTime : <%=session.getCreationTime() %><br>
	
		
	세션 생성 시점 : <fmt:formatDate value="<%=new Date(session.getCreationTime()) %>" type="both" />


	<h3><a href="create">세션 생성</a></h3>
	<h3><a href="/session/delete">세션 삭제</a></h3>
	
	
	
	
	</body>
</html>