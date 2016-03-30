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




				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content-top">
							<img src="/resource/img/pack/basic${ i }.jpg" />
						</div>
						<div class="content-middle">일일 여행지 Title</div>
						<div class="content-bottom">
							<div class="bottom-top">Writer</div>
							<div class="bottom-first">
								<span class="badge">${ i*21 }</span>
							</div>
							<div class="bottom-second">
								<span class="glyphicon glyphicon-heart"></span> <span
									id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>
				
				
				
				after
<c:forEach items="${ placeInfo.placeInfoList }" var="placeInfo">
		<div class="container">
			<div class="list-group" style="width: 150px;">
				<form id="massiveDeleteForm">
					<a href="#" class="list-group-item list-group-item-success">
					${ placeInfo.placeName }</a> 
					<a href="#" class="list-group-item list-group-item-info">${ placeInfo.imageLocation }</a>
				</form>
			</div>
		</div>
</c:forEach>
				
				
				
				before
	<c:forEach items="${ placeInfo }" var="placeInfo">
		<div class="container">
			<div class="list-group" style="width: 150px;">
				<form id="massiveDeleteForm">
					<a href="#" class="list-group-item list-group-item-success"><input
						type="checkbox" class="deletePlaceId" name="deletePlaceId"
						value="${ placeInfo.placeId }" />${ placeInfo.placeName }</a> <a
						href="#" class="list-group-item list-group-item-info"></a>
				</form>
			</div>
		</div>
	</c:forEach>



<div id="구현예정">
	<c:if test="${ not empty article }">
		<input type="hidden" name="articleId" value="${ article.articleId }" />
		<input type="button" id="doModify" value="modify" />
		<input type="button" value="reset" />
	</c:if>
</div>









<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>