<!-- 이기연 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
    <link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
	<link rel="stylesheet" type="text/css"	href="<c:url value="/resource/styles.css"/>" />
	
	<!-- Boot strap -->

<link rel="stylesheet"   href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.min.css"   rel="stylesheet" />
<link rel="stylesheet"   href="//code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/styles.css"/>" />

<!-- Boot strap -->
<footer id="footer">
   <div class="container-fluid">
      <div class="row">
         <div class="col-xs-6 col-sm-3 column">
            <h4>Information</h4>
            <ul class="list-unstyled">
               <li><a href="<c:url value="/termsAccess?menuNo=1"/>">이용약관</a></li>
               <li><a href="<c:url value="/termsAccess?menuNo=2"/>">개인정보취급방침</a></li>
            </ul>
         </div>
         <div class="col-xs-6 col-sm-3 column">
            <h4>Service Center</h4>
            <ul class="list-unstyled">
               <li><a href="<c:url value="/contactUs"/>">Contact Us</a></li>
               <li><a href="<c:url value="/termsAccess?menuNo=3"/>">Q&amp;A</a></li>
            </ul>
         </div>
      </div>
      <br /> <span class="pull-right text-muted small"><a href="#">Travel
            with Travery</a> ©2016 Travery</span>
   </div>
</footer>

</body>
</html>