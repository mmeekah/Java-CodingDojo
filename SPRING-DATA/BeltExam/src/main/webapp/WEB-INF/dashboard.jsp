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
<title>Events</title>
</head>
<body>
	<div id="container">
		<h1 class="fltleft">Welcome, <c:out value="${user.firstName}"/></h1>
		<a class="fltright" href="/logout"><h2>Logout</h2></a>
		<h2>Here are some of the classes you can take:</h2>
		<c:if test="${allEvents.size() == 0}"><h5>There are currently no classes to take</h5></c:if>
        <c:if test="${allEvents.size() > 0}">
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Name</th>
					    <th scope="col">Instructor</th>
					    <th scope="col">Date</th>
					    <th scope="col">Host</th>
					    <th scope="col">Action/Status</th>
	  				</tr>
				</thead>
				<tbody>
					<c:forEach items="${allEvents}" var="event">
	  				<tr>
	  					<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
					     <td><c:out value="${event.instructor}"/></td>
					     <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.createdAt}"/></td>
					
					    <td><c:out value="${event.user.firstName}"/></td>
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
	  				</tr>
	  				</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<div id="lftpnl">
			<h2>Create an Event:</h2>
			<form:form method="post" action="/addevent" modelAttribute="eventObj">
				<h4 class="avoid">
					<form:label path="name">Name:</form:label>
					<form:input cssClass="fields" type="text" path="name"/>
				</h4>
				<h4 class="avoid">
					<form:label path="instructor">Instructor:</form:label>
					<form:input cssClass="fields" type="text" path="instructor"/>
				</h4>
				
				<form:hidden path="user" value="${user.id}"/>
				<input class="btn" type="submit" value="Create"/>
			</form:form>
			<form:errors cssClass="red" path="eventObj.*"/>
		</div>
		<div id="rghtpnl">
		</div>
	</div>
</body>
</html>