<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Cookie 생성 페이지</h2>
		<hr>
	
		<%
		
			/* 서버가 클라이언트에게 보낼 쿠키 정보 생성 */
			Cookie c1 = new Cookie("ID","HAHA");//ID=HAHA
		
			/* 클라이언트에게 쿠키 정보 전송 */
			response.addCookie(c1);//없으면 setCookie로 들어가고 
			
		
			Cookie c2 = new Cookie("PASS","1234");
			response.addCookie(c2);
		
			response.addCookie(new Cookie("Name","heekoung"));
			
		%>
		
		<h3><a href="./viewCookie.jsp">쿠키 확인</a></h3>
	</body>
</html>