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
	<h1>JSTL c:if</h1>
	<hr>
	
	<c:if test="true">
		<h3>true: 무조건 수행ㅎㅎ</h3>
	</c:if>
	
	<c:if test="${true }">
		<h3>true: 무조건 수행ㅎㅎ</h3>
	</c:if>
	
	<c:if test="${10 eq 10}">
		<h3>10 eq 10은 true</h3>
	</c:if>
	
	<c:if test="false">
		<h3>false: 무조건 수행하지않음</h3>
	</c:if>
	
	<c:if test="아무거나 넣어봄">
		<h3>true: 무조건 수행ㅎㅎ</h3>
		<h3>결과값 true 이외에는 전부 false 처리</h3>
	</c:if>
	
	<c:if test="${100 == 100 }"> 
		<h3>100==100은?</h3>
		<h3>EL내부에 띄어쓰기 주의</h3>
	</c:if>
	<hr>
	
	<% boolean bFlag = true; %>
	<c:if test="<%=bFlag %>">
		<h3>표현식으로 변수값 활용</h3>
	</c:if>
	
	<%--컨트롤러에서 뷰로 모델을 전달할경우 많이사용
	 --%>
	<% request.setAttribute("reqFlag", true); %>
	<c:if test="${reqFlag }">
		<h3>EL로 변수값 활용</h3>
	</c:if>
	</body>
</html>