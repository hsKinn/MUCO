<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript">

	$(document).ready( function() {
/* 		$("#addNewMovieForm").hide();
		$("#addNewMovieForm").slideDown(4000);
		$("#addNewMovieForm").slideUp(4000);
		$("#addNewMovieForm").fadeIn(2000);
		$("#addNewMovieForm").fadeOut(); */
		
		$("#addNewMovie").click( function() {
			
			//	Validation Check
			var movieTitle = $("#movieTitle").val();
			movieTitle = $.trim( movieTitle );
			
			if( movieTitle == "") {
				alert("Plase Write the movie Title.");
				$("#movieTitle").focus();
				return;
			}
			
			var rate = $("#rate").val();
			rate = $.trim( rate );
			if( rate == "") {
				alert("Plase Write the rate.");
				$("#rate").focus();
				return;
			}
			
//			rate = parseFloat(rate); <- 뒤에 오는 문자를 없애버리기때문에 주의.
			if ( isNaN(rate) ) {
				alert("please Correctly write number with place a decimal point.");
				return;
			}
			
			var isNumber = isNaN(rate);
			if ( isNaN(rate)) {
				alert(isNumber);
				return; 	
			}
			
			var runTime = $("#runTime").val();
			runTime = $.trim( runTime );
			if( runTime == "") {
				alert("write runtime.");
				$("#runTime").focus();
				return;
			}
			if( runTime.length > 5 ) {
				alert("Correctly write runtime.");
				return;
			}
			var regExp = new RegExp("^[0-2][0-9]:[0-5][0-9]$");
			var isValidRunTime = regExp.test(runTime);
			if ( isValidRunTime == false ) {
				alert("You must write Correctly.");
				return;
			}

			
			var openDate = $("#openDate").val();
			openDate = $.trim( openDate );
			if( openDate == "") {
				alert("write openDate.");
				$("#openDate").focus();
				return;
			}
			
	         var grade = $(".grade:checked").val();
	         if ( grade == undefined ) {
	            alert("choose the grade.");
	            $(".grade").fadeOut().fadeIn().fadeOut().fadeIn();
	            return;
	         }
			
			var directors = $("#directors option:selected").val();
			if ( directors == undefined ) {
				alert("choose the directors.");
				$("#directors").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}
			
			var actors = $("#actors option:selected").val();
			if ( actors == undefined ) {
				alert("choose the actors.");
				$("#actors").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}
			
			
			var genres = $(".genres:checked").val();
			if ( genres == undefined ) {
				alert("choose the genre.");
				$(".genres").fadeOut().fadeIn().fadeOut().fadeIn();
				return;
			}			
			
			var form = $("#addNewMovieForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/addNewMovieAction" />");
			
			form.submit();
		});
/* 		$("#directors").click(function() {
			var selectedDirectors = "";
			$("#directors option:checked").each( function (index, data) {
				selectedDirectors += data.text;
				selectedDirectors += ", ";
			});
			$("#directorsName").text( selectedDirectors);
		});
		
		$("#actors").click(function() {
			var selectedActors = "";
			$("#actors option:checked").each( function (index, data) {
				selectedActors += data.text;
				selectedActors += ", ";
			});
			$("#actorsName").text( selectedActors);
		});
 */	});
	
</script>
</head>
<body>

	<h1>movie register</h1>
	<hr />
	
	<!-- security codes -->
	<span class="errorCode">${ errorCode }</span>
	
	<form id="addNewMovieForm">
		movie title : <input type="text" id="movieTitle" name="movieTitle" /> <br/>
		rate : <input type="text" id="rate" name="rate" /><br /> 
		run time : <input type="text" id="runTime" name="runTime" /><br /> 
		start date : <input	type="Date" id="openDate" name="openDate" /><br /> 
		grade :	<c:forEach items="${gradeList}" var="grade">
			<input type="radio" class="grade" name="grade"	value="${grade.gradeId}" />${grade.gradeTitle}
	</c:forEach>
		<br /> 
		director : <select id="directors" name="directors" multiple="multiple">
			<c:forEach items="${directorList}" var="director">
				<option value="${ director.directorId }">${ director.directorName }</option>
			</c:forEach>
		</select>
		<span id="directorsName"></span>
		<br /> 
		actor : <select id="actors" name="actors" multiple="multiple">
			<c:forEach items="${actorList}" var="actors">
				<option value="${ actors.actorId }">${ actors.actorName }</option>
			</c:forEach>
		</select>
		<span id="actorsName"></span>
		<br /> 
		genre :
		<c:forEach items="${genreList}" var="genre">
			<input type="checkbox" class="genres" name="genres"	value="${genre.genreId}" /> ${genre.genreTitle}
			</c:forEach>
		<br /> <input type="button" id="addNewMovie" value="registMovie">
	</form>
</body>
</html>