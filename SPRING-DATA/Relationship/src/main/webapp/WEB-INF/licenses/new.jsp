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
		<a href="/persons/new" class="btn btn-info">Add Person</a>
	</header>
	<main class="text-center">
		<form:form class="form w-50 m-auto" action="/licenses" method="POST" modelAttribute="license">
			<div class="form-group row">
				<form:label class="col" path="person">Person</form:label>
				<form:select class="col form-control" path="person">
					<c:forEach items="${ persons }" var="person">
						<option value="${ person.id }">${ person.firstName } ${ person.lastName }</option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group row">
				<form:label class="col" path="state">State</form:label>
				<form:input class="col form-control" path="state"/>
			</div>
			<div class="form-group row">
				<form:label class="col" path="expirationDate">Expiration Date</form:label>
				<form:input type="date" class="col form-control" path="expirationDate"/>
			</div>
			<input type="submit" class="btn btn-success" value="Add License">
		</form:form>
	</main>
</body>
</html>