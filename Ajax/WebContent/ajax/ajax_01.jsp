<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>계산기</title>
	</head>
	<body>
		<h2>계산기</h2>
		<hr>
		<form action="ajax_01_ok.jsp" method="post">
			<input type="text" name="num1" />
			<select name="op" >
				<option value="add">더하기</option>
				<option value="sud">빼기</option>
				<option value="mul">곱하기</option>
				<option value="div">나누기</option>
			</select>
			<input type="text" name="num2" />
			<input type="submit" name="=" />			
		</form>
		<hr>
		
	</body>
</html>