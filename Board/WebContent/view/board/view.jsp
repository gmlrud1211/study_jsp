<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<%@ page import="dto.member.Member" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 조회 페이지</title>
	</head>
	
	<jsp:include page="../layout/header.jsp"/>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$("#btnList").click(function() {
			$(location).attr("href", "/board/paginglist");
		});
		$("#btnUpdate").click(function() {
			$(location).attr("href", "/board/update?boardno=${boardView.boardno }");
		});
		$("#btnDelete").click(function() {
			$(location).attr("href", "/board/delete?boardno=${boardView.boardno }");
		});
	});
	</script>
		
	<body>
	
		<hr>
		<h2>게시글 상세조회</h2>
		<hr>
		
				
		<div>
		<table class="table table-bordered">
			<tr>
				<td class="info">글번호</td><td>${view.boardno }</td>
				<td class="info">제목</td><td colspan="2">${view.title }</td>
			</tr>
		
			<tr>
				<td class="info">아이디</td><td>${view.writer }</td>
				<td class="info">닉네임</td><td colspan="2">[추가]</td>
			</tr>
		
			<tr><td class="info">본문</td><td colspan="4">${view.content }</td></tr>
		
			<tr>
				<td class="info">조회수</td><td>${view.hit }</td>
				<td class="info">추천수</td><td>[추가]</td>
			</tr>
		
			<tr>
				<td class="info">작성일</td><td colspan="4">${view.writtendate }</td>
			</tr>
		</table>
		</div>
		
		<div class="text-center">	
			<button id="btnList" class="btn btn-primary">목록</button>
			<button id="btnUpdate" class="btn btn-info">수정</button>
			<button id="btnDelete" class="btn btn-danger">삭제</button>
		</div>
		
	</body>
</html>