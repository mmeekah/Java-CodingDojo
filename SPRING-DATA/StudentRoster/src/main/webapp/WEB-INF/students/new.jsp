<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
		<a href="/" class="btn btn-primary">Home</a>
	</header>
	<main class="text-center">
		<h2 class="mb-5">Add New Student</h2>
		<form:form class="form w-50 m-auto" action="/students" method="POST" modelAttribute="student">
			<div class="form-group row">
				<form:label class="col-3" path="firstName">First Name</form:label>
				<form:input class="form-control col-5" path="firstName"/>
				<form:errors class="col-4 text-danger" path="firstName"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="lastName">Last Name</form:label>
				<form:input class="form-control col-5" path="lastName"/>
				<form:errors class="col-4 text-danger" path="lastName"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="age">Age</form:label>
				<form:input class="form-control col-5" type="number" min="1" max="120" path="age"/>
				<form:errors class="col-4 text-danger" path="age"/>
			</div>
			<input type="submit" class="btn btn-success mt-5" value="Add Student">
		</form:form>
	</main>	
</body>
</html>