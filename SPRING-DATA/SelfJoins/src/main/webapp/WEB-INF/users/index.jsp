<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/solar/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Users & Friends</h1>
		<a href="/users" class="btn btn-primary">View Users</a>
		<a href="/users/new" class="btn btn-primary">Add User</a>
	</header>
	<main class="text-center">
		<h2>All Users</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th># of Friends</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ users }" var="user">
				<tr>
					<td>${ user.firstName } ${ user.lastName }</td>
					<td>${ user.friends.size() }</td>
					<td><a href="/users/${ user.id }" class="badge badge-info">View</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>