<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Boot Script -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />

<!-- My Package -->
<script type="text/javascript">
	$(document).ready(
			function() {

				$("#myPackMenu").mouseout(function() {
					$("#myPackMenu").css("color", "#ffffff");
				});
				$("#myPackMenu").css("color", "#ffffff");

				$("#placesOfPackListdiv").hide();

				$(".pack").click(
						function() {
							$("#placesOfPackListdiv").hide();
							$("#placesOfPackListdiv").fadeIn("slow");
							var packId = $(this).children(":eq(2)").val();

							$.post("/packInfo", {
								"packId" : packId
							}, function(data) {

								var jsonData = {};
								try {
									jsonData = JSON.parse(data);
								} catch (e) {
									jsonData.result = false;
								}
								console.log(jsonData);

								if (jsonData.result) {

									$("#packData_Title").val(jsonData.title);
									$("#packData_image").attr(
											"src",
											"/image?imageName="
													+ jsonData.imageName);
									if (jsonData.isPublic == 1) {
										$("#packData_IsPublic").attr("checked",
												true);
									} else {
										$("#packData_IsPublic").attr("checked",
												false);
									}
									$("#packData_likeCount").text(
											jsonData.likeCount);
									$("#packData_viewCount").text(
											jsonData.viewCount);
									$("#curpackId").val(jsonData.packId);
									$(".hashtagBox").text(jsonData.hashtags);
									$("#texthashtag").val(jsonData.hashtags);
								} else {
									/* alert("세션이 만료되었습니다. 다시 로그인해주세요.");
									location.href = "/"; */
								}
							});
						});
				$("#hashtagAddBtn").click(function() {
					var tag = $("#hashTag").val();
					var tags = $("#texthashtag").val();
					$(".hashtagBox").append(" #" + tag);
					$("#texthashtag").val(tags + " #" + tag);
					$("#hashTag").val(null);
				});
				$("#hashtagDeleteBtn").click(function(){
					var form = $("#modifyForm");
					form.attr("method", "post");
					form.attr("action", "/deleteHashTag");
					form.submit();
				});

				$("#modifyOkBtn").click(function() {
					var form = $("#modifyForm");
					var isPublic = $("#packData_IsPublic").is(":checked");
					form.attr("method", "post");
					form.attr("action", "/doModifyPack");
					form.submit();
				});
				$("#wantAddBtn").click(function(){
					location.href="/addPack";
				});
				$("#wantRemoveBtn").click(function(){
					location.href="/deletePack";
				});
				$("#wantOkBtn").click(function(){
					location.href="/myPack";
				});

			});
</script>

<section class="bg-primary">
	<div class="container">
		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">MY PACKAGE</h2>
			<hr class="primary">
			<p>손 쉽게 여행 예약을 할 수 있는 기능</p>
		</div>

		<!-- 내용 -->
		<div id="mypackWrapperdiv">
			<div id="mypackListdiv">
				<table id="packListTable">
					<c:forEach items="${packs}" var="packs">
						<tr>
							<td class="pack" style="width:100px;">
								<span class="glyphicon glyphicon-folder-close" id="folderImg"></span>
								<p id="title">${packs.packTitle}</p>
								<input type="hidden" id="packId" value="${packs.packId}" />
							</td>
							
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="buttondiv">
				 <button type="button" class="btn btn-primary btn-sm" id="wantAddBtn" style="width:80px;font-size: 15px;">
				 <span class="glyphicon glyphicon-plus" style="font-size: 15px;"></span> add</button>
				  <button type="button" class="btn btn-primary btn-sm" id="wantRemoveBtn" style="width:100px;font-size: 15px;">
				 <span class="	glyphicon glyphicon-remove" style="font-size: 15px;"></span> remove</button>
				  <button type="button" class="btn btn-primary btn-sm" id="wantOkBtn" style="width:80px;font-size: 15px;">
				 <span class="glyphicon glyphicon-ok" style="font-size: 15px;"></span> okay</button>
			</div>
		</div>

		<div id="packListdiv2">
			<div id="placesOfPackListdiv" align="left">
				<img id="packData_image" src="#" /><br /> <br />
				<form id="modifyForm" enctype="multipart/form-data">
					<div class="form-group" align="left">
						<input type="file" name="file" value="file" />
					</div>
					<div class="form-group">
						<label for="packData_Title">Pack Title :</label> <input
							type="text" class="form-control" id="packData_Title"
							name="packData_Title" style="width: 50%; display: inline;"></span><br />
						<input type="hidden" id="curpackId" name="curpackId" /> <input
							type="submit" style="display: none" />
					</div>
					<div class="form-group">
						<label for="packData_Title">Private / Public </label> <label class="switch">
							<input type="checkbox" id="packData_IsPublic"
							name="packData_IsPublic" value="1" />
							<div class="slider round"></div>
						</label>
					</div>
					<div class="form-group">
						 <span id="packData_viewCount" name="packData_viewCount"></span>
						<label for="viewCount" >  <b>View  | </b> </label>
					
						<span id="packData_likeCount" name="packData_likeCount"></span>
						<label for="likeCount" >  <b>Like</b></label>
					</div>
					<div class="form-group">
						<label for="texthashtag">Hash Tag :</label> 
						<input type="hidden"
							name="texthashtag" id="texthashtag" style="color:black;"/> 
							<input type="text"
							class="form-control" id="hashTag" name="hashTag"
							style=" background-color:#eeeeee; color:#333333; width: 130px; display: inline;" />
						<button type="button" id="hashtagAddBtn" class="btn btn-info" style="height:25px;font-size:13px;">Push</button>
						</br> <span class="hashtagBox" name="hashtagBox"></span>

						<button type="button" id="hashtagDeleteBtn" class="btn btn-danger" style="width:75px; height:25px; font-size:13px;">delete all</button>

					</div>
				</form>
				<button type="button" class="btn btn-success" id="modifyOkBtn" >Modify</button>
			</div>
		</div>
	</div>
</section>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>