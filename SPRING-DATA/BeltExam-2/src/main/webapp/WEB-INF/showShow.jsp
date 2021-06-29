<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Details</title>
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
		<h4><c:out value="${show.title}" /></h4>
		<h4>Network: <c:out value="${show.network}" /></h4>
		<hr color="whitesmoke">
		<div class="row">
			<div class="col-md-6">
				<h4>Users who rated this show</h4>
				<table class="table table-bordered">
					<thead>
						<tr class="bg-secondary">
							<th>Name</th>
							<th>Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ratings}" var="i">
							<tr>
								<td><c:out value="${i.user.name}"/></td>
								<td><c:out value="${i.value}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/shows/${show.id}/edit"><button class="btn btn-warning">Edit</button></a>
				<a href="/shows"><button class="btn btn-danger">Cancel</button></a>
			</div>
			<div class="col-md-6">
				<h4>Leave a Rating!</h4>
				<form:form method="POST" action="/shows/${show.id}/rate" modelAttribute="rating">
					<div class="form-group">
				        <form:label path="value" for="value">Show Title:</form:label>
				        <form:errors path="value"/>
				        <form:input type="number" step=".1" min="0" max="5" path="value" class="form-control" id="value" />
				    </div>
			        <button type="submit" class="btn btn-info">Rate</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
