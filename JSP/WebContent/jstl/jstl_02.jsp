<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
	</head>
	<body>
	<h1>JSTL c:set</h1>
	<hr>
	
	<%--세가지 다 같은 코드임 / 맨 마지막줄로 적용 --%>
	<c:set var="sessionData" value="SESSION_SESSION" scope="session"></c:set>
	
	<% session.setAttribute("sessionData", "SESSION_SESSION"); %>

	<%
		//서블릿에서 작성할 경우
		request.getSession().setAttribute("sessionData", "SESSION_SESSION");
	%>
	
	sessionData 확인 : ${sessionData} <br>
	<a href="jstl_02_session.jsp">세션값 확인 페이지</a><br>

	<%-- User javaBean 생성 : 비어있는 객체 --%>
	<jsp:useBean id="userBean" class="dto.User"/>
	
	<%--자바빈에 값 넣기 --%>
	<c:set target="<%=userBean %>" property="id" value="hkhkhk"/>
	<jsp:setProperty name="userBean" property="pw" value="1111"/>

	<%--자바빈 프로퍼티 출력하기 --%>
	id : <c:out value="${userBean.id }" /><br>
	pw : <c:out value="<%=userBean.getPw() %>"/><br>
	pw : <c:out value="${userBean.getPw() }"/><br>
	
	<%--자바빈 세션 컨텍스트로 등록 --%>
	<c:set var="userSession" value="<%=userBean%>" scope="session"></c:set>	
	<% session.setAttribute("userSession", userBean); %>
	
	<%--map생성 --%>
	<% Map map = new HashMap(); %>
	
	<%-- Map에 jstl을 이용한  put --%>
	<c:set target="<%=map %>" property="A" value="heekyoung"/>
	<c:set target="<%=map %>" property="B" value="yeahree"/>
	
	A key : <c:out value='<%=map.get("A") %>'></c:out><br>
	<%--el로 처리하려면 컨텍스트 정보를 갖고있어야함 
		컨텍스트 정보가 아니기 때문에 EL로 처리불가능 --%>
	B key : ${map.get("B") }<br>
	
	[${map.A }:${map.B }]<br>
	<hr>
	<%--map을 session Attribute에 저장(컨텍스트 정보로 등록) --%>
	<c:set var="m" value="<%=map %>" scope="session"/>
	
	B key : ${m.get("B") }<br>
	
	[${m.A }:${m.B }]<br>
	
	
	</body>
</html>