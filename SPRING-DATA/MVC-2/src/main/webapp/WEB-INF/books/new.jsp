<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>MVC Demo</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="pb-2 mt-4 mb-2 border-bottom display-4">New Book</div>
	<form:form action="/books" method="POST" modelAttribute="book">
	    <table class="table table-borderless">
	    	<tr>
	    		<td><form:label path="title">Title:</form:label></td>
	    		<td><form:input path="title"/></td>
	    		<td class="text-danger"><form:errors path="title"/></td>
	    	</tr>
	    	<tr>
	    		<td><form:label path="description">Description:</form:label></td>
	    		<td><form:input path="description"/></td>
	    		<td class="text-danger"><form:errors path="description"/></td>
	    		
	    	</tr>
	    	<tr>
	    		<td><form:label path="language">Language</form:label></td>
	    		<td><form:input path="language"/></td>
	    		<td class="text-danger"><form:errors path="language"/></td>
	    	</tr>
	    	<tr>
	    		<td><form:label path="numberOfPages">Pages</form:label></td>
	    		<td><form:input type="number" path="numberOfPages"/></td>
	    		<td class="text-danger"><form:errors path="numberOfPages"/></td>
	    	</tr>
	    </table>
	    <button class="btn btn-success" type="submit">Add Book</button>
	</form:form>    
</body>
</html>