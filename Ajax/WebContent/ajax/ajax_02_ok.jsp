<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
	<c:set var="n1" value="${param.num1 }"></c:set>
	<c:set var="n2" value="${param.num2 }"></c:set>
	<c:set var="oper" value="${param.oper}"></c:set>
	
	<c:choose>
		<c:when test="${oper eq 'add'}">
			${n1 }+${n2 }=${n1+n2 }
		</c:when>
		<c:when test="${oper eq 'sub'}">
			${n1 }-${n2 }=${n1-n2 }
		</c:when>
		<c:when test="${oper eq 'mul'}">
			${n1 }*${n2 }=${n1*n2 }
		</c:when>
		<c:when test="${oper eq 'div'}">
			${n1 }/${n2 }=${n1/n2 }
			<fmt:formatNumber value="${n1/n2 }" pattern="0.00" />
		</c:when>
	</c:choose>
