<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sessions Counter</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="jumbotron display-4 p-5">Sessions Counter</div>
	<h1>You have visited <a href="/">http://localhost:8080</a> <c:out value="${count}"/> times.</h1>
	<a href="/"><button class="btn btn-primary">Go Back</button></a>
	<a href="/addTwo"><button class="btn btn-info">Add Two to Counter</button></a>
	<a href="/reset"><button class="btn btn-danger">Reset Sessions Counter</button>
</body>
</html>