<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>스크립트표기법/ EL표기법</h1>
	
	<%="<h2>표현식,EL</h2>" %>
	<h2><%="표현식,EL" %></h2>

	<hr>
	
	${"<h2>표현식,EL</h2>"}
	<h2>${"표현식,EL"}</h2>
	
</body>
</html>