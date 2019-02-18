<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ActionTag</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<%
	//스크립트릿 이용한 객체 생성
	User user1 = new User();
	user1.setId("ID1");
	user1.setPw("1234");
	
	session.setAttribute("user1",user1);
%>
User1 : <%=user1 %>
<hr>

<!-- 액션태그를 이용한 자바빈 생성  -->
<jsp:useBean id="user2" class="dto.User" scope="request" />

<%-- user2 자바빈에 아이디 값 설정하기 --%>
<jsp:setProperty property="id" name="user2" value="ha"/>
User2 : <%=user2 %>

<br>
<%--user2 자바빈에 id값 가져오기 --%>
user2 id 가져오기 -> <jsp:getProperty property="id" name="user2"/>


</body>
</html>