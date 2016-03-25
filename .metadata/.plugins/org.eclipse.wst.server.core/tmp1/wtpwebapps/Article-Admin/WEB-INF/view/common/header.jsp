<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/header.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/login.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/logout.css" />">
<script type="text/javascript" src="resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="resource/js/json2.js"></script>

<title> 회원제 게시판::관리자 </title>
</head>
<body>

	<div id="wrapper">
		
		<div id="header">
			
			<a href="/admin"><img src="<c:url value="/resource/img/mario.png"/>" /></a> <div id="headerFont">Hello SUPA MARIO World !</div> 
		
		</div>
		
		<div class="clear"></div>
		<jsp:include page="/WEB-INF/view/common/topMenu.jsp"></jsp:include>
		
