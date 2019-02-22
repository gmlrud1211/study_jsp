<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>로그인 정보 입력 form</h2>
		<hr>
			<form action="/member/login" method="post">
				
				<label for="userId">아이디 : </label>
				<input type = "text" name = "userId" id="userId" size="10" placeholder="아이디 입력"/>
				<br><br>
				
				<label for="userPw">패스워드 : </label>
				<input type="password" id ="userPw" name="userPw" placeholder="패스워드"/>
				<br><br>
				
				<input type="submit" value="로그인"/>
				
			</form>
		

	
	</body>
</html>