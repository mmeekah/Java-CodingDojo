<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	<h1>
		Welcome to the Admin Page
		<c:out value="${currentUser.first_name}"></c:out>
	</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:choose>
		<c:when test="${!currentUser.checkIfSuperadmin()}">
		<c:forEach items="${users}" var="user">
			<c:if test="${!user.checkIfSuperadmin()}">
			<tr>
				<td><c:out value="${user.first_name} ${user.last_name}"/></td>
				<td><c:out value="${user.email}"/>
				<td>
					<c:choose>
					<c:when test="${!user.checkIfAdmin()}"><a href="/users/delete/${user.id}">Delete</a> <a href="/users/admin/${user.id}">Make Admin</a></c:when>
					<c:otherwise>Admin</c:otherwise>
					</c:choose>
				</td>
			</tr>
			</c:if>
		</c:forEach>
		</c:when>
		<c:otherwise>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.first_name} ${user.last_name}"/></td>
				<td><c:out value="${user.email}"/>
				<td>
					<c:if test="${!user.checkIfSuperadmin()}"><a href="/users/delete/${user.id}">Delete</a></c:if>
					<c:if test="${!user.checkIfAdmin()}"> <a href="/users/admin/${user.id}">Make Admin</a></c:if>
				</td>
			</tr>
		</c:forEach>
		</c:otherwise>
		</c:choose>
	</table>
	<a href="/dashboard"><button>Dashboard</button></a>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout!" />
	</form>
</body>
</html>