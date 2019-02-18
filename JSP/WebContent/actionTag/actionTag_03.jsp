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
<hr>

<jsp:include page="/basicTag/jsp_05_header.jsp" />

<jsp:include page="actionTag_03_include.jsp" >
	<jsp:param value="data" name="include" />
</jsp:include>

<jsp:include page="/basicTag/jsp_05_footer.jsp" />

<%--include 지시자는 요청파라미터를 전달불가하다 --%>

</body>
</html>