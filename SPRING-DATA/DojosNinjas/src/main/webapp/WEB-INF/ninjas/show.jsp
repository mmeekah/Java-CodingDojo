<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Info</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1 class="text-light">Dojos & Ninjas</h1>
		<a href="/dojos" class="btn btn-info">View Dojos</a>
		<a href="/ninjas" class="btn btn-info">View Ninjas</a>
		<a href="/dojos/new" class="btn btn-info">Add Dojo</a>
		<a href="/ninjas/new" class="btn btn-info">Add Ninja</a>
	</header>
	<main class="text-center w-25 m-auto">
		<h1 class="mb-5"><c:out value="${ ninja.firstName } ${ ninja.lastName }"/></h1>
		<div class="row">
			<div class="col">
				<h3>Age</h3>
			</div>
			<div class="col">
				<h3>Dojo</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3><c:out value="${ ninja.age }"/></h3>
			</div>
			<div class="col">
				<h3><a href="/dojos/${ ninja.dojo.id }"><c:out value="${ ninja.dojo.name }"/></a></h3>
			</div>
		</div>
	</main>
</body>
</html>