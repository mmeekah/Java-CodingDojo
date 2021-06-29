<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<title><c:out value="${event.name}"/></title>
</head>
<body>
	<div id="top">
		<h1 class="fltleft"><c:out value="${event.name}"/></h1>
		<a class="fltright" href="/logout"><h2>Logout</h2></a>
	</div>
	<div id="container">
		<div id="lftpnl">
			<h3>Host: <c:out value="${event.user.firstName}"/> <c:out value="${event.user.lastName}"/></h3>
			<h3>Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.instructor}"/></h3>
			<h3>People who are attending this event: <c:out value="${event.joinedUsers.size()}"/></h3>
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Name</th>
				
	  				</tr>
				</thead>
				<tbody>
  					<c:forEach items="${attendees}" var="attendee">
		  				<tr>
					    	<td><c:out value="${attendee.firstName}"/> <c:out value="${attendee.lastName}"/></td>
					 
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>