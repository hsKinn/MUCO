<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr align = "center">
		<th>MOVIE_ID</th>
		<th>TITLE</th>
		<th>START_DATE</th>
		<th>RATE</th>
		<th>RUN_TIME</th>
		<th>GRADE_ID</th>
		<th>GRADE_TITLE</th>
	</tr>
	
	<tr align = "center">
		<td>${ movie.movieId }</td>
		<td>${ movie.title } </td>
		<td>${ movie.startDate }</td>
		<td>${ movie.rate }</td>
		<td>${ movie.runTime }</td>
		<td>${ movie.gradeId }</td>
		<td>${ movie.gradeTitle }</td>
	</tr>

<table border="1">
	<tr align = "center">
		<th>DIRECTOR_ID</th>
		<th>DIRECTOR_NAME</th>
	</tr>
	<c:forEach items="${ directors }" var="d">
	<tr>
		<td>${ d.directorId }</td>
		<td>${ d.directorName }</td>
	</tr>
</c:forEach>
	<tr align = "center">
		<th>ACTOR_ID</th>
		<th>ACTOR_NAME</th>
	</tr>
	<c:forEach items="${ actors }" var="a">
	<tr>
		<td>${ a.actorId }</td>
		<td>${ a.actorName }</td>
	</tr>
</c:forEach>
	<tr align = "center">
		<th>GENRE_ID</th>
		<th>GENRE_TITLE</th>
	</tr>	
<c:forEach items="${ genres }" var="g">
	<tr>
		<td>${ g.genreId }</td>
		<td>${ g.genreTitle }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>