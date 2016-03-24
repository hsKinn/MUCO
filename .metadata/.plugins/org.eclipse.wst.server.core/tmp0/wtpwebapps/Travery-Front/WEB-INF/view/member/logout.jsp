<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	</div> <!-- Header -->
=======
<!-- 김광민 -->
<!-- 건들지마 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Log out -->

<script type="text/javascript">
	$(document).ready(function() {
		
		$("#logout").mouseenter(function(){
			$("#logout").css("background-color", "#ffffff");
			$("#logout").css("color", "#333333");
		});
		
		$("#logout").mouseleave(function(){
			$("#logout").css("background-color", "#8b8b8b");
			$("#logout").css("color", "#333333");
		});
		
		$("#logout").click(function() {
			location.href = "<c:url value="/logout" />";
		});
	});
</script>

<div id="logout">
	로그아웃
</div>

<!-- Close "#header" -->
</div>
>>>>>>> YBH3
