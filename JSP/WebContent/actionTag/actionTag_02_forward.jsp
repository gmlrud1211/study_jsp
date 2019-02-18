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

<h1>forward 결과페이지</h1>
<hr>

Attribute : <%=request.getAttribute("id") %><br>
Parameter : <%=request.getParameter("id") %>


</body>
</html>