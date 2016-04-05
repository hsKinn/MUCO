<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Boot Script -->
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

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

			$("#wantModifyBtn").click(function(){
				location.href="/detailPack";
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
			<div id="mypackListdiv">
				<table id="packListTable" >
					<c:forEach items="${packs}" var="packs">
						<tr>
							<td class="pack"><span class="glyphicon glyphicon-folder-close" id="folderImg"></span>
								<p id="title">${packs.packTitle}</p>
								<input type="hidden" id="packId" value="${packs.packId}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="buttondiv">
				 <button type="button" class="btn btn-primary btn-sm" id="wantModifyBtn" style="width:100px;font-size: 15px;">
				 <span class="glyphicon glyphicon-wrench" style="font-size: 15px;"></span>modify</button>
			</div>
		</div>

		<div id="packListdiv2">
			<div id="placesOfPackListdiv">
					<c:forEach items="${places}" var="places">
							
								<div class="placeInfodiv">
								<div id="placeRemovediv">
								
								</div>
									<div id="placeImgdiv">
									
										<form class="deletePlaceOfPackForm" style="position:absolute; text-align:right; z-index:5;">
										<label class="submitLabel" style="z-index: 5;"> <span
										class="glyphicon glyphicon-remove"
										style="font-size: 20px; cursor: pointer;display: inline;"></span> <input
										type="hidden" class="placeId" name="placeId"
										value="${places.placeId}" /> <input type="hidden"
										class="packId" name="packId" value="${packId}" /> <input
										type="submit" style="display: none" />
										</label>
										</form>
										
										<img src="/image?imageName=${places.placeImageList[0].imageName}" class="placeImg"/>
								
								</div>
									<div id="placeNamediv">
										<a href="/detailPlace?placeId=${ places.placeId }">
											<p id="placetitle" style="display: inline; cursor: pointer; color:black;">
											${places.placeName}
											</p>
										</a>
									</div>
								<input type="hidden" class="placeId"
								name="placeId" value="${places.placeId}" />
								
								</div>
					</c:forEach>
			
			</div>
		</div>
	</div>
</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>