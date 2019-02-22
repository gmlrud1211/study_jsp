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
		table {
			border-collapse : collapse;
			width:60%;
			margin : auto;
			text-align: center;
		}
		th, td {
			padding : 4px;
			border : 1px solid #ccc;
		}
		
		</style>
	</head>
	<body>
		<h2>게시글 조회</h2>
		<hr>
		
		<table border="1">
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>아이디</th>
				<th>작성일</th>			
				<th>조회수</th>
			</tr>
		
		<% Board b = (Board) request.getAttribute("view");%>
			
			<tr>
				<td><%=b.getBoardno() %></td>
				<td><%=b.getTitle() %></td>
				<td><%=b.getWriter() %></td>
				<td><%=b.getWrittendate() %></td>
				<td><%=b.getHit() %></td>
			</tr>
			<tr >
				<td colspan="5" height ="200px"><%=b.getContent() %> </td>
			</tr>			
			
		</table>
	</body>
</html>