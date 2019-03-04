<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>계산기</title>
		<script type="text/javascript">
		
		//AJAX 객체 (XHR)생성 함수
		function createXMLHttpRequest() {
			var xmlReq = null;
			
			if(window.XMLHttpRequest) { //IE 7.0이상, IE아닌 브라우저가 반응하는 코드
				xmlReq = new XMLHttpRequest();
			} else if(window.ActiveXObject){
				try{
					//최근의 IE일때
					xmlReq = new ActiveXObject("Msxml2.XMLHTTP");	
				} catch(e1){
					try {
						//오래된 IE일때
						xmlReq = new ActiveXObject("Microsoft.XMLHTTP")
					} catch(e2) {
						//XHR없을 ㄸ ㅐ아무동작 안함
					}
				}
			}
			return xmlReq;
		}
		
		var xmlHttp =null;
		
		function send(){
			xmlHttp = createXMLHttpRequest(); //플랫폼 따라서 동작이 달라짐
			//입력 데이터 거내오기
			var n1 = num1.value;
			var n2 = num2.value;
			var op = oper.value;
			
			console.log(n1);
			console.log(n2);
			console.log(op);   
			
			//  요청 전 설정
			
			//  서버의 응답을 처리할 callback 함수 지정
			//  응답 데이터를 처리하는 함수
			//--------------------------
			xmlHttp.onreadystatechange = callback; 
			//--------------------------
			
			//요청 URL
			var query = "num1="+n1+"&num2="+n2+"&oper="+op;
			var url = "/ajax/ajax_02_ok.jsp"+"?"+query;
			
			//요청 메소드
			var method="get";
			
			
			//----------------------------
			//요청 준비
			xmlHttp.open(method, url);
			//-------------------
			
			//요청 전송
			xmlHttp.send(null);
			
			
		}
		//XHR요청에 대한 응답 처리함수
		function callback() {
			console.log("xhr 응답 완료");
			
			if(xmlHttp.readyState == 4){ //응답 완료
				if(xmlHttp.status==200){
					console.log("정상 응답");
					printData(); //정상응답시 처리함수
					
				} else if(xmlHttp.status == 404) {
					console.log("페이지없음");
				} else {
					//200or404아닐대
					console.log(xmlHttp.statusText);
				}
			}
		}
		function printData(){
			console.log("정상응답 (200) 처리함수 printData 호출됨!");
			
			//응답데이터
			var res = xmlHttp.responseText;
			//결과가 반영될 div
			var layout = result;
			//결과 반영
			layout.innerHTML = res;
		}
		
		
		
		</script>
		
	</head>
	<body>
		<h2>계산기</h2>
		<hr>
			<input type="text" id="num1" />
			<select id="oper" >
				<option value="add">더하기</option>
				<option value="sud">빼기</option>
				<option value="mul">곱하기</option>
				<option value="div">나누기</option>
			</select>
			<input type="text" id="num2" />
			<button onclick="send();">=</button>
			<hr>
			<div id="result">
			</div>			
	</body>
</html>