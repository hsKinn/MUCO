<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- Recommend Place -->
<script type="text/javascript">
	$(document).ready(function() {

		$("#recommendPlaceMenu").mouseout(function() {
			$("#recommendPlaceMenu").css("color", "#ffffff");
		});
		$("#recommendPlaceMenu").css("color", "#ffffff");

	});
</script>

<div id="recommendPlace_Wrapper">
	<div id="search_part">
		<input type="text" placeholder="# Search" />
	</div>
	<div id="inner_wrapper">
	<div id="daily_part">daily recommends
	</div>
	<div id="weekly_part">weekly recommends</div>
	<div id="monthly_part">monthly recommends</div>
	</div>
	<div id="inner_wrapper2">
	<div id="new_part">new recommends</div>
	</div>
		<div id="btn-recommend">
		<a href="/placeInfoControl" id="placeInfoControl">
			<img src="/resource/img/place/btn-recommend.png" id="btn-recommend" />		
		</a>
	</div>
</div>



<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>