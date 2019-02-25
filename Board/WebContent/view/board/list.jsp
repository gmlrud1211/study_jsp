<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		<table>
		<thead>
			<tr>
				<th style="width: 10%">번호</th>
				<th style="width: 45%">제목</th>
				<th style="width: 20%">작성자</th>
				<th style="width: 10%">조회수</th>
				<th style="width: 20%">작성일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.boardno }</td>
					<td><a href="/board/view?boardno=${board.boardno }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.hit }</td>
					<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	
		</table>


		
	</body>
</html>