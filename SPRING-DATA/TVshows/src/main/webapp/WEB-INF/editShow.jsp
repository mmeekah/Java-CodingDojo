<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Show Details</title>
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
		<h1><c:out value="${show.title}" /></h1>
		<hr color="whitesmoke">
		<p><c:out value="${error}" /></p>
		<form:form method="POST" action="/shows/${show.id}/update" modelAttribute="show">
			<!-- <input type="hidden" name="_method" value="put"> -->
			<div class="form-group">
		        <form:label path="title" for="title">Show Title:</form:label>
		        <form:errors path="title"/>
		        <form:input path="title" class="form-control" id="title" placeholder="Insert Title" />
		    </div>
		    <div class="form-group">
		        <form:label path="network" for="network">Network:</form:label>
		        <form:errors path="network"/>
		        <form:input path="network" class="form-control" id="network" placeholder="Insert Location" />
		    </div>
	        <button type="submit" class="btn btn-success">Update</button>
		</form:form>
		<hr color="whitesmoke">
		<a href="/shows/${show.id}/delete"><button class="btn btn-danger">Delete Show</button></a>
	</div>
</body>
</html>
