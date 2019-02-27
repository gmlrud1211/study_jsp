<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.member.Member" %> 

	<meta charset="UTF-8">
	<title>글쓰기 form</title>
	
	<jsp:include page="../layout/header.jsp"/>
	
	 <script type="text/javascript">
		$(document).ready(function() {
			$("#btnWrite").click(function() {
				$("form").submit();
			})
			
			$("#btnCancel").click(function() {
				history.go(-1);
			}) 
		});
	</script>
	<style>
	h4{ text-align : center; }
	
	#content { width :100% }
	
	</style>
	
	<div class="container">
		<h4>게시글 작성</h4>
		<hr>
		
		<div>
		
			<form action="/board/write" method="post">
			<table class="table table-bordered">
				<tr><td class="info">아이디</td> <td> ${writer}</td></tr>
				<tr><td class="info">닉네임</td> <td> ${nick}</td></tr>
				<tr><td class="info">제목</td> 
					<td> <input type="text" name="title" style="width:100%"/></td>
				</tr>
				<tr><td class="info" colspan="2">본문</td></tr>
				<tr>
					<td colspan="2">
						<textarea id="content" name="content"></textarea>
					</td>
				</tr>
	
			</table>
			

			<div class="text-center">	
				<button type="button" id="btnWrite" class="btn btn-primary">등록</button>
				<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
			</div>
			
		</form>
		
	</div>
			
	</div>
	
	
	<jsp:include page="../layout/footer.jsp"/>		
	