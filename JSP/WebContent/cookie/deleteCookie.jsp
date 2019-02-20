<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Cookie</title>
	</head>
	<body>
		<h2>Cookie 삭제 페이지</h2>
		<hr>
	
		<%-- setMaxAge()를 이용하여 maxAge를 0초로 설정한다. --%>
		<%
			Cookie[] cookies  = request.getCookies();
		
			for(int i=0; i<cookies.length; i++){
				cookies[i].setMaxAge(5); //5초뒤에 삭제
				
				cookies[i].setMaxAge(365*24*60*60); //1년보관
				
				response.addCookie(cookies[i]);//브라우저에 쿠키반영
			}
		
		%>
		
		<h3><a href="main.jsp">메인으로</a></h3>
		<h3><a href="viewCookie.jsp">쿠키확인</a></h3>
		<h3><a href="updateCookie.jsp">쿠키수정</a></h3>
		<h3><a href="deleteCookie.jsp">쿠키삭제</a></h3>
	
	
	
	
	
	</body>
</html>