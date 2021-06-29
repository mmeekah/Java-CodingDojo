<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songify - Top Five</title>
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
		<h3>Top Five Songs</h3>
		<table class="table table-striped w-50 m-auto">
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ songs }" var="song">
				<tr>
					<td>${ song.title }</td>
					<td>${ song.artist }</td>
					<td>${ song.rating }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>