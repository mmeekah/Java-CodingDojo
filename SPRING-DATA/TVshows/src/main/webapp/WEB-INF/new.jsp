<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New Show</title>
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
		<h1>Create a new show</h1>
		<p><c:out value="${error}" /></p>
		<form:form method="POST" action="/shows/create" modelAttribute="show">
			<div class="form-group">
		        <form:label path="title" for="n">Show Title:</form:label>
		        <form:errors path="title"/>
		        <form:input path="title" class="form-control" id="n" placeholder="Type Show Title" />
		    </div>
		    <div class="form-group">
		        <form:label path="network" for="network">Network:</form:label>
		        <form:errors path="network"/>
		        <form:input path="network" class="form-control" id="network" placeholder="Type  Network" />
		    </div>
	        <button type="submit" class="btn btn-success">Create</button>	       
		</form:form><a href="/shows"><button class="btn btn-danger">Cancel</button></a>
		
	</div>

</body>
</html>