<!-- 김동규 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<!-- Recommend Place -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#recommendPlaceMenu").mouseout(function() {
			$("#recommendPlaceMenu").css("color", "#ffffff");
		});
		$("#recommendPlaceMenu").css("color", "#ffffff");
	});
</script>

<script type="text/javascript">
	$("#initBtn").click(function() {
		location.href = "<c:url value="/placeInfoInit" />";
	});

	$("#searchBtn").click(function() {
		if ($("#searchKeyword").val() == "") {
			alert("검색어 입력");
			return;
		}
		movePage('0');
	});

	$("#searchKeyword").keyup(function(e) {
		if (e.keyCode == 13) {
			$("#searchBtn").click();
		}
	});
</script>
<!-- Reply/like/ -->
<script type="text/javascript">
	$("#${place.placeId}writeReplyBtn").click(function() {

		var description = $(".${place.placeId}description").val();
		description = $.trim(description);
		if (description == "") {
			alert("댓글을 입력해주세요");
			$(".${place.placeId}description").focus();
			return;
		}

		var form = $(".${place.placeId}writeReplyForm");

		form.attr("method", "POST");
		form.attr("action", "<c:url value="/doWritePlaceReply"/>");
		form.submit();
	});

	$(".${place.placeId}placeLike").click(function() {

		$.post("/placeLike", {
			"placeId" : "${place.placeId}"
		}, function(data) {

			var jsonData3 = {};

			try {
				jsonData3 = JSON.parse(data);
			} catch (e) {
				jsonData3.result = false;
			}

			if (jsonData3.result) {
				// 하트를 넣음
				var text = $(".${place.placeId}placeLike").text();
				if (jsonData3.isplaceLike) {
					$(".${place.placeId}placeLike").text("Like ♥");
				} else {
					$(".${place.placeId}placeLike").text("Not Like ♡");
				}
			} else {
				alert("세션 만료");
				location.href = "/";
			}
		});
	});

	$(".header").click(function() {
		$.post("/viewCountRecommendPlace", {
			"placeId" : "${place.placeId}"
		}, function() {
		});
	});
</script>


<div id="recommendPlace_Wrapper">
	<div id="inner_wrapper">
		<div id="daily_wrapper">
			<div id="daily_top">Daily</div>

			<div id="daily_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg"
								class="img-thumbnail" />
						</div>
						<div class="content_middle">일일 여행지 Title</div>
						<div class="content_bottom">
							<div class="bottom_top">Writer</div>
							<div class="bottom_first">
								<span class="badge">View: ${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span> <span
									id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<div id="weekly_wrapper">
			<div id="weekly_top">Weekly</div>

			<div id="weekly_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg"
								class="img-thumbnail" />
						</div>
						<div class="content_middle">주간 여행지 Title</div>
						<div class="content_bottom">
							<div class="bottom_top">Writer</div>
							<div class="bottom_first">
								<span class="badge">View: ${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span> <span
									id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<div id="monthly_wrapper">
			<div id="monthly_top">Monthly</div>

			<div id="monthly_content">
				<c:forEach var="i" begin="1" end="4">
					<div class="content">
						<div class="content_top">
							<img src="/resource/img/pack/basic${ i }.jpg"
								class="img-thumbnail" />
						</div>
						<div class="content_middle">월간 여행지 Title</div>
						<div class="content_bottom">
							<div class="bottom_top">Writer</div>
							<div class="bottom_first">
								<span class="badge">View: ${ i*21 }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span> <span
									id="likeCount">${ i*4 }</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<div id="middle">

		<form id="searchForm2">
			<div id="search_part">
				<input type="text" id="searchKeyword" placeholder="  # Search" />
				<button type="button" class="btn btn-info" id="searchBtn">
					<span class="glyphicon glyphicon-search"></span>검색
				</button>
				<button type="button" class="btn btn-info" id="initBtn">
					<span class="glyphicon glyphicon-repeat"></span>초기화
				</button>
			</div>

			<div id="sortBox">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort By <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="/recommendPlace?sortOption=1">추천 순<span
								class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
						<li><a href="/recommendPlace?sortOption=2">조회 순<span
								class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
						<li><a href="/recommendPlace?sortOption=3">등록 순<span
								class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
					</ul>
				</div>
			</div>
			<div id="write_part">
				<a href="/placeInfoControl" id="placeInfoControl">
					<button type="button" class="btn btn-info" id="writeBtn">
						<span class="glyphicon glyphicon-pencil"></span>등록하기
					</button>
				</a>
			</div>
			<div id="paging">${ placeList.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm2") }</div>
		</form>
	</div>

	<div id="inner_wrapper2">
		<div id="new_wrapper">
			<div id="new_top">
				<div id="top_name">New</div>
				<div id="top_sort">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort By <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">추천 순<span
									class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
							<li><a href="#">조회 순<span
									class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
							<li><a href="#">등록 순<span
									class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
						</ul>
					</div>
				</div>
			</div>

			<div id="new_content">
				<c:forEach items="${ placeList.placeList }" var="place">
					<div class="new_contents">
						<div class="content_top">
							<img src="${ place.imageLocation }" class="img-rounded" />
						</div>
						<div class="content_middle">
							<span class="header" data-toggle="modal"
								data-target="#${ place.placeId }"> ${ place.placeName } </span>
						</div>

						<div class="content_bottom">
							<div class="bottom_top">${ place.name }</div>
							<div class="bottom_first">
								<span class="badge">View: ${ place.viewCount }</span>
							</div>
							<div class="bottom_second">
								<span class="glyphicon glyphicon-heart"></span> <span
									id="likeCount">${ place.likeCount }</span>
							</div>
						</div>
					</div>


					<!-- Modal -->
					<div class="modal fade" id="${ place.placeId }" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">
										${ place.placeName } <span class="badge">view: ${ place.viewCount }</span>
									</h4>
								</div>
								<!-- Modal Body -->
								<div class="modal-body">
									<table class="table table-hover table-bordered table-condensed">
										<thead>
											<tr>
												<td width="130px">여행지 명</td>
												<td>주소</td>
												<td width="80px">추천수</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${ place.placeList }" var="places">
												<tr>
													<td>${ places.placeName }</td>
													<th>${ places.address }</th>
													<td>${ places.viewCount }</td>
												</tr>
											</c:forEach>
									</table>
								</div>
								<!-- Modal Footer -->
								<div class="modal-footer">
									<!-- Modal Like -->
									<div class="modal-like">
										<c:choose>
											<c:when test="${ place.isExistPlaceLike() }">
												<span class="${place.placeId}placeLike"
													data-placeId='${ place.placeId }'>Like ♥</span>
											</c:when>
											<c:otherwise>
												<span class="${place.placeId}placeLike"
													data-placeId='${ place.placeId }'>Not Like ♡</span>
											</c:otherwise>
										</c:choose>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
									<!-- place Reply -->
									<div class="place-reply">
										<div class="formWrapper">
											<form class="${place.placeId}writeReplyForm">
												<table class="reply_table">
													<tr>
														<td class="reply_content"><textarea
																class="${place.placeId}description" name="description"
																placeholder="댓글을 달아보세요"></textarea></td>
														<td class="reply_btn">
															<button type="button" class="btn btn-info"
																id="${place.placeId}writeReplyBtn">
																<span class="glyphicon glyphicon-pencil"></span>댓글 등록
															</button>
														</td>
													</tr>
												</table>
												<input type="hidden" class="placeId" name="placeId"
													value="${ place.placeId }" /> <input type="hidden"
													class="depth" name="depth" value="0" /> <input
													type="hidden" class="parentReplyId" name="parentReplyId"
													value="0" /> <input type="hidden" class="groupId"
													name="groupId" value="0" /> <input type="hidden"
													class="orderNo" name="orderNo" value="0" /> <input
													type="hidden" class="placeReplyId" name="placeReplyId"
													value="0" />
											</form>
										</div>

										<div class="replybyplace">
											<c:forEach items="${ place.placeReplyList }" var="reply">
												<div>
													<table>
														<tr>
															<td class="reply-name">${ reply.name }</td>
															<td>${ reply.placeReplyDescription }</td>
														</tr>
													</table>
													<div class="hide formAppender"></div>
												</div>
											</c:forEach>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${ placeList.paging.totalArticleCount == 0 }">
					<div id="notFoundplace">
						<h3>
							<span id="blue">#${placeSearchVO.searchKeyword}</span>로 검색된 내용이 
							존재하지 않습니다.<br /> <span id="red">초기화</span> 후 재 검색해주세요.
						</h3>

					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>





<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>