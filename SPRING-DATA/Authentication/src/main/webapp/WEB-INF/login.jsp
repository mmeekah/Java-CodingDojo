<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form class="w-50 m-auto" action="/login" method="POST" modelAttribute="loginUser">
			<div class="form-group row">
				<form:label class="col-3" path="email">Email</form:label>
				<form:input type="email" class="form-control col-5" path="email"/>
				<form:errors class="text-danger col-4" path="email"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="password">Password</form:label>
				<form:input type="password" class="form-control col-5" path="password"/>
				<form:errors class="text-danger col-4" path="password"/>
			</div>
			<input type="submit" class="btn btn-success" value="Login">
		</form:form>
		<c:if test="${ error != null }">
		<p class="text-danger"><c:out value="${ error }"/></p>
		</c:if>
	</main>
</body>
</html>