<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />

<!-- My Package -->
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");

		$("#addPackImg").hide();
		
		$("#hashtagAddBtn").click(function() {
			var tag = $("#hashTag").val();
			var tags = $("#texthashtag").val();
			$(".hashtagBox").append(" #"+tag);
			$("#texthashtag").val(tags+" "+tag);
			$("#hashTag").val(null);
		});

		$(".btn-success").click(function() {
			var form = $("#addPack");
			form.attr("method", "post");
			form.attr("action", "/doAddPack");
			form.submit();
		});
		
		$(".btn-primary").click(function(){
			location.href="/detailPack";
		});

	});
</script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			$("#addPackImg").show();

			var reader = new FileReader();
			reader.onload = function(e) {
				$('#addPackImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<section class="bg-primary" >
	<div class="container">
		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">MY PACKAGE</h2>
			<hr class="primary">
			<p>Manage packages.</p>
		</div>

		<div id="mypackWrapperdiv">
			<div id="mypackListdiv">
				<table id="packListTable">
					<c:forEach items="${ packs}" var="packs">
						<tr>
							<td class="pack"><span class="glyphicon glyphicon-folder-close" id="folderImg"></span>
								<p id="title">${packs.packTitle}</p>
								<input type="hidden" id="packId" value="${packs.packId}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="buttondiv">
				 <button type="button" class="btn btn-primary btn-sm"style="width:120px;font-size: 15px;">
				 <span class="glyphicon glyphicon-ok" style="font-size: 15px;"></span>Okay</button>
			</div>
		</div>

		<div id="packListdiv2">
			<div id="addPackFormdiv" align="left">
				<form id="addPack" enctype="multipart/form-data" role="form">
					<div class="form-group" align="left"  style="display: inline;">
						<label for="file"> My package Image : </label> <br />
					</div>
					<div class="form-group" align="left"  style="display: inline;">
						<img id="addPackImg" class="img-rounded" src="#"
							style="width: 150px; height: 150px;" /><br /> <br /> <br /> <input
							type="file" id="image" name="image" accept="image/*"
							onchange="readURL(this); " />
					</div>
					<br />
					<div class="form-group">
						<label for="title">My package name : </label> <input type="text"
							class="form-control" id="title" name="title"
							style="width: 50%; display: inline;" />
					</div>
					<div class="form-group">
						<label for="packData_Title">Private / Public </label> <label class="switch">
							<input type="checkbox" id="packData_IsPublic"
							name="packData_IsPublic" value="1" />
							<div class="slider round"></div>
						</label>
					</div>
					<div class="form-group">
						<label for="texthashtag">Hash Tag :</label> <input type="hidden"
							name="texthashtag" id="texthashtag" /> <input type="text"
							class="form-control" id="hashTag" name="hashTag"
							style=" background-color:#eeeeee; color:#333333; width: 130px; display: inline;" />
						<button type="button" id="hashtagAddBtn" class="btn btn-info">Push</button>
						</br> <span class="hashtagBox"></span>
					</div>

					<button type="submit" class="btn btn-success" style="width: 130px;">AddPackage</button>
				</form>
			</div>
		</div>
	</div>
</section>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>