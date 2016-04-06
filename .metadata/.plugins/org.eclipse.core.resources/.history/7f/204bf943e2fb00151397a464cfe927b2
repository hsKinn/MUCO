<!-- 백지경 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- My Package -->
<script type="text/javascript">
	$(document).ready(function() {

		$("#myPackMenu").mouseout(function() {
			$("#myPackMenu").css("color", "#ffffff");
		});
		$("#myPackMenu").css("color", "#ffffff");

		$(".btn-danger").click(function() {
			var isChecked = false;

			$(".deletePackId").each(function(index, data) {

				if (data.checked) {
					isChecked = data.checked
				}
			});

			if (!isChecked) {
				alert("삭제할 대상을 선택하세요");
				return;
			}
			if (confirm("정말 삭제하시겠습니까?")) {
				var form = $("#massiveDeleteForm");
				form.attr("method", "POST");
				form.attr("action", "<c:url value="/doDeletePack"/>");
				form.submit();
			}
		});
				
				$(".btn-primary").click(function(){
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

		<div id="mypackWrapperdiv">
			<div id="mypackListdiv">
				<table id="packListTable">
					<form id="massiveDeleteForm">
						<c:forEach items="${ packs}" var="packs">
							<tr>
								<td class="pack">
								<input type="checkbox" class="deletePackId"
									name="deletePackId" value="${packs.packId }" />
								<p id="title">${packs.packTitle}</p>
								</td>
							</tr>
						</c:forEach>
					</form>
				</table>
			</div>
			<div id="buttondiv">
				 <button type="button" class="btn btn-danger btn-sm"style="width:120px;font-size: 15px;">
         		 <span class="glyphicon glyphicon-remove" style="font-size: 15px;"></span> Remove</button>
				 <button type="button" class="btn btn-primary btn-sm"style="width:120px;font-size: 15px;">
				 <span class="glyphicon glyphicon-ok" style="font-size: 15px;"></span>Okay</button>
			</div>
		</div>
</section>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>