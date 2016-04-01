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

<!-- Header -->
<jsp:include page="./WEB-INF/view/common/indexHeader.jsp"></jsp:include>
</div>
<!-- id="header" -->

<script type="text/javascript">

	$(document).ready(function() {

		$("#login").hide();
		$("#goBack").hide();
		
	    
	    $("#letsLogIn").click(function(){
	    	 $("#letsLogIn").animate({
	             height: 'toggle'
	         });
	    	 $("#login").animate({
	             height: 'toggle'
	         });
	    	 
	 		$("#letsJoin").hide();
	 		$("#join").hide();
			$("#goBack").show();
	    });
	    
	    $("#goBack").click(function(){
	    	$("#join").hide();
	    	$("#login").hide();
			$("#letsJoin").show();
			$("#letsLogIn").show();
			$("#goBack").hide();
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


<!-- Index -->
<div id="index">

	<div id="login">
		<form id="loginForm">
			<input type="text" class="form-control"	tabindex="1" id="userEmail" name="userEmail" placeholder=" Email" >
			<input type="password" class="form-control"	tabindex="2" id="userPw" name="userPw" placeholder=" Password" > 
			<input type="button" id="btnLogin" value="로그인" />
		</form>
	</div>	

	<div class="clear"></div>
	<div id="letsLogIn">
		<a>Login</a>
	</div>
	
	<div id="goBack">
		<span class="glyphicon glyphicon-menu-left"></span>
	</div>
</div>

<!-- Footer -->
<jsp:include page="./WEB-INF/view/common/footer.jsp"></jsp:include>