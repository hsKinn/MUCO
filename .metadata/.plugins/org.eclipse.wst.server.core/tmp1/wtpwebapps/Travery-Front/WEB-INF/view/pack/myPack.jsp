<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- My Package -->
<script type="text/javascript">

	$(document).ready(function() {

		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");


		$("#placesOfPackListdiv").hide();

		$(".pack").click(function() {
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
					$("#packData_image").attr("src", "/image?imageName="+jsonData.imageName);
					if (jsonData.isPublic == 1) {
						$("#packData_IsPublic").attr("checked", true);
					} else {
						$("#packData_IsPublic").attr("checked", false);
					}
					$("#packData_likeCount").text(jsonData.likeCount);
					$("#packData_viewCount").text(jsonData.viewCount);
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
			$(".hashtagBox").append(" #"+tag);
			$("#texthashtag").val(tags+" "+tag);
			$("#hashTag").val(null);
		});

		$(".btn-success").click(function() {
			var form = $("#modifyForm");
			var isPublic = $("#packData_IsPublic").is(":checked");
			form.attr("method", "post");
			form.attr("action", "/doModifyPack");
			form.submit();
		});

	});
</script>

<body>
	<div id="mypackWrapperdiv">
		<div id="mypackListdiv">
			<table id="packListTable" border="2">
				<c:forEach items="${packs}" var="packs">
					<tr>
						<td class="pack"><img
							src="<c:url value="/resource/img/pack/folder.png"/>"
							id="folderImg" /> <label id="title" for="packData_Title"
							style="font-size: 20px; display: inline;">${packs.packTitle}</label>
							<input type="hidden" id="packId" value="${packs.packId}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="buttondiv">
			<a href="/addPack"><span class="glyphicon glyphicon-plus-sign"></span></a>
			<a href="/deletePack"><span
				class="glyphicon glyphicon-minus-sign"></span></a> <a href="/myPack"><span
				class="glyphicon glyphicon-ok-sign"></span></a>
		</div>
	</div>

	<div id="packListdiv2">
		<div id="placesOfPackListdiv" align="center">
			<img id="packData_image" src="#" /><br />
			<br />
			<form id="modifyForm" enctype="multipart/form-data">
				<div class="form-group" align="center">
					<input type="file" name="file" value="file" />
				</div>
				<div class="form-group">
					<label for="packData_Title">Pack Title :</label> <input type="text"
						class="form-control" id="packData_Title" name="packData_Title"
						style="width: 50%; display: inline;"></span><br /> <input
						type="hidden" id="curpackId" name="curpackId" /> <input
						type="submit" style="display: none" />
				</div>
				<div class="form-group">
					<label for="packData_Title">Share :</label> <label class="switch">
						<input type="checkbox" id="packData_IsPublic"
						name="packData_IsPublic" value="1" />
						<div class="slider round"></div>
					</label>
				</div>
				<div class="form-group">
					<label for="viewCount">View Count :</label> <span
						id="packData_viewCount" name="packData_viewCount"></span>
				</div>
				<div class="form-group">
					<label for="likeCount">Like Count :</label> <span
						id="packData_likeCount" name="packData_likeCount"></span>
				</div>
				<div class="form-group">
				<label for="texthashtag">Hash Tag :</label>
				<input type="hidden" name="texthashtag" id="texthashtag"/>
				  <input type="text" class="form-control" id="hashTag" name="hashTag"style="width:30%;display: inline;"/>
				  <button type="button" id="hashtagAddBtn" class="btn btn-info">Push</button></br>				
				  <span class="hashtagBox" name="hashtagBox"></span>
				</div>
			</form>
			<button type="button" class="btn btn-success">OK</button>
		</div>
	</div>
</body>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>