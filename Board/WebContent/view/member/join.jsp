<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 페이지</title>
	</head>
	<body>
		<h2>회원가입페이지</h2>
		<hr>
		
		<form action="/member/join" method="post">
				
				<label for="userid">아이디 : </label>
				<input type = "text" name = "userid" id="userid" size="10" placeholder="아이디 입력"/>
				<br><br>
				
				<label for="userpw">패스워드 : </label>
				<input type="password" id ="userpw" name="userpw" placeholder="패스워드 입력"/>
				<br><br>
				
				<label for="usernick">닉네임 : </label>
				<input type="text" id ="usernick" name="usernick" placeholder="닉네임 입력"/>
				<br><br>
					
				<input type="submit" value="회원가입" />
				
		</form>
		
		
		
	</body>
</html>