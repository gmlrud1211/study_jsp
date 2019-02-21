<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 조회 페이지</title>
		<style>
		h2 {
			text-align: center;			
		}
		
		</style>
	</head>
	<body>
		<h2>게시글 조회</h2>
		<hr>
			
		<% Board b = (Board) request.getAttribute("result");%>
		
		<%=b.getBoardno() %>
		<%=b.getTitle() %>
		<%=b.getWriter() %>
		<%=b.getContent() %>
		<%=b.getHit() %>
		<%=b.getWrittendate() %>
		
	</body>
</html>