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

	});
</script>

<body>
	<div id="mypackWrapperdiv">
		<div id="mypackListdiv">
			<table id="packListTable" border="2">
				<form id="massiveDeleteForm">
					<c:forEach items="${ packs}" var="packs">
						<tr>
							<td class="pack"><img
								src="<c:url value="/resource/img/pack/folder.png"/>"
								id="folderImg" /> <input type="checkbox" class="deletePackId"
								name="deletePackId" value="${packs.packId }" /> <label
								id="title" for="packData_Title"
								style="font-size: 20px; display: inline;">${packs.packTitle}</label>
								<input type="hidden" id="packId" value="${packs.packId}" /></td>
						</tr>
					</c:forEach>
				</form>
			</table>
		</div>
		<div id="buttondiv">
			<button type="submit" class="btn btn-danger">DeletePackage</button>
		</div>
	</div>

	<div id="mypackListdiv">
		<div id="placesOfPackListdiv"></div>
	</div>
</body>


<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>