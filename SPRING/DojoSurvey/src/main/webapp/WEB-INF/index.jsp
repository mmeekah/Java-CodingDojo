<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="jumbotron">
		<h1 class="display-4">Dojo Survey</h1>
		<form action="/process" method="POST">
			<table>
				<tr>
					<td><label for="name">Your Name:</label></td>
					<td><input class="form-control" id="name" name="name"></td>
				</tr>
				<tr>
					<td><label for="location">Dojo Location:</label></td>
					<td>
						<select class="form-control" id="location" name="location">
							<option value="Berkeley, CA">Boston, MA</option>
				            <option value="Boise, ID">Boise, ID</option>
				            <option value="Chicago, IL">Chicago, IL</option>
				            <option value="Dallas, TX">Dallas, TX</option>
				            <option value="Los Angeles, CA">Los Angeles, CA</option>
				            <option value="Silicon Valley, CA">Silicon Valley, CA</option>
				            <option value="Tulsa, OK">Tulsa, OK</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label for="language">Favorite Language:</label></td>
					<td>
						<select class="form-control" name="language">
				            <option value="C#">C#</option>
				            <option value="JavaScript">JavaScript</option>
				            <option value="Python">Python</option>
			             	<option value="Ruby">Ruby</option>
            			</select>
            		</td>
				</tr>
			</table>
			<label class="block" for="comment">Comment (optional)</label>
	        <textarea class="form-control" name="comment" rows="10" cols="4"></textarea>
	        <button class="btn btn-primary" type="submit">Submit</button>
		</form>
	</div>
</body>
</html>