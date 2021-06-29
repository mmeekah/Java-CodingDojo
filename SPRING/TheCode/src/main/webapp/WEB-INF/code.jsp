<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>The Code</title>
</head>
<body>
	<div class="jumbotron">
		<ul>
			<li>Loyalty</li>
			<li>Courage</li>
			<li>Veracity</li>
			<li>Compassion</li>
			<li>Honor</li>
		</ul>
	</div>
	<p class="text-danger font-weight-bold"><c:out value="${success}"></c:out></p>
</body>

</html>