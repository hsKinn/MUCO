<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/placeInfoControl.css"/>" />
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
	$(document)
			.ready(
					function() {

						/* 		$("#createBtn").click(function() {
						 var form = $("#createForm");
						 form.attr("method", "post");
						 form.attr("action", "<c:url value="/placeInfoCreate"/>");
						 form.submit();
						 }); */

						<c:if test="${ empty placeInfo }">
						$("#submitBtn")
								.click(
										function() {
											var form = $("#dataForm");
											form.attr("method", "post");
											form
													.attr("action",
															"<c:url value="/placeInfoCreate"/>");
											form.submit();
										});
						</c:if>
						<c:if test="${ not empty placeInfo}">
						$("#modifyBtn")
								.click(
										function() {
											var form = $("#dataForm");
											form.attr("method", "post");
											form
													.attr("action",
															"<c:url value="/placeInfoModify" />");
											form.submit();
										});
						</c:if>

						$("#massiveSelectCheckBox").click(function() {
							var isChecked = $(this).prop("checked");
							$(".deletePlaceId").prop("checked", isChecked);
						});

						$("#massiveDeleteBtn")
								.click(
										function() {
											var isChecked = false;
											$(".deletePlaceId")
													.each(
															function(index,
																	data) {
																if (data.checked) {
																	isChecked = data.checked;
																}
															});
											if (!isChecked) {
												alert("삭제하실 추천리스트를 선택해주세요.");
												return;
											}
											if (confirm("정말로 삭제 하시겠습니까?")) {
												var form = $("#massiveDeleteForm");
												form.attr("method", "post");
												form
														.attr("action",
																"<c:url value="/placeInfoMassiveDelete" />");
												form.submit();
											}
										});
					});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#mapBtn")
								.click(
										function openMap() {
											url = "<c:url value="/placeInfoAddAddress"/>";
											window
													.open(
															url,
															"GoogleMapAPI",
															"toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizeable=no, width=1000, height=800");
										});
						function Mapdata() {
							GoogleMapAPI.document.dataform.lat;
							GoogleMapAPI.document.dataform.lng;
							GoogleMapAPI.document.dataform.address;
						}
					});
</script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

<div id="placeInfoControl_Wrapper">

	<div id="my_recommendPlaceTitle">
		<img src="<c:url value="/resource/img/place/tags-image.png" />" />
		내추천여행지
	</div>

	<div id="inner_wrapper">
		<div id="allCheckBox">
			<input type="checkbox" id="massiveSelectCheckBox" />
		</div>
		이미지 List정보 받아오기 checkbox/placeName/image
		<div id="my_previousPlaceList">
			<form id="massiveDeleteForm">
				<c:forEach items="${ placeInfo.placeInfoList }" var="placeInfo">
					<input type="checkbox" class="deletePlaceId" name="deletePlaceId" value="${ placeInfo.placeId }" />
						${ placeInfo.placeName }
				</c:forEach>
			</form>
		</div>
	</div>

	<div id="placeInfoControler">
		<div id="btn-create">
			<form id="createForm">
				<img src="<c:url value="/resource/img/place/btn-create.png" />"
					id="createBtn" style="cursor: pointer" />
			</form>
		</div>
		<div id="btn-delete">
			<form id="deleteForm">
				<img src="<c:url value="/resource/img/place/btn-delete.png" />"
					id="massiveDeleteBtn" style="cursor: pointer" />
			</form>
		</div>
	</div>

	<div id="right_wrapper">
		<div id="placeInfoCreate_main">여행지 등록하기</div>
		<form id="dataForm" name="dataform" enctype="multipart/form-data">
			<div id="placeInfoCreate_title">
				<input type="text" id="placeName" name="placeName"
					placeholder="여행지명을 작성해주세요." value="${placeInfo.placeName}" />
			</div>
			<div id="placeInfoCreate_searchMap">
				<img src="<c:url value="/resource/img/place/btn-map.png" />"
					id="mapBtn" onclick="openMap(this.form)" /> <input type="text"
					id="address" name="address" placeholder="#address"
					value="${placeInfo.address}" /> <input type="text" id="lat"
					name="lat" placeholder="#latitude" value="${placeInfo.latitude}" />
				<input type="text" id="lng" name="lng" placeholder="#longitude"
					value="${placeInfo.longitude}" />
			</div>

			<div id="placeInfoCreate_imageUpload">
				<input type="file" id="image" name="image" /> <img id="blah"
					class="img-circle" src="#" style="width: 85px; height: 85px;" /><br />
			</div>
			<div id="placeInfoCreate_description">
				<textarea id="description" name="description">${ placeInfo.description }</textarea>
			</div>
			<div id="placeInfoCreate_submitBtn">
				<c:if test="${ empty placeInfo }">
					<img src="<c:url value="/resource/img/place/btn-submit.png" />"
						id="submitBtn" />
				</c:if>
			</div>
			<div id="구현예정">
				<c:if test="${ not empty article }">
					<input type="hidden" name="articleId"
						value="${ article.articleId }" />
					<input type="button" id="doModify" value="modify" />
					<input type="button" value="reset" />
				</c:if>
			</div>
		</form>
	</div>
</div>




<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>