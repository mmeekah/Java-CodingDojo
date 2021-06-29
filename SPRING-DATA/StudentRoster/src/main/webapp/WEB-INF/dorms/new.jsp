<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Dormitory</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
		<a href="/" class="btn btn-primary">Home</a>
	</header>
	<main class="text-center">
		<h2 class="mb-5">Add New Dormitory</h2>
		<form:form class="form w-50 m-auto" action="/dorms" method="POST" modelAttribute="dorm">
			<div class="form-group row">
				<form:label class="col-3" path="name">Dorm Name</form:label>
				<form:input class="form-control col-5" path="name"/>
				<form:errors class="col-4 text-danger" path="name"/>
			</div>
			<input type="submit" class="btn btn-success mt-5" value="Add Dorm">
		</form:form>
	</main>	
</body>
</html>