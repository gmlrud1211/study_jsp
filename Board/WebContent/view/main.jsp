<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member.Member" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MainPage</title>
		
		<style type="text/css">
		
		h2 {
			text-align: center;			
		}
		</style>
		
	</head>
	<body>
		<h2>메인 페이지</h2>
		<hr>
		
		<!-- 로그인 안한 상태 -->
		<c:if test="${not login }">
			<a href="/member/join"><button>회원가입</button></a>
			<a href="/member/login"><button>로그인</button></a>
		</c:if>
		
		<!-- 로그인 한 상태 -->
		<c:if test="${login }">
			${userid }님 하이욤~<br>
			<a href="/board/list"><button>게시판 목록보기</button></a>
			<a href="/member/logout"><button>로그아웃</button></a>
		</c:if>
		
				
	
	</body>
</html>