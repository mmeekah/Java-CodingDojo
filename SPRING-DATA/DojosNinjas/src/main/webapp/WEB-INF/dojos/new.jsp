<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Dojo</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2">
		<h1 class="text-light">Dojos & Ninjas</h1>
		<a href="/dojos" class="btn btn-info">View Dojos</a>
		<a href="/ninjas" class="btn btn-info">View Ninjas</a>
		<a href="/ninjas/new" class="btn btn-info">Add Ninja</a>
	</header>
	<main class="text-center mt-5">
		<h1 class="mb-5">Add a New Dojo</h1>
		<form:form class="form w-50 m-auto" action="/dojos" method="POST" modelAttribute="dojo">
			<div class="form-group row">
				<div class="col-4"></div>
				<form:input class="form-control col-4" path="name" placeholder="Dojo Name"/>
				<form:errors class="text-danger col-4" path="name"/>
			</div>
			<div class="form-group row">
				<div class="col-4"></div>
				<form:input class="form-control col-4" path="city" placeholder="City"/>
				<form:errors class="text-danger col-4" path="city"/>
			</div>
			<div class="form-group row">
				<div class="col-4"></div>
				<form:input class="form-control col-4" path="state" placeholder="State"/>
				<form:errors class="text-danger col-4" path="state"/>
			</div>
			<input type="submit" class="btn btn-success" value="Add Dojo"> 
		</form:form>
	</main>
</body>
</html>