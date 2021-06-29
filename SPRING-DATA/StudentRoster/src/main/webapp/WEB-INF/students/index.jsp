<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="/js/show.js"></script>
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
		<a href="/" class="btn btn-primary">Home</a>
		<a href="/contacts/new" class="btn btn-primary">Add Contact Info</a>
		<a href="/students/new" class="btn btn-primary">Add Student</a>
	</header>
	<main class="text-center">
		<h2>All Students</h2>
		<table class="table table-striped w-50 m-auto">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th># of Classes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ students.content }" var="student">
				<tr data-href="/students/${ student.id }">
					<td>${ student.firstName } ${ student.lastName }</td>
					<td>${ student.age }</td>
					<td>${ student.contact.address }</td>
					<td>${ student.contact.city }</td>
					<td>${ student.contact.state }</td>
					<td>${ student.courses.size() }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="mt-2">
		  <ul class="pagination justify-content-center">
		    <c:forEach begin="1" end="${ totalPages }" var="index">
		    	<c:if test="${ index == pageNumber }">
			    	<li class="page-item disabled">
			    		<a class="page-link" href="/students/pages/${ index }">${ index }</a>
			    	</li>
		    	</c:if>
		    	<c:if test="${ index != pageNumber }">
			    	<li class="page-item">
			    		<a class="page-link" href="/students/pages/${ index }">${ index }</a>
			    	</li>
		    	</c:if>
		    </c:forEach>
		  </ul>
		</div>
	</main>
</body>
</html>