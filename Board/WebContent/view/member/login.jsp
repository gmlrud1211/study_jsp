<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		h2 {
			text-align: center;			
		}
		form {
			text-align:center;
		}
		</style>
	</head>
	<body>
		<h2>로그인 정보 입력 form</h2>
		<hr>
			<form action="/member/login" method="post">
				
				<label for="userid">아이디 : </label>
				<input type = "text" name = "userid" id="userid" size="10" placeholder="아이디 입력"/>
				<br><br>
				
				<label for="userpw">패스워드 : </label>
				<input type="password" id ="userpw" name="userpw" placeholder="패스워드"/>
				<br><br>
				
				<input type="submit" value="로그인"/>
				
			</form>
		

	
	</body>
</html>