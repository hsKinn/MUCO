<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnLogOut").click(function() {
			var form = $("#logoutForm");
			form.attr("method", "post");
			form.attr("action", "/logout");
			form.submit();
		});
	});
</script>
    <div id="logout">
    	<form id="logoutForm">
    		<img src="/resource/img/btn-logout.png" id="btnLogOut" />
    	</form>
    </div>