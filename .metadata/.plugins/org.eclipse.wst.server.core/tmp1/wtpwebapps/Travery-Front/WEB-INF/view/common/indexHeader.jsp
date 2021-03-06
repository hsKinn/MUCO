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

<!-- jVector Map -->
<link rel="stylesheet" media="all" href="<c:url value="/resource/css/place/jquery-jvectormap-2.0.3.css"/>" />

<!--scripts loaded here from cdn for performance -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.js"></script>
<script src="<c:url value="/resource/js/scripts.js" />"></script>

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
            <i class="ion-ios-analytics-outline"></i> Travery </a>
         </div>
         <div class="navbar-collapse collapse" id="bs-navbar">
            <ul class="nav navbar-nav">
               <li><a class="page-scroll" href="#one">Start</a></li>
               <li><a class="page-scroll" href="#two">Service</a></li>
               <li><a class="page-scroll" href="#three">Gallery</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
               <li>
                  <a class="page-scroll" data-toggle="modal"
                  title="A free Bootstrap video landing theme" href="#aboutModal">About Us</a>
               </li>
            </ul>
         </div>
      </div>
   </nav>
   
   
   <div id="aboutModal" class="modal fade" tabindex="-1" role="dialog"
      aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-body">
               <h2 class="text-center">Travery made by MUCO</h2>
               <h5 class="text-center">
               MUCO : 무적코딩 kt'ds 2016 project #1</h5>
               <p class="text-justify" style="text-align: center;">
               Travery is Developed by  : </br> 
                        <a href="http://cocomo.tistory.com/">김광민</a></br>
                        유병훈</br>
                        김동규</br>
                        <a href="http://kiyeonlee.com/">이기연</a></br>
                        백지경</br>
                        <a href="http://loveiskey.tistory.com/">김현섭</a></br>
                </p>
               <p class="text-center">
                  Thank you!
               </p>
               <br />
               <button class="btn btn-primary btn-lg center-block"
                  data-dismiss="modal" aria-hidden="true">OK</button>
            </div>
         </div>
      </div>
   </div>