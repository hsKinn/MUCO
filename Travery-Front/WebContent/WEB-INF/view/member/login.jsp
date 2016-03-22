<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<script type="text/javascript">
$(document).ready(function() {
	
});
</script>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
	</div><!-- id="header" -->

	<!-- Login -->
	<div id="login">
		<form id="loginForm">
			<input type="text" tabindex="1" id="userId" name="userId" placeholder=" ID" />
			<input type="password" tabindex="2" id="userPw" name="userPw" placeholder=" Password" />
			<input type="button" id="btnLogin" value="로그인" />
			<input type="hidden" id="facebookLogin" name="facebookLogin" />
	 	</form>
	</div>
	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>