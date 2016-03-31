<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Cookie[] cookies = request.getCookies();

	String userId = "";
	String userPassword = "";
	String autoLogin = "";

	if (cookies != null) {
		// 존재하는 쿠키들을 하나씩 검사
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userId")) {
				// 아이디 쿠키 받아오기
				userId = cookie.getValue();
			} else if (cookie.getName().equals("userPassword")) {
				// 비밀번호 쿠키 받아오기
				userPassword = cookie.getValue();
			} else if (cookie.getName().equals("autoLogin")) {
				// 자동 로그인 쿠키 받아오기
				autoLogin = cookie.getValue();
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travel with Travery!</title>
<meta name="description" content="This is a free Bootstrap landing page theme created for BootstrapZero. Feature video background and one page design." />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="Codeply">

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css" rel="stylesheet" />
<link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/styles.css"/>" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/member/personalInfo.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/place/hitTheRoad.css"/>" />

<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/pack/sharePack.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/place/recommendPlace.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/country/country.css"/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/css/reserve/tripReservation.css"/>" />

<!-- Jquery, Json Script -->
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resource/js/json2.js" />"></script>

</head>

<body>
	<nav id="topNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand page-scroll" href="/">
				<i
					class="ion-ios-analytics-outline"></i> Travery </a>
			</div>
			<div class="navbar-collapse collapse" id="bs-navbar">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/hitTheRoad"/>" id="hitTheRoadMenu">
							HIT THE ROAD </a></li>
					<li><a href="<c:url value="/myPack"/>" id="myPackMenu"> MY
							PACKAGE </a></li>
					<li><a href="<c:url value="/init"/>" id="sharePackMenu">
							SHARE PACKAGE </a></li>
					<li><a href="<c:url value="/recommendPlace"/>"
						id="recommendPlaceMenu"> RECOMMEND PLACE </a></li>
					<li><a href="<c:url value="/tripReservation"/>"
						id="tripReservationMenu"> TRIP RESERVATION </a></li>
					<li><a href="<c:url value="/personalInfo"/>"
						id="personalInfoMenu"> PERSONAL INFO </a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a class="page-scroll" data-toggle="modal"
						title="A free Bootstrap video landing theme" href="#aboutModal">Hello</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>