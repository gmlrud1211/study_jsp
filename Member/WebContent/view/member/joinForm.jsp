<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/member/join" method="post">
	<label>아이디<input type="text" name="userid" /></label><br>
	<label>닉네임<input type="text" name="nick" /></label><br>
	<label>이메일<input type="text" name="email" /></label><br>
	<input type="submit" value="회원가입" />
</form>

</body>
</html>