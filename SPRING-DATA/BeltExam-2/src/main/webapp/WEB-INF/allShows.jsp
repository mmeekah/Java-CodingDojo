<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Shows</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	button .right{
		text-align: right;
	}
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
 <a class="navbar-brand" href="/shows">TV-Shows Rates</a>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>

    </ul>
  </div>
	<a href="/logout"><button class="btn btn-danger right">Logout</button></a>
</nav>

	<div class="container">
	<br>
	<h1>Welcome, <c:out value="${user.name}" /></h1>
	<hr color="whitesmoke">
	<table class="table table-bordered">
		<thead>
			<tr class="bg-secondary">
				<th>Show</th>
				<th>Network</th>
				<th>Average Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shows}" var="i">
				<tr>
					<td><a href="/shows/${i.id}"><c:out value="${i.title}"/></a></td>
					<td><c:out value="${i.network}"/></td>
					<td><c:out value="${i.average_reviews}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr color="whitesmoke">
	<a href="/shows/new"><button class="btn btn-primary">Add a Show</button></a>
	</div>
</body>
</html>
