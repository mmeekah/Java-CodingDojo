<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>Dojo Survey</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css"><title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">
		<h1 class="display-4 pb-2 mt-4 mb-2 border-bottom">Submitted Info</h1>
		<table class="table table-borderless">
			<tr>
				<td>Name:</td>
				<td><c:out value="${name}"/></td>
			</tr>
			<tr>
				<td>Dojo Location:</td>
				<td><c:out value="${location}"/></td>
			</tr>
			<tr>
				<td>Favorite Language:</td>
				<td><c:out value="${language}"/></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><c:out value="${comment}"/></td>
			</tr>
		</table>
		<a href="/"><button class="btn btn-info">Go Back</button></a>
	</div>
</body>
</html>