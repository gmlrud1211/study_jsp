<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member.Member" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MainPage</title>
	</head>
	<body>
		<h2>메인 페이지</h2>
		<hr>
		
		<!-- 로그인 안한 상태 -->
		<c:if test="">
			<a href="/member/join"><button>회원가입</button></a>
			<a href="/member/login"><button>로그인</button></a>
		</c:if>
		
				
	
	</body>
</html>