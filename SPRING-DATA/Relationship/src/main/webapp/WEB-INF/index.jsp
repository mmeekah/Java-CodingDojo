<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/yeti/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1 class="inline-block text-light">DMV Licenses</h1>
		<a href="/licenses/new" class="btn btn-info">Add License</a>
		<a href="/persons/new" class="btn btn-info">Add Person</a>
	</header>
	<main class="text-center">
		<table class="table table-striped w-50 m-auto">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>License #</th>
					<th>State</th>
					<th>Expiration Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ persons }" var="person">
				 <tr data-href="/persons/${ person.id }">
					<td>${ person.firstName }</td>
					<td>${ person.lastName }</td>
					<td>${ person.license.number }</td>
					<td>${ person.license.state }</td>
					<td><fmt:formatDate pattern="MM-dd-yyy" value = "${ person.license.expirationDate }"/></td>
					<td><a href="/persons/${ person.id }" onclick=event.stopPropagation() class="btn btn-sm btn-warning">Show</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>