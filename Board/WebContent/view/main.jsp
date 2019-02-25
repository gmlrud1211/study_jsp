<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member.Member" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

	<meta charset="UTF-8">

	<style>
	h3 {
		text-align: center;
	}
	</style>
		
	<jsp:include page="/view/layout/header.jsp" />

	<h3>메인 페이지</h3>
	<hr>
	<div style="text-align: center;">
		<!-- 로그인 안한 상태 -->
		<c:if test="${not login }">
			<p>로그인을 해주시오ㅠ___ㅠ</p>
			<a href="/member/join"><button>회원가입</button></a>
			<a href="/member/login"><button>로그인</button></a>
		</c:if>
		
		<!-- 로그인 한 상태 -->
		<c:if test="${ login }">
			
			<a href="/board/paginglist"><button>게시판 목록보기</button></a>
			<a href="/member/logout"><button>로그아웃</button></a>
		</c:if>
			
	</div>
	
	<jsp:include page="/view/layout/footer.jsp" />
			