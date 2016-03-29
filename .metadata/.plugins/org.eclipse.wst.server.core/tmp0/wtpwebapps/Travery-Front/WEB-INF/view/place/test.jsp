<!-- test -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>









<script type="text/javascript">
	function readURL(input) {

		document.getElementById("imgFile").required;
		document.getElementById("imgFile").accept = "img/*";
		var x = document.getElementById("imgFile");
		var txt = "";
		if ('files' in x) {
			if (x.files.length == 0) {
				txt = "Select one or more files.";
			} else {
				for (var i = 0; i < x.files.length; i++) {
					txt += "<br><strong>" + (i + 1) + ". file</strong><br>";
					var file = x.files[i];
					if ('name' in file) {
						txt += "name: " + file.name + "<br>";
					}
					if ('size' in file) {
						txt += "size: " + file.size + " bytes <br>";
					}
				}
			}
		} else {
			if (x.value == "") {
				txt += "Select one or more files.";
			} else {
				txt += "The files property is not supported by your browser!";
				txt += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead. 
			}
			document.getElementById("demo").innerHTML = txt;
		}

		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#imagePreview").show();
				$('#uploadImg').attr("src", e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>





<div class="jumbotron" style="width: 50%; height: 90%; float: left; margin-left: 4%; margin-top: 1%;">
	<div id="title" style="margin-left: 2%; top: 0;">
		<h2>내 추천 여행지</h2>
	</div>
	<div class="container">
		<div class="list-group" style="width: 150px;">
			<a href="#" class="list-group-item list-group-item-success">First item</a>
			<a href="#" class="list-group-item list-group-item-info">Second item</a>
		</div>
	</div>
	
	<div style=" width:20%; float: right; bottom: 0;">
		<div id="btn-create" style="float: left; ">
			<form id="createForm">
				<img src="<c:url value="/resource/img/place/btn-create.png" />" id="createBtn" style="cursor: pointer" />
			</form>
		</div>
		<div id="btn-delete" style="margin-left:10%; float: left;">
			<form id="deleteForm">
				<img src="<c:url value="/resource/img/place/btn-delete.png" />" id="massiveDeleteBtn" style="cursor: pointer" />
			</form>
		</div>
	</div>
	

</div>

<div class="jumbotron"
	style="width: 21%; height: 90%; float: left; margin-left: 2%; margin-top: 1%;">
	<form id="dataForm" name="dataform" enctype="multipart/form-data">

		<div class="container">
			<div style="margin-left: 13%;">
				<h2>여행지 등록하기</h2>
			</div>
			<div class="panel-group">
				<div class="panel panel-default" style="width: 100%;">
					<div class="panel-heading">
						<input type="text" id="placeName" name="placeName"
							placeholder="#여행지명" value="${placeInfo.placeName}" style="padding:0,0,0,0; width: 100%;" />
					</div>
					<div class="panel-body">
						<input type="text" id="address" name="address"
							placeholder="#address" value="${placeInfo.address}" size="12"
							style="float: left;" /> <input type="hidden" id="lat" name="lat"
							placeholder="#latitude" value="${placeInfo.latitude}" size="15" />
						<input type="hidden" id="lng" name="lng" placeholder="#longitude"
							value="${placeInfo.longitude}" size="15" /> <img
							src="<c:url value="/resource/img/place/btn-map.png" />"
							id="mapBtn" onclick="openMap(this.form)" style="position: absolute;" />
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="panel-group">
				<div class="panel panel-default" style="width: 100%;">
					<div class="panel-heading" style="font-size: 10px;">
						<input type="file" id="image" name="image" accept="image/*" onchange="readURL(this);" required />
					</div>
					<div class="panel-body">
						<img id="blah" class="img-circle" src="#"
							style="margin-left: 18%; width: 85px; height: 85px;" />
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="panel-group" >
				<div class="panel panel-default" style="height: 100%; width: 100%;">
					<div class="panel-heading" style="height: 300px;">
						<textarea id="description" name="description"
							style="height: 100%; width: 100%;">${ placeInfo.description }</textarea>
					</div>
					<div class="panel-body">
						SUBMIT
						<c:if test="${ empty placeInfo }">
							<img src="<c:url value="/resource/img/place/btn-submit.png" />"
								id="submitBtn" />
						</c:if>
					</div>
				</div>
			</div>
		</div>

	</form>
</div>



<div id="구현예정">
	<c:if test="${ not empty article }">
		<input type="hidden" name="articleId" value="${ article.articleId }" />
		<input type="button" id="doModify" value="modify" />
		<input type="button" value="reset" />
	</c:if>
</div>









<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>