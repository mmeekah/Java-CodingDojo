<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Secret Code</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
</head>
<body>
	<div class="jumbotron display-1 p-5">Secret Code</div>
	<h1>What is the code?</h1>
	<form class="row justify-content-center align-items-center" action="check" method="POST">
		<input class="form-control" type="text" name="code">
		<button class="btn btn-primary m-5" type="submit">Try Code</button>
	</form>
	<p class="text-danger font-weight-bold"><c:out value="${error}"></c:out></p>
</body>
</html>