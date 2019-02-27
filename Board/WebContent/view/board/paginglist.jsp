<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.board.Board" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../layout/header.jsp" />

		<meta charset="UTF-8">
		<title>게시글 목록 페이지</title>
		
		<script type="text/javascript">
		$(document).ready(function() {
			$("table").on("click", "tr", function() {
				//클릭이벤트가 발생한 <tr>의 첫번째 <td>자식의 텍스트
				var boardno = $(this).children("td").eq(0).text();
				
				$(location).attr("href","/board/view?boardno="+boardno);
			});
			
			//글쓰기 버튼 이벤트
			$("#btnWrite").click(function() {
				location.href ="/board/write";
			});
			
		});
		</script>
		
		<style type="text/css">
		
		th, td:not(:nth-child(2)) {
			text-align: center;
		}
		td {
			border-left: 1px solid white;
			border-right: 1px solid white;
		}
		
		#btnBox {
			text-align : right;
		
		}
		</style>


	<div class="container">

	<hr>
	<h3>게시글 목록</h3>
	<hr>


	<table class="table table-hover table-striped table-condensed">
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
	
	</div>
	
	<jsp:include page="../layout/paging.jsp"/>

	<div id="btnBox">
		<button id="btnWrite" class="btn btn-primary">글쓰기</button>
	</div>
		
		
	<jsp:include page="../layout/footer.jsp"/>		
