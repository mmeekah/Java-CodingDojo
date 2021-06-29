<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!</h1>
	
	<% String req = request.getParameter("name"); %>
    <!-- displaying the value -->
    <h1><%= req %></h1>
    
    <!-- //http://localhost:8080/SimpleProject/NewFile.jsp?name=Mika -->
</body>
</html>