<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript">
<%

	Cookie[] cookies = request.getCookies();
	
	String userId = "";
	String userPassword = "";
	String autoLogin = "";
	
	for ( Cookie cookie : cookies ) {
		if ( cookie.getName().equals("userId") ) {
			userId = cookie.getValue();
		}
		else if ( cookie.getName().equals("userPassword") ) {
			userPassword = cookie.getValue();
		}
		else if ( cookie.getName().equals("autoLogin") ) {
			autoLogin = cookie.getValue();
		}
	}

%>

	$(document).ready(function() {
		
		$("#btnLogin").click(function() {

			var form = $("#loginForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/doLogin" />");
			form.submit();
			
		});
		
		$("#btnJoin").click(function() {
			
			location.href="/registerMember";
			
		});
		
		$("#userPw").keyup( function(e) {
			if ( e.keyCode == 13 ) {
				
				$("#btnLogin").click();
			}
		}) ;
		
		var autoLogin = "<%= autoLogin %>";
		if ( autoLogin == "true" ) {
			$("#userPw").val("<%= userPassword %>");
			$("#userId").val("<%= userId %>");
			$("#btnLogin").click();
		}
	});

</script>    

    	<div id="login">
    		<form id="loginForm">
    			<img src="<c:url value="/resource/img/join.png" />" tabindex="4" id="btnJoin" />
    			<img src="<c:url value="/resource/img/login.png" />" tabindex="3" id="btnLogin" />
    			<input type="password" tabindex="2" id="userPw" name="userPw" placeholder="Password">
    			<input type="text" tabindex="1" id="userId" name="userId" placeholder="ID" autofocus>
    		</form>
    	</div>
    	
    	<div class="clear"></div>