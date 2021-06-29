<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Ninja</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2">
		<h1 class="text-light">Dojos & Ninjas</h1>
		<a href="/dojos" class="btn btn-info">View Dojos</a>
		<a href="/ninjas" class="btn btn-info">View Ninjas</a>
		<a href="/dojos/new" class="btn btn-info">Add Dojo</a>		
	</header>
	<main class="text-center mt-5">
		<h1 class="mb-5">Add a New Ninja</h1>
		<form:form class="form w-50 m-auto" action="/ninjas" method="POST" modelAttribute="ninja">
			<div class="form-group row">
				<div class="col-4"></div>
				<form:input class="form-control col-4" path="firstName" placeholder="First Name"/>
				<form:errors class="text-danger col-4" path="firstName"/>
			</div>
			<div class="form-group row">
				<div class="col-4"></div>
				<form:input class="form-control col-4" path="lastName" placeholder="Last Name"/>
				<form:errors class="text-danger col-4" path="lastName"/>
			</div>
			<div class="form-group row">
				<form:label class="col-4" path="age">Age:</form:label>
				<form:input class="form-control col-4" type="number" path="age" placeholder="age"/>
				<form:errors class="text-danger col-4" path="age"/>
			</div>
			<div class="form-group row">
				<div class="col-4"></div>
				<form:select class="form-control col-4" path="dojo">
					<c:forEach items="${ dojos }" var="dojo">
					<option value=${ dojo.id }>${ dojo.name }</option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" class="btn btn-success" value="Add Ninja"> 
		</form:form>
	</main>
</body>
</html>