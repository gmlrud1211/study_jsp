<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<meta charset="UTF-8">
		<title>회원가입 페이지</title>
		<jsp:include page="/view/layout/header.jsp" />
				
		<script type="text/javascript">
		$(document).ready(function() {
			$("input").eq(0).focus();
			
			$("#btnJoin").click(function() {
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
		
		
	<div class="container">
		<h3>회원가입페이지</h3>
		<hr>
		<div>
			<form action="/member/join" method="post" class="form-horizontal">
					
				<div class="form-group">
					<label for="userid" class="col-sm-3 col-sm-offset-1 control-label">아이디</label>
					<div class="col-sm-5">
						<input type="text" id="userid" name="userid" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="userpw" class="col-sm-3 col-sm-offset-1 control-label">패스워드</label>
					<div class="col-sm-5">
					<input type="password" id="userpw" name="userpw" class="form-control"/>
					</div>
				</div>
					
				<div class="form-group">
					<label for="usernick" class="col-sm-3 col-sm-offset-1 control-label">닉네임</label>
					<div class="col-sm-5">
					<input type="text" id="usernick" name="usernick" class="form-control"/>
					</div>
				</div>
					
				<div class="col-sm-offset-4">
					<button type="button" id="btnJoin" class="btn btn-primary">가입</button>
					<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
				</div>
				
		</form>
	</div>
	</div>	
	<jsp:include page="/view/layout/footer.jsp" />
