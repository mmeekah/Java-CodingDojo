<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/solar/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<header class="bg-dark p-2 mb-5">
		<h1>Users & Friends</h1>
		<a href="/users" class="btn btn-primary">View Users</a>
		<a href="/users/new" class="btn btn-primary">Add User</a>
	</header>
	<main class="container text-center">
		<h2><c:out value ="${ user.firstName } ${ user.lastName }"/></h2>
		<div class="row">
			<div class="col">
				<h3>Friends</h3>
				<ul class="text-left">
					<c:forEach items="${ user.friends }" var="friend">
					<li>
						<div class="row">
							<div class="col">
								${ friend.firstName } ${ friend.lastName }
							</div>
							<div class="col">
								<a href="/dropFriend/${user.id}/${friend.id}" class="badge badge-danger">Unfriend</a>
							</div>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<h3>Add Friend</h3>
				<form class="w-75 m-auto" action="/addFriend" method="POST">
				<input type="hidden" name="userId" value=${ user.id }>
					<select class="form-control" name="friendId">
						<c:forEach items="${ possibleFriends }" var="possible">
						<c:if test="${ !user.friends.contains(possible) && user != possible }">
						<option value="${ possible.id }">${ possible.firstName } ${ possible.lastName }</option>
						</c:if>
						</c:forEach>
					</select>
					<input type="submit" class="btn btn-success mt-5" value="Add">
				</form>
			</div>
		</div>
		
	</main>
</body>
</html>