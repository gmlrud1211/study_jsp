<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일목록 리스트</title>
	</head>
	<body>
		
		<h3>파일목록 리스트</h3>
		<hr>
		
		<c:forEach items="${list}" var="l">
			<a href="/file/download?fileno=${l.fileno}">
				${l.originName}
			</a><br>
		</c:forEach>
	</body>
</html>