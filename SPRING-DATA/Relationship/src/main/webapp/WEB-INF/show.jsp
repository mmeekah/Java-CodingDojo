<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DMV</title>
<link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-5">
		<h1>DMV</h1>
		<h6>Personal Info</h6>
		<a href="/persons" class="btn btn-info mr-5 mt-3">Dashboard</a>
	</header>
	<main class="text-center container">
		<h1 class="mb-5">Person Info</h1>
		<div class="row w-50 m-auto">
			<div class="col">
				<h6>Name</h6>
			</div>
			<div class="col">
				<h6>License Number</h6>
			</div>
		</div>
		<div class="row w-50 m-auto">
			<div class="col">
				<h3><c:out value="${ person.firstName}"/></h3><h3><c:out value="${ person.lastName}"/></h3>
			</div>
			<div class="col">
				<h3><c:out value="${ person.license.number }"/></h3>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col">
				<h6>State</h6>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3><c:out value="${ person.license.state }"/></h3>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col">
				<h6>Expiration Date</h6>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3><c:out value="${  person.license.expirationDate }"/></h3>
			</div>
		</div>
		<a href="/songs" class="btn btn-warning mt-5 mr-5">Back</a>
		
	</main>
</body>