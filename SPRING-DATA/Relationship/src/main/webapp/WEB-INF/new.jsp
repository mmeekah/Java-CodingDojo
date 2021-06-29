<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/yeti/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1 class="inline-block text-light">DMV Licenses</h1>
		<a href="/persons" class="btn btn-info">Home</a>
	</header>
	<main class="text-center">
		<form:form class="form w-50 m-auto" action="/persons" method="POST" modelAttribute="person">
			<div class="form-group row">
				<form:label class="col" path="firstName">First Name</form:label>
				<form:input class="col form-control" path="firstName"/>
			</div>
			<div class="form-group row">
				<form:label class="col" path="lastName">Last Name</form:label>
				<form:input class="col form-control" path="lastName"/>
			</div>
			<input type="submit" class="btn btn-success" value="Add Person">
		</form:form>
	</main>
</body>
</html>