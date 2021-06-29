<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="/js/script.js"></script>
</head>
<body>
	<header class="bg-primary p-2 mb-5">
		<h1>Products & Categories</h1>
		<a href="/products" class="btn btn-info">View Products</a>
		<a href="/categories" class="btn btn-info">View Categories</a>
		<a href="/products/new" class="btn btn-info">Add Product</a>
		<a href="/categories/new" class="btn btn-info">Add Category</a>
	</header>
	<main class="text-center w-25 m-auto">
		<h2>All Products</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ products }" var="product">
				<tr data-href="/products/${ product.id }">
					<td>${ product.name }</td>
					<td>${ product.price }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>