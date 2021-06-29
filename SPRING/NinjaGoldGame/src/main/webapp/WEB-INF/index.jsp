<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Ninja Gold</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="pb-2 mt-4 mb-2 border-bottom"><h6 class="display-4">Your Gold: <span class="goldbox"><c:out value="${gold}"/></span><a href="/reset"><button class="btn btn-sm btn-danger">Reset</button></a></h6></div>
	<div class="row">
		<div class="col">
			<h4>Farm</h4>
			<p>(earns 10-20 gold)</p>
			<form action="/process" method="POST">
				<input type="hidden" name="location" value="farm">
				<button class="btn btn-primary" type="submit">Find Gold!</button>
			</form>
		</div>
		<div class="col">
			<h4>Cave</h4>
			<p>(earns 5-10 gold)</p>
			<form action="/process" method="POST">
				<input type="hidden" name="location" value="cave">
				<button class="btn btn-primary" type="submit">Find Gold!</button>
			</form>
		</div>
		<div class="col">
			<h4>House</h4>
			<p>(earns 2-5 gold)</p>
			<form action="/process" method="POST">
				<input type="hidden" name="location" value="house">
				<button class="btn btn-primary" type="submit">Find Gold!</button>
			</form>
		</div>
		<div class="col">
			<h4>Casino</h4>
			<p>(win/lose 0-50 gold)</p>
			<form action="/process" method="POST">
				<input type="hidden" name="location" value="casino">
				<button class="btn btn-primary" type="submit">Find Gold!</button>
			</form>
		</div>
	</div>
	<h6 class="display-4">Activities:</h6>
	<div class="activities">
		<c:forEach var="activity" items="${activities}" >
			<p class="m-0"><c:out value="${activity}"/></p>
		</c:forEach>
	</div>
</body>
</html>