<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>MVC Demo</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="pb-2 mt-4 mb-2 border-bottom display-4"><c:out value="${book.title}"/></div>
	<table class="table table-borderless">
		<tr>
			<td>Description:</td>
			<td><c:out value="${book.description}"/></td>
		</tr>
		<tr>
			<td>Language:</td>
			<td><c:out value="${book.language}"/></td>
		</tr>
		<tr>
			<td>Number of Pages:</td>
			<td><c:out value="${book.numberOfPages}"/></td>
		</tr>	
	</table>
	<a href="/books/${book.id}/edit"><button class="btn btn-warning">Edit Book</button></a>
	<form action="/books/${book.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<button class="btn btn-danger" type="submit">Delete</button>
	</form>
</body>
</html>