<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>EL param 기본객체 테스트</h1>
	<hr>
	<h3>표현언어, EL</h3>
	전달받은 id : ${param.id}<br>
	전달받은 pw : ${param.pw}<br>
	<hr>
	<h3>표현식, Expression</h3>
	전달받은 id :<%=request.getParameter("id") %><br>
	전달받은 pw :<%=request.getParameter("pw") %><br>
	
	
	
	
</body>
</html>