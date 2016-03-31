<!-- 김광민 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"  href="<c:url value="/resource/css/common/reset.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/common/index.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/common/header.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/common/leftMenu.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/common/footer.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/member/personalInfo.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/place/hitTheRoad.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/pack/myPack.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/pack/sharePack.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/place/recommendPlace.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/place/originPlaceList.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/country/country.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/reserve/tripReservation.css"/>" />

<!-- Boot strap -->
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"	href="http://www.w3schools.com/lib/w3-theme-teal.css">
<link href='https://fonts.googleapis.com/css?family=RobotoDraft'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jVector Map -->
<link rel="stylesheet" media="all"	href="<c:url value="/resource/css/place/jquery-jvectormap-2.0.3.css"/>" />

<title>Travery</title>
<script type="text/javascript"	src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resource/js/json2.js" />"></script>

<!-- Boot strap -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

</head>

<script type="text/javascript">
	$(document).ready(function() {

		$("#logout").mouseenter(function() {
			$("#logout").css("background-color", "#ffffff");
			$("#logout").css("color", "#333333");
		});

		$("#logout").mouseleave(function() {
			$("#logout").css("background-color", "#8b8b8b");
			$("#logout").css("color", "#333333");
		});

		$("#logout").click(function() {
			location.href = "<c:url value="/logout" />";
		});
	});
</script>

<body>
	<div id="wrapper">

		<nav class="navbar navbar-default navbar-inverse" role="navigation">
			<div class="container-fluid">
				<div id="navbar-brand"> 
					<a href="#">
					<img id="traveryIcon" src="<c:url value="/resource/img/common/traveryIcon.PNG"/>"
						alt="traveryIcon" />
					</a>
				</div>
			
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li><p class="navbar-text">안녕하세요</p></li>
						<li><div class="navbar-text" id="logout">로그아웃</div></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</nav>