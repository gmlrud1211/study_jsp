<%@page import="dto.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

/emp/view TEST

<%	List<Emp> list = (List) request.getAttribute("list");
	for(int i=0; i<list.size(); i++) { %>

	<h3><%=list.get(i).getEmpno() %></h3>

<%	} %>

</body>
</html>

















