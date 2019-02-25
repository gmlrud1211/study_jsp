<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
		<br>
		
		<jsp:include page="../layout/paging.jsp"/>

			
		<jsp:include page="../layout/footer.jsp"/>		

	</body>
</html>