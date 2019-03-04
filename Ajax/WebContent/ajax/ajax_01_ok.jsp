<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>계산기</title>
	</head>
	<body>

	<c:set var="n1" value="${param.num1 }"></c:set>
	<c:set var="n2" value="${param.num2 }"></c:set>
	<c:set var="op" value="${param.op}"></c:set>
	
	<c:choose>
		<c:when test="${op eq 'add'}">
			${n1 }+${n2 }=${n1+n2 }
		</c:when>
		<c:when test="${op eq 'sub'}">
			${n1 }-${n2 }=${n1-n2 }
		</c:when>
		<c:when test="${op eq 'mul'}">
			${n1 }*${n2 }=${n1*n2 }
		</c:when>
		<c:when test="${op eq 'div'}">
			${n1 }/${n2 }=${n1/n2 }
			<fmt:formatNumber value="${n1/n2 }" pattern="0.00" />
		</c:when>
	</c:choose>
	
	<h4><a href="#" onclick="history.go(-1)">뒤로가기</a></h4>

	</body>
</html>