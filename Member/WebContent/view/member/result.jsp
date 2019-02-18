<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	boolean joinResult = (boolean) request.getAttribute("joinResult");
	if( joinResult ) { %>
		<h1>회원가입 성공</h1>
<%	} else { %>
		<h1>회원가입 실패</h1>
<%	} %>
<hr>
<h3><a href="/member/join">회원가입화면으로 가기</a></h3>

</body>
</html>