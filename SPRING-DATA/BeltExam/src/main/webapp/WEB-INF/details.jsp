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
			<h3>Student: <c:out value="${event.user.firstName}"/> <c:out value="${event.user.lastName}"/></h3>
			<h3>Instructor: <c:out value="${event.instructor}"/> </h3>
			
			<h3>People who are attending this event: <c:out value="${event.joinedUsers.size()}"/></h3>
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Students</th>
					    <th scope="col">Sign Up Date</th>
					    <th scope="col">Action</th>
					    
	  				</tr>
				</thead>
				<tbody>
  					<c:forEach items="${attendees}" var="attendee">
		  				<tr>
					    	<td><c:out value="${attendee.firstName}"/> <c:out value="${attendee.lastName}"/></td>
					    	<td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.createdAt}"/></td>
					    	
					    	<c:choose>
                        <c:when test="${event.user == user}">
                            <td>*Attending* | <a href="/events/${event.id}/edit">Edit</a> | <a href="events/${event.id}/delete">Delete</a></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${event.getJoinedUsers()}" var="attendee">
                                <c:if test="${attendee == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="/events/${event.id}/join">Join</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td>*Attending* | <a href="events/${event.id}/cancel">Cancel</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                        </c:choose>  
					    
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>