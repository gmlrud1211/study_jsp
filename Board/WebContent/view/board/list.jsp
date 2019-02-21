<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 리스트 조회</title>
	</head>
	<body>
		<h2>게시판목록</h2>
		<hr>
		
		
		
	<%	List <Board> boardList = (List) request.getAttribute("boardList");
	
		for(int i=0; i<boardList.size(); i++) {  %>
	
		<h3><%=boardList.get(i).getBoardno() %></h3>
		<a href="/board/view?boardno=${boardno}"><h3><%=boardList.get(i).getTitle() %></h3></a>
		<h3><%=boardList.get(i).getWriter() %></h3>
		<h3><%=boardList.get(i).getContent() %></h3>
		<h3><%=boardList.get(i).getHit() %></h3>
		<h3><%=boardList.get(i).getWrittendate() %></h3>
	
	<%	} %>


		
	</body>
</html>