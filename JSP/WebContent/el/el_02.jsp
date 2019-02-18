<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>EL 연산자</h1>
	
	${ 123 eq 123}<br>
	${ 10 > 20 }<br>
	${ 7/3 }<br>
	<%-- ${ 7 div 3 }<br> --%>	
	${ empty str }<br>	
	<hr>
	
	<h1>EL에서 사용되는 자료형</h1>
	정수형 : ${123 }<br>
	실수형 : ${123.456 }<br>
	단일문자 : ${'A'}<br>
	문자열 : ${"banana" }<br>
	논리형 : ${ true }&nbsp;&nbsp;&nbsp;&nbsp;${ false }<br>
	null : ${ null }<br>
	<hr>
	
	
	<%
		int num=123;
	%>
	num : ${ num }<br>
	empty num : ${ empty num }<br>
	<hr>
	
	<%
		int localData = 100;
		pageContext.setAttribute("pageData",100);
		request.setAttribute("data", 20);
	
	%>
	localData : ${localData}<br>
	pageData : ${pageScope.pageData}<br>
	request : ${requestScope.data }<br>
	
	<%-- scope영역을 정해주지않으면 가까운곳을 찾음 --%>
				${pageData }<br>
				${data}<br>

</body>
</html>