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
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/common/faq.css"/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/pack/myPack.css"/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/pack/sharePack.css"/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/place/recommendPlace.css"/>" />
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/reserve/tripReservation.css"/>" />

<!-- Jquery, Json Script -->
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.12.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resource/js/json2.js" />"></script>

</head>
<script type="text/javascript">
   $(document).ready(function() {

      $("#join").hide();
      $("#login").hide();

      $("#letsJoin").click(function() {
         $("#letsJoin").animate({
            height : 'toggle'
         });
         $("#join").animate({
            height : 'toggle'
         });

         $("#letsLogIn").hide();
         $("#login").hide();
         $("#goBack").show();
      });

      $("#letsLogIn").click(function() {
         $("#letsLogIn").animate({
            height : 'toggle'
         });
         $("#login").animate({
            height : 'toggle'
         });

         $("#letsJoin").hide();
         $("#join").hide();
         $("#goBack").show();
      });

      $("#goBack").click(function() {
         $("#join").hide();
         $("#login").hide();
         $("#letsJoin").show();
         $("#letsLogIn").show();
         $("#goBack").hide();
      });

      // 회원 가입 
      $("#btnJoin").click(function() {

         var userEmail = $("#userEmail").val();
         userEmail = $.trim(userEmail);
         if (userEmail == "") {
            alert("이메일을 입력하세요!");
            $("#userEmail").focus();
            return;
         }

         var userPassword = $("#userPassword").val();
         userPassword = $.trim(userPassword);
         if (userPassword == "") {
            alert("비밀번호를 입력하세요!");
            $("#userPassword").focus();
            return;
         }

         var userName = $("#userName").val();
         userName = $.trim(userName);
         if (userName == "") {
            alert("닉네임을 입력하세요!");
            $("#userName").focus();
            return;
         }

         var form = $("#joinForm");
         form.attr("method", "post");
         form.attr("action", "<c:url value="/doJoin"/>");
         form.submit();
      });

      // 로그인 
      $("#btnLogin").click(function() {
         var form = $("#loginForm");
         form.attr("method", "post");
         form.attr("action", "<c:url value="/doLogin"/>")
         form.submit();
      });

   });
</script>

<body>
   <nav id="topNav" class="navbar navbar-default navbar-fixed-top" data-spy="affix">
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