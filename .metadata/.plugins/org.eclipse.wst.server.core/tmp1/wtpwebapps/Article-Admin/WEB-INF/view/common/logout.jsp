<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready( function() {
	
	$("#btnLogout").click( function() {
		
		location.href="<c:url value="/logout" />";
		
	} );
	
} );
</script>

<c:set var="loginId" value="${ sessionScope._MEMBER_.memberId }" />

	<div id="logout">

		<img src="<c:url value="/resource/img/logout.png"/>" id="btnLogout" />
		${ loginId } 님 로그인 중...
	
	</div>

