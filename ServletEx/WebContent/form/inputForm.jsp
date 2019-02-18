<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Form</title>
	</head>
	<body>
		<div>
			<form action="/form.do" method="post">
				<label for="userId">아이디</label>
				<input type="text" id="userId" name="uId"/><br>
				
				<label for="userPw">비밀번호</label>
				<input type="text" id="userPw" name="uPw"/><br>
		
				<input type="submit" value="로그인"/><br>

			</form>
		</div>
		
	</body>
</html>