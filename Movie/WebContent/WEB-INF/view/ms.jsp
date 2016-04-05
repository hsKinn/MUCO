<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/Movie/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">

	//	jquery event listner register - remaining
	//	SELECTOR  - > $ ("Target").event(functions);
	$(document).ready(function() {
//		alert("ready to work jquery.");
//		var windowHeight = $ (window).heitht();
//		var windowWidth = $(window).width();
//		console.log("browser info / Height :" + windowHeight);
//		console.log("browser info / Width :" + windowwidth);

//		var documentHeight = $(document).height();
//		var documentWidth = $(document).width();
//		console.log("document info / Height :" + documentHeight);
//		console.log("document info / Width :" + documentwidth);
		
		//id가 addNewActor 인 DOM을 클릭했을때
		$("#addNewActor").click( function() {
			console.log ( "registed Actor." );
			//move page
			location.href = "/Movie/addNewActor";
		});
		
		$("#addNewMovie").click( function() {
			console.log ( "registed Movie." );
			//move page
			location.href= "/Movie/addNewMovie";
		});
		
/* 		$("td").click(function() {
			
			console.log($(this).text());
		}); */
		
	});
	
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
	<tr align = "center">
		<th>MOVIE_ID</th>
		<th>TITLE</th>
		<th>START_DATE</th>
		<th>RATE</th>
		<th>RUN_TIME</th>
		<th>GRADE_ID</th>
		<th>GRADE_TITLE</th>
	</tr>

<c:forEach items="${ allMovie }" var="ms">
	<tr>
		<td>${ ms.movieId }</td>
		<td>
			<a href ="/Movie/detail?movieId=${ms.movieId}"> ${ ms.title } </a> (${ms.actorCount})
		</td>
		<td>${ ms.startDate }</td>
		<td>${ ms.rate }</td>
		<td>${ ms.runTime }</td>
		<td>${ ms.gradeId }</td>
		<td>${ ms.gradeTitle }</td>
	</tr>
</c:forEach>	
</table>
	<input type="button" id="addNewActor" value="regActor">
	<input type="button" id="addNewMovie" value="regMovie">
	

</body>
</html>