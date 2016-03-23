<!-- 김광민 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#hitTheRoadMenu").mouseout(function(){
		$("#hitTheRoadMenu").css("color", "#ffffff");
	});
	$("#hitTheRoadMenu").css("color", "#ffffff");

});
</script>

<!-- Hit the road -->

Hit the road
	
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>