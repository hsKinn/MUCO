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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resource/css/place/placeListDetail.css"/>" />

<script type="text/javascript"></script>
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

				<form id="placeEditForm" method="post" action="/doPlaceEdit">
					<input type="hidden" id="placeId" name="placeId" value="${placeDetail.placeId}"/>
					<!-- 회원 버튼 -->
					<div id="buttonCollection">
						<input type="submit" class="btn btn-default" value="save" />
					</div>

					<div id="detailWrapper">
						<table id="detailTable">
							<tr>
								<th>여행지ID</th>
								<th>여행지명</th>
								<th>주소</th>
								<th>조회수</th>
								<th>추천수</th>
								<th>최초등록자 이름</th>
								<th>도시ID</th>
							</tr>

							<tr>
								<td>${placeDetail.placeId}</td>
								<td>
									<input name="placeNameInputBox" id="placeNameInputBox" type="text" value="${placeDetail.placeName}"></input>
								</td>
								<td>${placeDetail.address}</td>
								<td>${placeDetail.viewCount}</td>
								<td>${placeDetail.likeCount}</td>
								<td>${registerMember.email}</td>
								<td>${placeDetail.countryId}</td>
							</tr>

							<tr>
								<th colspan="7">여행지 Google 좌표</th>
							</tr>

							<tr>
								<td colspan="7"><b>LATITUDE</b> : ${placeDetail.latitude}<br />
									<b>LONGITUDE</b> : ${placeDetail.longitude}</td>
							</tr>

							<tr>
								<th colspan="7">여행지 설명</th>
							</tr>

							<tr>
								<td id="articleDescript" colspan="7">
									<input name="placeDescriptionInputBox" id="placeDescriptionInputBox" type="text" value="${placeDetail.description}"></input>
								</td>
							</tr>

							<tr>
								<th colspan="7">여행지 이미지
								<a
									href="<c:url value="/placeEdit?placeId=${placeDetail.placeId}" />">
									<button type="button" class="btn btn-default">사진 삭제</button>
								</a>
							</th>
			
							</tr>

							<tr>
								<td colspan="7">여행지 이미지 넣기! here!</td>
							</tr>

							<tr>
								<th colspan="7">여행지 평균 Mood</th>
							</tr>

						</table>
						<!-- /#detailTable -->
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
