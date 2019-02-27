<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.member.Member" %> 

	<meta charset="UTF-8">
	<title>글쓰기 form</title>
	
	<jsp:include page="../layout/header.jsp"/>
	
	 <script type="text/javascript">
		$(document).ready(function() {
			$("input").eq(0).focus();
			
			$("#btnWrite").click(function() {
				$(this).parents("form").submit();
			})
			
			$("#btnCancel").click(function() {
				history.go(-1);
			})
		});
	</script>
	<style>
	h4{ text-align : center;}
	
	</style>
	
	<div class="container">
		<h4>게시글 작성</h4>
		<hr>
		
		<div>
		
			<form action="/board/write" method="post">
			
			
			
			
			</form>
		
		</div>
					

		<div class="text-center">	
			<button id="btnList" class="btn btn-primary">목록</button>
			<button id="btnList" class="btn btn-primary">등록</button>
			
		</div>
			
	</div>
	
	
	<jsp:include page="../layout/footer.jsp"/>		
	