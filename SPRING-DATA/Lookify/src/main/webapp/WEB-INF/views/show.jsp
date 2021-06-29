<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songify - Song Info</title>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Songify.</h1>
		<h6>Music Playlist & Ratings</h6>
		<a href="/songs" class="btn btn-info mr-5 mt-3">Dashboard</a>
	</header>
	<main class="text-center container">
		<h1 class="mb-5">Song Info</h1>
		<div class="row w-50 m-auto">
			<div class="col">
				<h6>Title</h6>
			</div>
			<div class="col">
				<h6>Artist</h6>
			</div>
		</div>
		<div class="row w-50 m-auto">
			<div class="col">
				<h3><c:out value="${ song.title }"/></h3>
			</div>
			<div class="col">
				<h3><c:out value="${ song.artist }"/></h3>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col">
				<h6>Rating</h6>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3><c:out value="${ song.rating }"/></h3>
			</div>
		</div>
		<a href="/songs/${ song.id }/edit" class="btn btn-warning mt-5 mr-5">Edit</a>
		<form class="inline" action="/songs/${ song.id }" method="POST">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" class="btn btn-danger mt-5" value="Delete">
		</form>
	</main>
</body>
</html>