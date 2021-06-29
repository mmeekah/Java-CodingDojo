<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/solar/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Users & Friends</h1>
		<a href="/users" class="btn btn-primary">View Users</a>
		<a href="/users/new" class="btn btn-primary">Add User</a>
	</header>
	<main class="text-center">
		<form:form action="/users" method="POST" modelAttribute="user">
			<div class="form-group">
				<form:input path="firstName" placeholder="First Name"/>
			</div>
			<div class="form-group">
				<form:input path="lastName" placeholder="Last Name"/>
			</div>
			<input type="submit" class="btn btn-success" value="Add User">
		</form:form>
	</main>
</body>
</html>