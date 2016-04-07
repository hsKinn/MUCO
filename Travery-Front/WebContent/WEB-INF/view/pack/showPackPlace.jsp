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
	$(document).ready(function() {

		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");

		$("#myPackMenu").css("color", "#ffffff");

		$(".pack").click(function() {
			$("#placesOfPackListdiv").hide();
			$("#placesOfPackListdiv").fadeIn("slow");
			var packId = $(this).children(":eq(2)").val();
			location.href = "/showPackPlace?packId=" + packId;
			$("/packId").val(packId);
		});

		$(".submitLabel").click(function() {

			var form = $(".deletePlaceOfPackForm");
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/deletePlaceOfPack"/>");
			form.submit();

		});

		$(".pack").click(function() {
			$("#placesOfPackListdiv").fadeOut();
			$("#placesOfPackListdiv").fadeIn("slow");

			var packId = $(this).children(":eq(2)").val();
			location.href = "/showPackPlace?packId=" + packId;

		});

		$("#wantModifyBtn").click(function() {
			location.href = "/detailPack";
		});

	});
</script>

<section class="bg-primary">
	<div class="container">
		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">MY PACKAGE</h2>
			<hr class="primary">
			<p>Manage packages.</p>
		</div>

		<!-- 내용 -->
		<div id="mypackWrapperdiv">
			<div id="mypackListdiv">
				<table id="packListTable">
					<c:forEach items="${packs}" var="packs">
						<tr>
							<td class="pack"><span
								class="glyphicon glyphicon-folder-close" id="folderImg"></span>
								<p id="title">${packs.packTitle}</p> <input type="hidden"
								id="packId" value="${packs.packId}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="buttondiv">
				<button type="button" class="btn btn-primary btn-sm"
					id="wantModifyBtn" style="width: 150px; font-size: 15px; ">
					<span class="glyphicon glyphicon-wrench" style="font-size: 15px;"></span>modify
				</button>
			</div>
		</div>



		<div id="packListdiv2">
			<div id="placesOfPackListdiv">
				<div id="wrapper">
					<!-- Header -->
					<div>
						<a href="index.html" class="logo"></a>
					</div>


					<!-- Main -->
					<div class="inner">
						<section class="tiles"
							style="vertical-align: top; padding-top: 0px;">
							<c:forEach items="${places}" var="places">

								<article class="${places.countryName}">
									<span class="image" style="height: 150px;"> <img
										src="/image?imageName=${places.placeImageList[0].imageName}"
										alt="" style="height:100%;" />
									</span> <a href="#"
										onclick="window.open('/detailPlace?placeId=${places.placeId}','Place Detail','toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizeable=no, width=930, height=820');">
										<p>${ places.placeName }</p>
										<div class="content">
											<p>${ places.countryName}</p>
										</div>
									</a>
								</article>
							</c:forEach>
						</section>
					</div>
				</div>
			</div>
		</div>

	</div>


</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>