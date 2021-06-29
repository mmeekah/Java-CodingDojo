<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-primary p-2 mb-5">
		<h1>Products & Categories</h1>
		<a href="/products" class="btn btn-info">View Products</a>
		<a href="/categories" class="btn btn-info">View Categories</a>
		<a href="/products/new" class="btn btn-info">Add Product</a>
		<a href="/categories/new" class="btn btn-info">Add Category</a>
	</header>
	<main class="w-50 m-auto text-center">
		<h2 class="mb-5">Add New Category</h2>
		<form:form action="/categories" method="POST" modelAttribute="category">
			<div class="form-group row">
				<form:label class="col-3" path="name">Name</form:label>
				<form:input class="form-control col-5" path="name"/>
				<form:errors class="text-danger col-4" path="name"/>
			</div>
			<input type="submit" class="btn btn-success mt-3" value="Add Category">
		</form:form>
	</main>
</body>
</html>