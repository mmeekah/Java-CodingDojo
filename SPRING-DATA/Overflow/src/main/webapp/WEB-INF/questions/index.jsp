<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Overflow</title>
<link rel="stylesheet" href="https://bootswatch.com/4/spacelab/bootstrap.css">
<link rel="stylesheet" href="/css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="/js/script.js"></script>
</head>

<body>
	<header class="bg-dark p-2 mb-3">
		<h1 class="text-primary">Dojo<span class="text-warning">Overflow</span></h1>
		<a href="/questions/new" class="btn btn-primary">New Question</a>
	</header>
	<main class="text-center">
		<h2>Questions Dashboard</h2>
		<table class="table table-striped w-75 m-auto">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ questions }" var="question">
				<tr data-href="/questions/${ question.id }">
					<td>${ question.question }</td>
					<td>
						<c:forEach items="${ question.tags }" var="tag">
						${ tag.subject }<c:if test="${ question.tags.indexOf(tag) != question.tags.size() - 1}">, </c:if>
						</c:forEach>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>

</html>
