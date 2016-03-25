<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/placeInfoControl.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resource/js/snap.js" />"></script>
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
<script type="text/javascript">
	
	$(document).ready( function() {
		
		$("#createBtn").click(function() {
			var form = $("#createForm");
			form.attr("method", "post");
			form.attr("action", "<c:url value="/placeInfoCreate"/>");
			form.submit();
		});
		
		
		
		$("#massiveSelectCheckBox").click( function() {
			var isChecked = $(this).prop("checked");
			$(".deletePlaceId").prop("checked", isChecked);
		});
		
		$("#massiveDeleteBtn").click( function() {
			var isChecked = false;
			$(".deletePlaceId").each( function (index, data) {
				if (data.checked) {
					isChecked = data.checked;
				}
			});
			if ( !isChecked ) {
				alert("삭제하실 추천리스트를 선택해주세요.");
				return;
			}
			if ( confirm("정말로 삭제 하시겠습니까?") ) {
				var form = $("#massiveDeleteForm");
				form.attr("method", "post");
				form.attr("action", "<c:url value="/placeInfoMassiveDelete" />");
				form.submit();
			}
		});
		

		
		
		
		
	});


</script>


<div id="placeInfoControl_Wrapper">






	<div id="my_recommendPlaceTitle">
		<img src="<c:url value="/resource/img/place/tags-image.png" />" />
		내추천여행지
	</div>

	<div id="inner_wrapper">
		<div id="my_previousPlaceList">이미지 List정보 받아오기 checkbox/placeName/image</div>
	</div>

	<div id="placeInfoControler">
		<div id="btn-create">
			<form id="createForm">
				<img src="<c:url value="/resource/img/place/btn-create.png" />" id="createBtn" style="cursor: pointer" />
			</form>	
		</div>
		<div id="btn-delete">
			<form id="deleteForm">
				<img src="<c:url value="/resource/img/place/btn-delete.png" />" id="massiveDeleteBtn" style="cursor: pointer" />
			</form>	
		</div>
	</div>




</div>





<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>