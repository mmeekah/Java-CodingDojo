<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.codingdojo.web.models.Person"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Person Page</title>
</head>
<body>
	<%Person person = (Person) request.getAttribute("person");%>
	<h1>Hello World!</h1>
	<h1><%= person.greeting() %></h1>
	
	<!-- http://localhost:8080/MVC_Setup/ShowPerson?name=MikaAitas&age=27 -->
</body>
</html>