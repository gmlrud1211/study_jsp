<%@page import="sun.rmi.server.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 정보입력 폼</title>
	</head>
	<body>
		<h2>로그인 정보 입력 form</h2>
		<hr>
	
			<form action="/login/login" method="post">
				
				<label for="uId">아이디 : </label>
				<input type = "text" name = "userId" id="userId" size="10" placeholder="아이디 입력"/>
				<br><br>
				
				<label for="userPw">패스워드 : </label>
				<input type="password" id ="userPw" name="userPw" placeholder="패스워드"/>
				<br><br>
				
				<input type="submit" value="로그인"/>
				
			</form>
			
				
	
	</body>
</html>