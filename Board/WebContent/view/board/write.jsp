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
	h3{ text-align : center;}
	
	</style>
	
	<div class="container">
		<h3>게시글 작성</h3>
		<hr>
		<form action="/board/write" method="post" class="form-horizontal">
			<div class="form-group" >
				<label for="boardno" class="col-sm-3 col-sm-offset-1 control-label">글번호</label>
				<div class="col-sm-5">
					<input type="text" id="boardno" name="boardno" class="form-control" value="board_seq.nextval" readonly="readonly"/>
				</div>
			</div>
		
			<div class="form-group">
				<label for="title" class="col-sm-3 col-sm-offset-1 control-label">글제목</label>
				<div class="col-sm-5">
					<input type="text" id="title" name="title" class="form-control"/>
				</div>
			</div>

			<div class="form-group" >
				<label for="wrtier" class="col-sm-3 col-sm-offset-1 control-label">작성자</label>
				<div class="col-sm-5">
					<input type="text" id="writer" name="writer" class="form-control" value="${writer }" readonly="readonly"/>
				</div>
			</div>
			
				
			<div class="form-group">
				<label for="content" class="col-sm-3 col-sm-offset-1 control-label">글내용</label>
				<div class="col-sm-5">
					<textarea name="content" cols="60" rows="10" class="form-control"></textarea>
				</div>
			</div>
				
			
			
			<div class="col-sm-offset-4">
				<button type="button" id="btnWrite" class="btn btn-primary">등록</button>
				<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
			</div>
					
		</form>
			
	</div>
	
	<jsp:include page="../layout/footer.jsp"/>		
	