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

				<!-- place 관리 버튼 -->
				<div id="buttonCollection">
					<a href="<c:url value="/qnaDelete?qnaId=${QNA.qnaId}" />">
						<button id="placeDeleteBtn" type="button" class="btn btn-default">Delete</button>
					</a>
					<a href="<c:url value="/qnaEdit?qnaId=${QNA.qnaId}" />">
						<button id="placeDeleteBtn" type="button" class="btn btn-default">Edit</button>
					</a>
					
					<a href="<c:url value="/makeAnswer?qnaId=${QNA.qnaId}" />">
						<button id="placeDeleteBtn" type="button" class="btn btn-default" style="float:right;">답변 체크</button>
					</a>
					<a href="<c:url value="/makeFAQ?qnaId=${QNA.qnaId}" />">
						<button id="placeDeleteBtn" type="button" class="btn btn-default" style="float:right;">FAQ 만들기</button>
					</a>
				</div>

				<div id="listWrapper">
					<!-- 게시글 보여주는 list table -->
					<table id="tableList">
						<tr>
							<th>QnA ID</th>
							<th>제목</th>
							<th>질문자EMAIL</th>
							<th>질문날짜</th>
							<th style="color:yellow;">답변 여부</th>
							<th style="color:yellow;">FAQ 여부</th>
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
							<td colspan="6">${QNA.answerDescription}</td>
						</tr>

					</table>
					<!-- /#tableList -->
				</div>
				<!-- /#listWrapper -->


			</div>
			<!-- /#Origin Place Contents -->

		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
