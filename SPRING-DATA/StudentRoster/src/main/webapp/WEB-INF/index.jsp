<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Resources Home</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<style>
	.btn {
		margin:20px;
		padding: 2rem 1rem;
		width: 200px;
	}
	.card {
		margin-bottom: 50px !important;
	}
</style>
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
	</header>
	<div class="card w-50 m-auto bg-light p-3 text-center">
		<h5>Full Stack Spring Application using Java, JSPs & Bootstrap, with a MySQL database</h5>
		<h6>Models used to showcase OneToOne, OneToMany, & ManyToMany table relationships</h6>
		<h6>Pagination, Repositories, APIService and Controller used in back-end</h6>
	</div>
	<div class="w-75 row m-auto text-center">
		<div class="col">
			<h4>Classes</h4>
			<a class="btn btn-info" href="/classes">View Classes</a>
		</div>
		<div class="col">
			<h4>Students</h4>
			<a class="btn btn-info" href="/students/pages/1">View Students</a>
		</div>
		<div class="col">
			<h4>Dormitories</h4>
			<a class="btn btn-info" href="/dorms">View Dorms</a>
		</div>
	</div>
	<div class="w-75 row m-auto text-center">
		<div class="col">
			<a class="btn btn-info" href="/classes/new">Add Class</a>
		</div>
		<div class="col">
			<a class="btn btn-info" href="/students/new">Add Student</a>
		</div>
		<div class="col">
			<a class="btn btn-info" href="/dorms/new">Add Dorm</a>
		</div>
	</div>
	<div class="w-75 row m-auto text-center">
		<div class="col"></div>
		<div class="col">
			<a class="btn btn-info" href="/contacts/new">Add Contact Info</a>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>l>