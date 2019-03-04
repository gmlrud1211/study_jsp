<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>ㅎㅎㅎ</title>
		
		<script type="text/javascript" src="/js/httpRequest.js"></script>
		<script type="text/javascript">
		
		//AJAX 요청함수
		function helloToServer(){
			var method = "post";
			var url = "/ajax/ajax_04_ok.jsp";
			var params = "name="+document.f.name.value;
			var paramss = ", "+document.f.content.value;
			param = params+paramss;
			
			sendRequest(method, url, param, helloFromServer);			
			
		}
		
		//AJAX 응답 처리 callback 함수
		function helloFromServer(){
			if(httpRequest.readyState ==4){ //done
				if(httpRequest.status ==200){ //ok
					alert("서버응답 : "+httpRequest.responseText);
					printData();
					
				}
				
			}
		}
		
		
		function printData(){
			console.log("정상응답 (200) 처리함수 printData 호출됨!");
			
			//응답데이터
			var res = httpRequest.responseText;
			//결과가 반영될 div
			var layout = result;
			//결과 반영
			layout.innerHTML += res;
		}
		
		
		
		</script>
		
	</head>
	<body>
			
		<form name="f" >
			이름 : <input type="text" name="name" /><br><br>
			내용 : <textarea name="content"></textarea><br><br>
			<button type="button" onclick="helloToServer();">전송</button>
		</form>
		<div id="result">
		</div>
	</body>
</html>