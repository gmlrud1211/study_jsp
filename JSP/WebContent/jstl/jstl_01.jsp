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
	<h1>JSTL c:out</h1>
	<hr>
	
	<c:out value="하이용" /><br>
	<c:out value="${empty elValue}"></c:out><br> <!--el은 만들어지지않은 변수를 사용할 때 null값 취급 -->
	<c:out value='<%="하이용"%>'></c:out><br>
	<hr>
	
	<c:out value="${elValue}" default="elValue 변수는 null"></c:out>
	<hr>
	
	<c:out value="<h3>태그 출력</h3>" ></c:out><br>
	<c:out value="<h3>태그 출력</h3>" escapeXml="false"></c:out>
	<hr>
	<% session.setAttribute("str", "문자열1"); %>
	<c:out value="${str}" ></c:out><br>
	<c:out value="${sessionScope.str}"></c:out><br>
	${str}
	
	<hr>
	<% String str2 = "test 문자열";  %> <%-- 지역변수 영역 --%>
	str2 : <c:out value="${str2}"></c:out> <%-- 영역이 다르기때문에 가져올수 없다 --%>
	
	<hr>
	
	<%-- JSTL은 속성의 값으로는 expression이나 el만 사용해야함 --%>
	<c:out value="<%=123 %>"></c:out> <%-- expression 사용 --%>
	<c:out value="<%=\"hk\" %>"></c:out>
	<c:out value= '<%="heekyoung" %>'></c:out>
	<br>
	
	<%--스크립트릿으로 사용하면 JSTL에선 동작안함 --%>
	<c:out value='<% out.print("희경"); %>'></c:out>
	
	
	</body>
</html>