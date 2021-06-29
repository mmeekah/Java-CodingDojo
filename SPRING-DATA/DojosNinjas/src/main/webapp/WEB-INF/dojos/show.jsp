<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Info</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="/js/showdojo.js"></script>
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
		<h1 class="mb-5"><c:out value="${ dojo.name }"/></h1>
		<div class="row">
			<div class="col">
				<h3>City</h3>
			</div>
			<div class="col">
				<h3>State</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3><c:out value="${ dojo.city }"/></h3>
			</div>
			<div class="col">
				<h3><c:out value="${ dojo.state }"/></h3>
			</div>
		</div>
		<h3 class="mt-5">Students</h3>
		<table class="table table-striped w-50 m-auto">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ dojo.ninjas }" var="ninja">
				<tr data-href="/ninjas/${ ninja.id }">
					<td>${ ninja.firstName } ${ ninja.lastName }</td>
					<td>${ ninja.age }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>