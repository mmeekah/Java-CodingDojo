<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songify - Dashboard</title>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="js/script.js"></script>
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Songify.</h1>
		<h6>Music Playlist &amp; Ratings</h6>
		<a href="/songs" class="btn btn-primary mr-5 mt-3">Refresh</a>
		<a href="/songs/top" class="btn btn-info mr-2 mt-3">Top Songs</a>
		<a href="/songs/new" class="btn btn-success mr-2 mt-3">Add New</a>
	</header>
	<div class="search text-right">
		<form class="inline" action="/songs/artist" method="GET">
			<input class="inline ml-5 mb-2 form-control" id="search" type="search" name="query" placeholder="Enter Artist Name">
			<input type="submit" class="btn btn-info inline" value="Search">
		</form>
	</div>
	<main class="container">
		<table class="table table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ songs }" var="song">
			<tr data-href="/songs/${ song.id }">
				<td>${ song.title }</td>
				<td>${ song.artist }</td>
				<td>${ song.rating }</td>
				<td>
					<a href="/songs/${ song.id }/edit" onclick=event.stopPropagation() class="btn btn-sm btn-warning">Edit</a>
					<form class="inline" action="/songs/${ song.id }" method="POST">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" class="btn btn-sm btn-danger" value="Delete" onclick=event.stopPropagation()>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</main>
	
</body>
</html>