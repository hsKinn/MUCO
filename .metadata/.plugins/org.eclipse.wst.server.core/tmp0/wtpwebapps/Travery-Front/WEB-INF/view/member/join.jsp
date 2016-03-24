<!-- 유병훈 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
</div><!-- id="header" -->

<script type="text/javascript">

	$(document).ready( function(){
		
	
		$("#btnJoin").click( function(){
			
			var userEmail = $("#userEmail").val();
			userEmail = $.trim(userEmail);
			if ( userEmail == "" ) {
				alert("이메일을 입력하세요!");
				$("#userEmail").focus();
				return;
			}
		
			var userPassword = $("#userPassword").val();
			userPassword = $.trim(userPassword);
			if ( userPassword == "" ) {
				alert("비밀번호를 입력하세요!");
				$("#userPassword").focus();
				return;
			}
			
			var userName = $("#userName").val();
			userName = $.trim(userName);
			if ( userName == "" ) {
				alert("닉네임을 입력하세요!");
				$("#userName").focus();
				return;
			}
			
			
			var form = $("#joinForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/doJoin"/>");
			form.submit();
		} );
		
	} );
	
</script>

	<!-- Join -->
	<div id="join">
		<div>
			<form id="joinForm">
				<input type="text" id="userEmail" name="userEmail" placeholder="Email"/>
				<input type="password" id="userPassword" name="userPassword" placeholder="Password"/>
				<input type="text" id="userName" name="userName" placeholder="Nick name"/>
				<input type="button" id="btnJoin" value="가입하기" />
			</form>
		</div>
	</div>
	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>