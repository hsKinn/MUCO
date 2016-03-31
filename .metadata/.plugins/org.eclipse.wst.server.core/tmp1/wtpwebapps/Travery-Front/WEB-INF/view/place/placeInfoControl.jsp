<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<c:url value="/resource/css/place/placeInfoControl.css"/>" />

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
<div class="jumbotron"
	style="width: 50%; height: 90%; float: left; margin-left: 4%; margin-top: 1.5%;">
	<div id="title"
		style="margin-left: 2%; top: 0; width: 100%; height: 10%;">
		<span class="glyphicon glyphicon-tags"
			style="margin-right: 3%; float: left;"></span>
		<H2>내 추천 여행지</H2>
		<input type="checkbox" id="massiveSelectCheckBox" />전체선택
	</div>
	


			<c:forEach items="${ placeInfo.placeList }" var="placeInfo">
				<tr>
					<td>${ placeInfo.placeName }</td>
					<td>${ placeInfo.imageLocation }</td>
				</tr>
			</c:forEach>

	<div id="inner_wrapper">
		<div id="allCheckBox">
			<input type="checkbox" id="massiveSelectCheckBox" />
		</div>
		이미지 List정보 받아오기 checkbox/placeName/image
		<form id="massiveDeleteForm">
			<c:forEach items="${ placeInfo.placeInfoList }" var="placeInfo">
				<div id="my_previousPlaceList">

					<input type="checkbox" class="deletePlaceId" name="deletePlaceId"
						value="${ placeInfo.placeId }" /> <a
						href="<c:url value="/hit?placeId=${placeInfo.placeId}" />"> ${ placeInfo.placeName }</a>
					<c:if test="${placeInfo.fileCount gt 0 }"> 
							[${placeInfo.fileCount} each files included]
						</c:if>
				</div>
			</c:forEach>
		</form>
	</div>

	<div style="width: 20%; float: right; margin-top: 70%; background-color: red; position: absolute;">
		<div id="btn-create" style="float: left;">
			<form id="createForm">
				<span class="glyphicon glyphicon-pencil" id="createBtn"
					style="cursor: pointer; position: absolute;"></span>
			</form>
		</div>
		<div id="btn-delete" style="margin-left: 10%; float: left;">
			<form id="deleteForm">
				<span class="glyphicon glyphicon-trash" id="massiveDeleteBtn"
					style="cursor: pointer"></span>
			</form>
		</div>
	</div>
</div>

<div class="jumbotron"
	style="width: 21%; height: 90%; float: left; margin-left: 2%; margin-top: 1.5%;">
	<form id="dataForm" name="dataform" enctype="multipart/form-data">
		<div class="container">
			<div style="margin-left: 13%;">
				<h2>여행지 등록하기</h2>
			</div>
			<div class="panel-group">
				<div class="panel panel-default" style="width: 100%;">
					<div class="panel-heading">
						<input type="text" id="placeName" name="placeName"
							placeholder="#여행지명" value="${placeInfo.placeName}"
							style="padding: 0, 0, 0, 0; width: 100%;" />
					</div>
					<div class="panel-body">
						<span class="glyphicon glyphicon-map-marker" id="mapBtn"
							onclick="openMap(this.form)"
							style="float: left; cursor: pointer;"></span> 
						<input type="text"
							id="address" name="address" placeholder="#address"
							value="${placeInfo.address}" size="12"
							style="margin-left: 5%; float: left;" /> 
						<input type="hidden"
							id="lat" name="lat" placeholder="#latitude"
							value="${placeInfo.latitude}" size="12" /> 
						<input type="hidden"
							id="lng" name="lng" placeholder="#longitude"
							value="${placeInfo.longitude}" size="12" />
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="panel-group">
				<div class="panel panel-default" style="width: 100%;">
					<div class="panel-heading" style="font-size: 10px;">
						<span class="glyphicon glyphicon-camera"
							style="cursor: pointer; float: left;"></span> 
						<input type="file"
							id="image" name="image" accept="image/*"
							onchange="readURL(this);" required
							style="float: left; margin-left: 2%;" />
					</div>
					<div class="panel-body">
						<img id="blah" class="img-circle" src="#"
							style="margin-left: 25%; width: 150px; height: 150px;" />
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="panel-group">
				<div class="panel panel-default" style="height: 100%; width: 100%;">
					<div class="panel-heading" style="height: 250px;">
						<textarea id="description" name="description"
							style="height: 100%; width: 100%;">${ placeInfo.description }</textarea>
					</div>
					<div class="panel-body">
						SUBMIT
						<c:if test="${ empty placeInfo }">
							<span class="glyphicon glyphicon-send" id="submitBtn"
								style="cursor: pointer"></span>
						</c:if>
					</div>
				</div>
			</div>
		</div>

	</form>
</div>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>