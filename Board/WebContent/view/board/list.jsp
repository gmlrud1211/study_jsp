<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 리스트 조회</title>
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
		<h2>게시판목록</h2>
		<hr>
		<table border="1">
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
				<th>아이디</th>
				<th>조회수</th>			
				<th>작성일</th>
			</tr>
		
	<%	List <Board> boardList = (List) request.getAttribute("boardList");
	
		for(int i=0; i<boardList.size(); i++) {  %>
		<tr>	
			<td><h4><%=boardList.get(i).getBoardno() %></h4></td>
			<td><a href="/board/view?boardno=<%=boardList.get(i).getBoardno() %>"><h4><%=boardList.get(i).getTitle() %></h344></a></td>
			<td><h4><%=boardList.get(i).getWriter() %></h4></td>
			<td><h4><%=boardList.get(i).getHit() %></h4></td>
			<td><h4><%=boardList.get(i).getWrittendate() %></h4></td>
	<%	} %>
			
		
		</table>
		
		


		
	</body>
</html>