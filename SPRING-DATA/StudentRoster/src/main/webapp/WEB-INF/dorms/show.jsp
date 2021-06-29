<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dormitory Info</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
		<a href="/" class="btn btn-primary">Home</a>
		<a href="/dorms" class="btn btn-primary">View Dorms</a>
		<a href="/dorms/new" class="btn btn-primary">Add Dorm</a>
	</header>
	<main class="text-left w-50 m-auto">
		<h2 class="text-center mb-2"><c:out value="${ dorm.name }"/> Hall</h2>
		<form action="/dorms/${ dorm.id }/addStudent" method="POST">
			<div class="row">
				<div class="col-2">
					<label>Students</label>
				</div>
				<div class="col-6">
					<select class="form-control" name="studentId">
						<c:forEach items="${ students }" var="student">
						<option value=${ student.id }>${ student.firstName } ${ student.lastName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-4">
					<input type="submit" class="btn btn-success" value="Add">
				</div>
			</div>
		</form>
		<section class="mt-5 text-center">
			<h3>Residents</h3>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ dorm.students }" var="resident">
					<tr>
						<td><a href="/students/${ resident.id }">${ resident.firstName } ${ resident.lastName }</a></td>
						<td><a href="/dorms/${ dorm.id }/remove/${ resident.id }" class="btn btn-sm btn-warning">Remove</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</main>	
</body>
</html>