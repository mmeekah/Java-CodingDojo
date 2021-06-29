<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="assets/style.css">
	<title>Checkerboard</title>
</head>
<body>
<!-- <h1>Checkerboard</h1> -->
	<div id="container">
		<%
			int width=0; int height=0;
			if(request.getParameter("width") != null){
				width = Integer.parseInt(request.getParameter("width"));	
		}
			if(request.getParameter("height") != null){
				height = Integer.parseInt(request.getParameter("height"));
		}%>
		<h1>Checkerboard <%= width %>w X <%= height %>h </h1>
		
		<% 
			for(int i=0; i<height; i++){
				if(i%2 == 0){ %>
					<div class="even">
						<% for(int j=0; j<width; j++){
							if(j%2 == 0){ %>
								<div class="pink"></div>
						<% } else { %>
								<div class="blue"></div>
						<% }
						
						} %>
					</div>
				<% } else{ %>
					<div class="odd">
					<% for(int j=0; j<width; j++){
						if(j%2 == 0){ %>
							<div class="blue"></div>
						<% } else { %>
							<div class="pink"></div>
						<% }
					} %>
					</div>
				<% } %>
		<% } %>
	</div>
	
	<!-- http://localhost:8080/Checkerboard/Checkerboard.jsp?width=4&height=8 -->
</body>
</html>