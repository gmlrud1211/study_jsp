<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
	<h1>JSTL c:foreach</h1>
	<hr>
	
	<%--step의 기본값은 1--%>
	<c:forEach var="i" begin="1" end="10">
		${i}<br>
	</c:forEach>
	
	<hr>
	
	<c:set var="sum" value="0"/> <%--총합변수 --%>
	<c:forEach var="i" begin="1" end="100">
		<c:set var="sum" value="${sum+i }"></c:set>
	</c:forEach>
	
	1~100의 합 : ${sum }<br>

	<hr>
	
	<% 
		Map<Integer, String> map = new HashMap<>(); 
		map.put(1, "heekyoung");
		map.put(2, "yeahree");
		map.put(3, "dongwon");
	%>	
	
	<c:forEach var="item" items="<%=map %>">
		${item.key} : ${item.value}<br>
	</c:forEach>
	
	<hr> 
	    
	<% request.setAttribute("m", map); %> <%--controller가 뷰에게 전달해주는 상황에 자주 씀 --%>
	
	<%--컨텍스트에 들어있는 정보는 EL이용해서 처리 --%>
	<c:forEach var="iter" items="${m }">
		${iter.key} : ${iter.value}<br>
	</c:forEach>
	
	<hr>
	<% List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("graph");
		list.add("strawberry");		
	%>
		
	
	<c:forEach var="item" items="<%=list %>" begin="0" end="4" step="1" varStatus="stat">
		<%--1번째 인덱스(begin)부터 시작햇으니 apple은 안나옴 --%>
		${item }<br>  
		루프 중 현재 인덱스 : ${stat.index }<br>
		루프 실행 횟수 : ${stat.count }<br><br>
		
		first : ${stat.first }<br>
		last : ${stat.last }<br>
		step : ${stat.step }<br>
		
		<c:if test="${stat.first }">첫줄</c:if><br>
		<c:if test="${stat.last }">마지막줄</c:if><br>

		----------------<br>
		
	</c:forEach>

	
	</body>
</html>