<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/* 	이페이지가 보이면 쿠키로 가라고 지시 */
	Cookie[] cookies = request.getCookies();
	String userId= "";
	String userPassword = "";
	String autoLogin= "";
	
	for ( Cookie cookie : cookies ) {
		if ( cookie.getName().equals("userId")) {
			userId = cookie.getValue();
		}
		else if ( cookie.getName().equals("userPassword")) {
			userPassword = cookie.getValue();
		}
/* 		else if ( cookie.getName().equals("autoLogin")) {
			autoLogin = cookie.getValue();
		} */
		
	}
%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			var form = $("#loginForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/doLogin"/>");
			form.submit();
		});
		
<%-- 		var autoLogin = "<%= autoLogin %>";
		if ( autoLogin == "true") {
			$("#userPwd").val("<%= userPassword %>");	
			$("#userId").val("<%= userId %>");	
			$("#btnLogin").click();
		} --%>
	});
/* 	순서가 중요하다.*/	
</script>
    <div id="login">
    	<form id="loginForm">
    		<input type="password" tabindex="2" id="userPwd" name="userPwd" placeholder="PWD" />
    		<input type="text" tabindex="1" id="userId" name="userId" placeholder="ID" />
    		<div class="clear"></div>
			<img tabindex="3" src="<c:url value="/resource/img/btn-login.png" />" id="btnLogin" style="cursor: pointer" />
    	</form>
    </div>