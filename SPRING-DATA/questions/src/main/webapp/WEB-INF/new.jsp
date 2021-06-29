<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Questions</title>
</head>
<body>
	<h1>What is your question</h1>
	<a href="/questions">Dashboard</a>
	<a href="/logout">Logout</a>
	
	<form action="/questions" method="post">
	
		<label for="question">Question:</label>
		<textarea id="question" name="question"></textarea>
		<label for="tag">Tags:</label>
		<input type="text" name="tags"/>
		<button type="submit">Add Question</button>
	</form>
</body>
</html>
