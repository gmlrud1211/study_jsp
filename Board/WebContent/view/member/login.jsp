<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<title>로그인 페이지</title>
	<jsp:include page="/view/layout/header.jsp" />
				
		<script type="text/javascript">
		$(document).ready(function() {
			$("input").eq(0).focus();
			
			$("#btnLogin").click(function() {
				$(this).parents("form").submit();
			})
			
			$("#btnCancel").click(function() {
				history.go(-1);
			})
		});
		</script>
		<style>
		h3 {
			text-align: center;
		}
		</style>			
	
		<h3 >로그인 페이지</h3>
		<hr>
		<div class="container">
			<form action="/member/login" method="post" class="form-horizontal">
				
				<div class="form-group">
					<label for="userid"  class="col-sm-3 col-sm-offset-1 control-label">아이디  </label>
					<div class="col-sm-5">
						<input type = "text" name = "userid" id="userid" size="10" placeholder="아이디 입력" class="form-control"/>
					</div>
				</div>

				<div class="form-group">
					<label for="userpw" class="col-sm-3 col-sm-offset-1 control-label">패스워드 : </label>
					<div class="col-sm-5">
						<input type="password" id ="userpw" name="userpw" placeholder="패스워드" class="form-control"/>
					</div>	
				</div>	
				
				<div class="col-sm-offset-4">		
					<button type="button" id="btnLogin" class="btn btn-primary">로그인</button>
					<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
				</div>
			</form>
		</div>
</html>