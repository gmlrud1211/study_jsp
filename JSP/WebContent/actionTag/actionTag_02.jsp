<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ActionTag</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<hr>

<jsp:forward page="actionTag_02_forward.jsp">
	<jsp:param value="hk" name="id" />
</jsp:forward>


</body>
</html>