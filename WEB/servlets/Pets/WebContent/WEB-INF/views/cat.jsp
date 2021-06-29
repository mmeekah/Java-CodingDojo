<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cat</title>
</head>
<body>
	<h3>You created s <c:out value = "${cat.breed}"/> </h3>
	<c:out value ="${cat.showAffection()}"/>
</body>
</html>