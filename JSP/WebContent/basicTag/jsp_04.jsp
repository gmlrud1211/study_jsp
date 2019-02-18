<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//java.util.Calendar
	Calendar cal = Calendar.getInstance();
	System.out.println(cal);
%>

<%	// ctrl + space 를 import하려는 클래스에다가 적용
	//그러면 자동 import됨 -> page 지시자 태그로 추가됨
	List list = new ArrayList();
%>

<!-- HTML 주석 내에서 작성된 코드!!!
<%	System.out.println("HTML 주석 내에서 작성함");%>
	스크립트릿코드 아무 문제 없이 작동합니다
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>








