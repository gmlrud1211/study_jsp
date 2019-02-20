<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
	</head>
	<body>
	<h1>JSTL fmt:formatDate</h1>
	<hr>
	
	<c:set var="now" value="<%=new Date()%>"/>
	<h3>type="date"</h3>
	now : ${now }<br>
	default : <fmt:formatDate value="${now }" type="date" dateStyle="default" /><br> <%--날짜만 나오는게 기본설정 --%>
	short : <fmt:formatDate value="${now }" type="date" dateStyle="short" /> <br>
	medium : <fmt:formatDate value="${now }" type="date" dateStyle="medium" /> <br>
	long : <fmt:formatDate value="${now }" type="date" dateStyle="long" /> <br>
	full : <fmt:formatDate value="${now }" type="date" dateStyle="full" /><br>
	<hr>
	<h3>type="time"</h3>
	
	default : <fmt:formatDate value="${now }" type="time" timeStyle="default"/><br>
	short : <fmt:formatDate value="${now }" type="time" timeStyle="short" /> <br>
	medium : <fmt:formatDate value="${now }" type="time" timeStyle="medium" /> <br>
	long : <fmt:formatDate value="${now }" type="time" timeStyle="long" /> <br>
	full : <fmt:formatDate value="${now }" type="time" timeStyle="full" /><br>
	
	<hr>
	<h3>pattern 적용</h3>
	YYYY/MM/dd : <fmt:formatDate value="${now }" type="time" pattern="YYYY/MM/dd" /><br>
	HH:mm:ss.S : <fmt:formatDate value="${now }" type="time" pattern="HH:hh:ss:S" /><br>
	hh:mm:ss.S : <fmt:formatDate value="${now }" type="time" pattern="hh:mm:ss:S" /><br>
	KK:mm:ss.S : <fmt:formatDate value="${now }" type="time" pattern="KK:mm:ss:S" /><br>
	kk:mm:ss.S : <fmt:formatDate value="${now }" type="time" pattern="kk:mm:ss:S" /><br>
	HH:mm:ss.a : <fmt:formatDate value="${now }" type="time" pattern="HH:mm:ss.a" /><br>
	
	Z : <fmt:formatDate value="${now }" type="time" pattern="Z" /><br>
	z : <fmt:formatDate value="${now }" type="time" pattern="z" /><br>
	X : <fmt:formatDate value="${now }" type="time" pattern="X" /><br>
	
	
	  
	</body>
</html>