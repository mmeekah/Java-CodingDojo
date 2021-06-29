<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-light">Student<span class="text-primary">Resources</span>App</h1>
		<a href="/" class="btn btn-primary">Home</a>
		<a href="/dorms" class="btn btn-primary">View Dorms</a>
		<a href="/students/pages/1" class="btn btn-primary">View Students</a>
	</header>
	<main class="text-left m-auto">
		<h2 class="text-center mb-5">Student Info</h2>
		<div class="row">
			<!-- Contact Info -->
			<div class="col ml-5">
			<h4 class="text-center mb-5">Contact Info</h4>
				<div class="row mb-2">
					<div class="col-4">
						<h4>Name</h4>
					</div>
					<div class="col-8">
						<h4><c:out value="${ student.firstName } ${student.lastName }"/></h4>
					</div>
				</div>
				<div class="row mb-2">
					<div class="col-4">
						<h4>Dormitory</h4>
					</div>
					<div class="col-8">
						<h4><c:out value="${ student.dormitory.name }"/> Hall</h4>
					</div>
				</div>
				<div class="row mb-2">
					<div class="col-4">
						<h4>Address</h4>
					</div>
					<div class="col-8">
						<h4><c:out value="${ student.contact.address }"/></h4>
					</div>
				</div>
				<div class="row mb-2">
					<div class="col-4">
						<h4>City</h4>
					</div>
					<div class="col-8">
						<h4><c:out value="${ student.contact.city }"/></h4>
					</div>
				</div>
				<div class="row mb-2">
					<div class="col-4">
						<h4>State</h4>
					</div>
					<div class="col-8">
						<h4><c:out value="${ student.contact.state }"/></h4>
					</div>
				</div>
			</div>
			<!--  Classes List -->
			<div class="col">
				<h4 class="text-center mb-5">Enrolled Classes</h4>
				<ul>
					<c:forEach items="${ student.courses }" var="course">
					<li class="mb-2">
						<div class="row">
							<div class="col"><h5 class="inline">${ course.name }</h5></div>
							<div class="col"><a href="/classes/${ course.id }/drop/${ student.id }" class="btn btn-sm btn-warning">Drop</a></div>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<h4 class="text-center mt-5 mb-3">Enroll in a Class</h4>
		<form class="w-50 m-auto" action="/classes/${ student.id }/addClass" method="POST">
			<select class="form-control inline w-75" name="courseId">
				<c:forEach items="${ courses }" var="course">
				<option value="${ course.id }">${ course.name }</option>
				</c:forEach>
			</select>
			<input class="btn btn-sm btn-success inline" type="submit" value="Add Class">
		</form>
	</main>	
</body>
</html>