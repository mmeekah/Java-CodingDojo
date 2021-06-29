<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authorization</title>
<link rel="stylesheet" href="https://bootswatch.com/4/cosmo/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark text-light p-2 mb-5">
		<h1>Login</h1>
	</header>
	<main class="text-center">
		<h2>Welcome, <c:out value="${ user.firstName } ${ user.lastName }"/></h2>
		<a href="/logout" class="btn btn-warning">Logout</a>
	</main>
</body>
</html>