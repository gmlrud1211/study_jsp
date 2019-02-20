<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Cookie</title>
	</head>
	<body>
		<h2>Cookie 생성확인 페이지</h2>
		<hr>
	
		<%-- 쿠키는 서블릿이 관리해야함 --%>
		<%
			//쿠키정보 얻어오기
			Cookie[] cookies = request.getCookies();
		%>
		쿠키 갯수 : <%=cookies.length %><br>
		<% for(int i=0; i<cookies.length; i++) { %>
				<%=cookies[i].getName()+"="+cookies[i].getValue() %><br>
		<% } %>
		
		<%--쿠키 객체.getName() : 쿠키 이름(변수명)--%>
		<%--쿠키 객체.getValue() : 쿠키 값(변수값)--%>	
				
		<h3><a href="main.jsp">메인으로</a></h3>
		<h3><a href="createCookie.jsp">쿠키생성</a></h3>
		<h3><a href="updateCookie.jsp">쿠키수정</a></h3>
		<h3><a href="deleteCookie.jsp">쿠키삭제</a></h3>
	
	
		<hr>
		${cookie }<br>
		<hr>
		${cookie.ID }<br>	
		${cookie.ID.value }<br>	
	
		<hr>

		<c:forEach items="${cookie }" var="c">
			${c.key } : ${c.value.value }<br>
			<%--property 이름만 쓰면 알아서 가져다줌 
				c.value.[value]-> getValue() / get("value"); --%>
		</c:forEach>
	
	</body>
</html>