<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(document).ready( function() {
		$("#btnLogOut").click(function() {
			var form = $("#logoutForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/logout" />");
			form.submit();
		});
	});
</script>
    <div id="logout">
    	<form id="logoutForm">
    		<img src="<c:url value="/resource/img/btn-logout.png" />" id="btnLogOut" style="cursor: pointer" />
    	</form>
    </div>
    