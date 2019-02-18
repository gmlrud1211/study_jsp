<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 표현식, Expression --%>
<h3>하하하!</h3>

<%
	int num = 123;
	out.print(num); //브라우저 출력(HTML에 포함)
	System.out.println(num); //콘솔 출력
%>

<%=num %>

</body>
</html>



















