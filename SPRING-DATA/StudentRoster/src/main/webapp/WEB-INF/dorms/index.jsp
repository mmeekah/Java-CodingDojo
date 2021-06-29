<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Dorms</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="/js/show.js"></script>
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
		<a href="/" class="btn btn-primary">Home</a>
		<a href="/dorms/new" class="btn btn-primary">Add Dorm</a>
	</header>
	<main class="text-center">
		<h2>All Dormitories</h2>
		<table class="table table-striped w-50 m-auto">
			<thead>
				<tr>
					<th>Name</th>
					<th># of Residents</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ dorms }" var="dorm">
				<tr data-href="/dorms/${ dorm.id }">
					<td>${ dorm.name }</td>
					<td>${ dorm.students.size() }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>
