<%@page import="dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

휴우...
<hr>
<%	Emp e = (Emp) request.getAttribute("res");%>

<%=e.getEmpno() %>

<hr>
<a href="/emp/insert"><button>사원 입력</button></a>

</body>
</html>
















