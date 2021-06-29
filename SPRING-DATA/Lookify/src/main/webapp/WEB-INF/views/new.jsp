<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songify - Add Song</title>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Songify.</h1>
		<h6>Music Playlist & Ratings</h6>
		<a href="/songs" class="btn btn-info mr-5 mt-3">Dashboard</a>
	</header>
	<main class="text-center">
		<h3 class="mb-5">Add A New Song</h3>
		<form:form action="/songs" method="POST" modelAttribute="song" class="form w-50 m-auto">
			<div class="form-group row">
				<form:label class="col-3" path="title">Title</form:label>
				<form:input class="col-6" path="title"/>
				<form:errors class="col-3 text-danger" path="title"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="artist">Artist</form:label>
				<form:input class="col-6" path="artist"/>
				<form:errors class="col-3 text-danger" path="artist"/>
			</div>
			<div class="form-group row">
				<form:label class="col-3" path="rating">Rating</form:label>
				<form:input class="col-6" type="number" min="1" max="10" path="rating"/>
				<form:errors class="col-3 text-danger" path="rating"/>
			</div>
			<input type="submit" class="btn btn-primary mt-5" value="Add Song">
		</form:form>
	</main>
</body>
</html>