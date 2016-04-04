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

<script
	src="<c:url value="/resource/js/jquery-jvectormap-world-mill-en.js" />"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

						trigger.click(function() {
							hamburger_cross();
						});

						function hamburger_cross() {

							if (isClosed == true) {
								overlay.hide();
								trigger.removeClass('is-open');
								trigger.addClass('is-closed');
								isClosed = false;
							} else {
								overlay.show();
								trigger.removeClass('is-closed');
								trigger.addClass('is-open');
								isClosed = true;
							}
						}

						$('[data-toggle="offcanvas"]').click(function() {
							$('#wrapper').toggleClass('toggled');
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


				<!-- 총 회원 수 보여주기  -->
				총 <b style="color: red">${places.paging.totalArticleCount}</b> 있습니다.

				<!-- 회원 버튼 -->
				<div id="buttonCollection">
					<span id="massiveDeleteBtn" style="cursor: pointer">
						<button type="button" class="btn btn-default">Delete</button>
					</span> 
				</div>

				<div id="memberListWrapper">
					<!-- 게시글 보여주는 list table -->
					<table id="tableList">
						<tr>
							<th><input type="checkbox" id="massiveSelectCheckBox" /></th>
							<th>여행지ID</th>
							<th>여행지명</th>
							<th>주소</th>
							<th>조회수</th>
							<th>추천수</th>
							<th>설명</th>
							<th>최초등록자 이름</th>
							<th>도시ID</th>
						</tr>

						<form id="massiveDeleteForm">
							<c:forEach items="${places.placeList}" var="place">
								<tr>
									<td><input type="checkbox" class="deleteMemberId"
										name="deleteMemberId" value="${place.placeId}" /></td>
									<td>${place.placeId}</td>
									<td><a
										href="<c:url value="/placeDetail?placeId=${place.placeId}" />">${place.placeName}</a></td>
									<td><a
										href="<c:url value="/placeDetail?placeId=${place.placeId}" />">${place.address}</a></td>
									<td>${place.viewCount}</td>
									<td>${place.likeCount}</td>
									<td>${place.description}</td>
									<td>최초등록자 이름</td>
									<td>도시ID</td>
								</tr>
							</c:forEach>
						</form>

						<tr>
							<td colspan="9">
								<form id="searchForm">왜 안나와 ${ places.paging.getPagingList("pageNO", "[@]", "[이전]", "[다음]", "searchForm") }
								</form>
							</td>
						</tr>
					</table>
					<!-- /#tableList -->
				</div>
				<!-- /#memberListWrapper -->


			</div>
			<!-- /#Origin Place Contents -->

		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
