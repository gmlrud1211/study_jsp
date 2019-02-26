<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>파일 업로드 페이지</title>
	</head>
	<body>
	
		<h3>파일 업로드</h3>
		<hr>
		
			<!--  enctype="application/x-www-form-urlencoded" -->
				<!-- form 데이터를 기본적인 쿼리스트링 평태로 인코딩 -->
				<!-- title=123123&name=ABCDE -->
				
			<!--  enctype="multipart/form-data" -->
				<!-- file을 서버로 전송하기 위해 사용하는 인코딩 -->
				<!-- 파일의 내용을 서버로 전송해준다.  -->
				
				
		<form action="/file/upload" method="post" enctype="multipart/form-data">
	
			<label>제목 :  <input type="text" name="title"/></label><br><br>
			<label>첨부 :  <input type="file" name="uploadFile"/></label><br><br>			
			<input  type="submit" value="업로드"/><br>
				
		</form>
	</body>
</html>