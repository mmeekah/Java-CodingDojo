<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h1>Registration</h1>
		<a href="/login" class="btn btn-primary">Login</a>
	</header>
	<main class="text-center">
		<form:form class="w-50 m-auto" action="/register" method="POST" modelAttribute="user">
			<div class="form-group row">
				<form:label class="col-3" path="firstName">First Name</form:label>
				<form:input class="form-control col-5" path="firstName"/>
				<form:errors class="text-danger col-4" path="firstName"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="lastName">Last Name</form:label>
				<form:input class="form-control col-5" path="lastName"/>
				<form:errors class="text-danger col-4" path="lastName"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="email">Email</form:label>
				<form:input class="form-control col-5" path="email"/>
				<form:errors class="text-danger col-4" path="email"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="password">Password</form:label>
				<form:input type="password" class="form-control col-5" path="password"/>
				<form:errors class="text-danger col-4" path="password"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="passwordConfirmation">Confirm Password</form:label>
				<form:input type="password" class="form-control col-5" path="passwordConfirmation"/>
				<form:errors class="text-danger col-4" path="passwordConfirmation"/>
			</div>
			<input type="submit" class="btn btn-success" value="Register">
		</form:form>
	</main>
</body>
</html>