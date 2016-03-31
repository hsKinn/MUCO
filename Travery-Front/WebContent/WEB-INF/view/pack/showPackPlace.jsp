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

		$(".switch").click(function() {
			alert();
		});

	});
</script>
<section class="bg-primary" >
	<div class="container">
		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">MY PACKAGE</h2>
			<hr class="primary">
			<p>손 쉽게 여행 예약을 할 수 있는 기능</p>
		</div>

		<!-- 내용 -->
		<div id="mypackWrapperdiv">
			<div id="packListdiv">
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
				<a href="/detailPack"><span class="glyphicon glyphicon-cog"></span></a>
			</div>
		</div>

		<div id="packListdiv2">
			<div id="placesOfPackListdiv">
				<table id="placeListTable" border="2">
					<c:forEach items="${places}" var="places">
						<tr width="200px">
							<td class="place">
								<p id="title" data-toggle="modal"
									data-target="#${places.placeId}"
									style="display: inline; cursor: pointer;">
									${places.placeName}</p> <input type="hidden" class="placeId"
								name="placeId" value="${places.placeId}" />
								<form class="deletePlaceOfPackForm" style="display: inline;">
									<label class="submitLabel"> <span
										class="glyphicon glyphicon-remove"
										style="font-size: 20px; cursor: pointer;"></span> <input
										type="hidden" class="placeId" name="placeId"
										value="${places.placeId}" /> <input type="hidden"
										class="packId" name="packId" value="${packId}" /> <input
										type="submit" style="display: none" />
									</label>
								</form>
							</td>
						</tr>

						<div id="${places.placeId}" class="modal fade" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">${places.placeName}</h4>
									</div>
									<div class="modal-body">
										<p>Some text in the modal.</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>

							</div>
						</div>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>