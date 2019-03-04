<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>계산기</title>
		
		<script type="text/javascript" src="/js/httpRequest.js"></script>
		<script type="text/javascript">
		
		//AJAX 요청함수
		function helloToServer(){
			var method = "post";
			var url = "/ajax/ajax_03_ok.jsp";
			var params = "name="+document.f.name.value;
			
			sendRequest(method, url, params, helloFromServer);			
			
		}
		//AJAX 응답 처리 callback 함수
		function helloFromServer(){
			if(httpRequest.readyState ==4){ //done
				if(httpRequest.status ==200){ //ok
					alert("서버응답 : "+httpRequest.responseText);
					
				}
				
			}
		}
		
		</script>
		
	</head>
	<body>
			
		<form name="f">
			<input type="text" name="name" />
			<button type="button" onclick="helloToServer();">전송</button>
		</form>
		
	</body>
</html>