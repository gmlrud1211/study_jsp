<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Hello JSP!</h3>
<hr>
<%
	String scriptlet = "HI";
	System.out.println(scriptlet);
	
	response.getWriter().append("write : " + scriptlet);

	for(int i=0; i<3; i++) {
		out.append("<h3>제어문</h3>");
	}
	
// 	public void method() {
		// _jspService() 메소드 내부에 생성되므로 정의 불가
// 	}
%>

<%	for(int i=0; i<3; i++) { %>
	<h3>스크립트립 + HTML</h3>
<%	} %>

</body>
</html>
















