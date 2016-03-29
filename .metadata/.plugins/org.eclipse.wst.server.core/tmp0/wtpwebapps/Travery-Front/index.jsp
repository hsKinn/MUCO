<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="./WEB-INF/view/common/header.jsp"></jsp:include>
</div>
<!-- id="header" -->


<script type="text/javascript">
	$(document).ready(function() {
		
		$("#join").hide();
		$("#login").hide();
		$("#goBack").hide();
		
	    $("#letsJoin").click(function(){
	    	 $("#letsJoin").animate({
	             height: 'toggle'
	         });
	    	 $("#join").animate({
	             height: 'toggle'
	         });
	    	 
			$("#letsLogIn").hide();
			$("#login").hide();
			$("#goBack").show();
	    });
	    
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
		
	});
</script>


<!-- Index -->
<div id="index">

	<div id="join">
		<div>
			<form id="joinForm">
			
				<input type="text" class="form-control"	tabindex="1" id="userEmail" name="userEmail"
					placeholder="Email" >
				<input type="password" class="form-control"	tabindex="2" id="userPassword"
					name="userPassword" placeholder="Password" > 			
				<input type="text" class="form-control"	tabindex="1" id="userName" name="userName" placeholder="Nick name" >	
							
				<input type="button" id="btnJoin" value="가입하기" />
			</form>
		</div>
	</div>
	
	
	<div id="login">
		<form id="loginForm">
			<input type="text" class="form-control"	tabindex="1" id="userEmail" name="userEmail" placeholder=" Email" >
			<input type="password" class="form-control"	tabindex="2" id="userPw" name="userPw" placeholder=" Password" > 
			<input type="button" id="btnLogin" value="로그인" />
		</form>
	</div>	
	
	<div id="letsJoin">
		<a>Join</a>
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