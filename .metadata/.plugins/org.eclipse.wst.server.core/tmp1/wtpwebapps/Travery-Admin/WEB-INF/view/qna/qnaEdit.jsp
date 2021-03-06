<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/common/test.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/originPlaceList.css"/>" />

<script type="text/javascript">
	/* 내용 script */
	$(document).ready(function() {

		$("#massiveSelectCheckBox").click(function() {
			var isChecked = $(this).prop("checked");
			//일괄체크 되도록 하는 것 
			$(".deletePackId").prop("checked", isChecked);
		});

		$("#massiveDeleteBtn").click(function() {
			var isChecked = false;

			$(".deletePackId").each(function(index, data) {
				if (data.checked) {
					isChecked = data.checked;
				}

			});

			// 삭제할 대상을 정하지 않았으면 alert뜨기 
			if (!isChecked) {
				alert("삭제할 대상을 선택하세요");
			}

			// 사용자의 confirm 받기 
			if (confirm("정말 삭제하시겠습니까?")) {
				// 지우는 로직 넣기 
				var form = $("#massiveDeleteForm");
				form.attr("method", "post");
				form.attr("action", "<c:url value="/packMassiveDelete" />");
				form.submit();
			}

		});
	});
</script>
<body>

	<div id="wrapper">
		<div class="overlay"></div>

		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/view/common/sidebar.jsp"></jsp:include>

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>

			<!-- Origin Place Contents -->
			<div class="container">
				<form id="qnaEditForm" method="post" action="/qnaDoEdit">
					<input type="hidden" id="qnaId" name="qnaId" value="${QNA.qnaId }"/>
					<!-- place 관리 버튼 -->
					<div id="buttonCollection">
						<input type="submit" class="btn btn-default" value="save" />
					</div>

					<div id="listWrapper">
						<!-- 게시글 보여주는 list table -->
						<table id="tableList">
							<tr>
								<th>QnA ID</th>
								<th>제목</th>
								<th>질문자EMAIL</th>
								<th>질문날짜</th>
								<th style="color: yellow;">답변 여부</th>
								<th style="color: yellow;">FAQ 여부</th>
							</tr>

							<tr>
								<td>${QNA.qnaId}</td>
								<td>${QNA.title}</td>
								<td>${QNA.email}</td>
								<td>${QNA.qndDate}</td>
								<td>${QNA.isAnswer}</td>
								<td>${QNA.isFaq}</td>
							</tr>

							<tr>
								<th colspan="6" style="vertical-align: middle;">질문 내용</th>
							</tr>
							<tr>
								<td colspan="6" style="vertical-align: middle;">${QNA.description}</td>
							</tr>

							<tr>
								<th colspan="6" style="vertical-align: middle;">답변 내용</th>
							</tr>
							<tr>
								<td colspan="6"><input id="qnaAnswerSheet"
									name="qnaAnswerSheet" value="${QNA.answerDescription}"
									style="margin: 4px; height: 60px; width: 80%; background-color: #333333; color: #ffffff;"
									type="text" /></td>
							</tr>
						</table>
						<!-- /#tableList -->
					</div>
					<!-- /#listWrapper -->

				</form>
			</div>
			<!-- /#Origin Place Contents -->

		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
