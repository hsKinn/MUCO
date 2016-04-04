<!-- 김동규 -->

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

<!-- Recommend Place -->
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#recommendPlaceMenu").mouseout(function() {
			$("#recommendPlaceMenu").css("color", "#ffffff");
		});
		
		$("#recommendPlaceMenu").css("color", "#ffffff");
		
		$("#initBtn").click(function() {
			location.href = "<c:url value="/placeInfoInit" />";
		});

		$("#searchBtn").click(function() {
			if ($("#searchPlaceKeyword").val() == "") {
				alert("검색어 입력");
				return;
			}
			movePage('0');
		});

		$("#searchPlaceKeyword").keyup(function(e) {
			if (e.keyCode == 13) {
				$("#searchBtn").click();
			}
		});
	});
</script>
<c:set var="loginEmail" value="${ sessionScope._MEMBER_.email }" />

<section class="bg-primary">
	<div class="container">
	
				<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">RECOMMEND PLACE</h2>
			<hr class="primary">
			<p>추천 Place를 확인하세요</p>
		</div>
	
		<div id="recommendPlace_Wrapper">
			<div id="inner_wrapper">
				<div id="daily_wrapper">
					<div id="daily_top">
						Daily Top Place
					</div>
					
					<div id="daily_content">
						<c:forEach items="${ recommendPlaceList.dailyList }" var="daily" >
							<div class="content">
								<div class="content_top">
									<img src="/resource/img/pack/basic$1.jpg" class="img-thumbnail" />
								</div>					
								<div class="content_middle">
									${ daily.placeName }
								</div>
								<div class="content_bottom">
									<div class="bottom_top">
										 일일 추천수 : ${ daily.avgLikeCount }	
									</div>
									<div class="bottom_first">
										<span class="badge">View: ${ daily.viewCount }</span>
									</div>
									<div class="bottom_second">
										<span class="glyphicon glyphicon-heart"></span>
										<span id="likeCount">${ daily.likeCount }</span>
									</div>
								</div>
							</div>
						</c:forEach>			
					</div>
				</div>
				
				<div id="weekly_wrapper">
					<div id="weekly_top">
						Weekly Top Place
					</div>
		
					<div id="weekly_content">
						<c:forEach items="${ recommendPlaceList.weeklyList }" var="weekly" >
							<div class="content">
								<div class="content_top">
									<img src="/resource/img/pack/basic$1.jpg" class="img-thumbnail" />
								</div>					
								<div class="content_middle">
									${ weekly.placeName }
								</div>
								<div class="content_bottom">
									<div class="bottom_top">
										 주간 추천수 : ${ weekly.avgLikeCount }	
									</div>
									<div class="bottom_first">
										<span class="badge">View: ${ weekly.viewCount }</span>
									</div>
									<div class="bottom_second">
										<span class="glyphicon glyphicon-heart"></span>
										<span id="likeCount">${ weekly.likeCount }</span>
									</div>
								</div>
							</div>
						</c:forEach>				
					</div>
				</div>
				
				<div id="monthly_wrapper">
					<div id="monthly_top">
						Monthly Top Place
					</div>
		
					<div id="monthly_content">
						<c:forEach items="${ recommendPlaceList.monthlyList }" var="monthly" >
							<div class="content">
								<div class="content_top">
									<img src="/resource/img/pack/basic$1.jpg" class="img-thumbnail" />
								</div>					
								<div class="content_middle">
									${ monthly.placeName }
								</div>
								<div class="content_bottom">
									<div class="bottom_top">
										 월간 추천수 : ${ monthly.avgLikeCount }		
									</div>
									<div class="bottom_first">
										<span class="badge">View: ${ monthly.viewCount }</span>
									</div>
									<div class="bottom_second">
										<span class="glyphicon glyphicon-heart"></span>
										<span id="likeCount">${ monthly.likeCount }</span>
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
						<input type="text" id="searchPlaceKeyword" name="searchPlaceKeyword" value="${ placeSearchVO.searchKeyword }" placeholder="  # Search" />
						<button type="button" class="btn btn-info" id="searchBtn">
							<span class="glyphicon glyphicon-search"></span>검색
						</button>
						<button type="button" class="btn btn-info" id="initBtn">
							<span class="glyphicon glyphicon-repeat"></span>초기화
						</button>
					</div>
					<div id="top_sort">
								<div class="dropdown">
						 			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Sort By
						  				<span class="caret"></span>
						  			</button>
						 			<ul class="dropdown-menu">
									    <li><a href="/recommendPlace?sortOption=1">추천 순<span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
									    <li><a href="/recommendPlace?sortOption=2">조회 순<span class="glyphicon glyphicon-sort-by-attributes-alt"></span></a></li>
									    <li><a href="/recommendPlace?sortOption=3">등록 순<span class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
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
					<div id="paging">
						${ placeList.paging.getPagingList("pageNo", "[@]", "[이전]", "[다음]", "searchForm2") }
					</div>
				</form>
			</div>
				
				<div id="inner_wrapper2">
					<div id="new_wrapper">
						<div id="new_top">
							<div id="top_name">New Place</div>
						</div>
		
						<div id="new_content">
							<c:forEach items="${ placeList.placeList }" var="place">
								<div class="new_contents">
									<div class="content_top">
										<img src="${ place.imageLocation }" />
									</div>					
									<div class="content_middle">
										<span class="header" data-toggle="modal" data-target="#${ place.placeId }">
											${ place.placeName }
										</span>
									</div>
									<div class="content_bottom">
										<div class="bottom_top">
											<!-- 중간 내용 -->
										</div>
										<div class="bottom_first">
											<span class="badge">View: ${ place.viewCount }</span>
										</div>
										<div class="bottom_second">
											<span class="glyphicon glyphicon-heart"></span>
											<span id="likeCount">${ place.likeCount }</span>
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
													${ place.placeName }
													<span class="badge">View: ${ place.viewCount }</span>
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
															<tr>
																<td>${ places.placeName }</td>
																<th>${ places.address }</th>
																<td>${ places.viewCount }</td>
															</tr>
												</table>
											</div>
											
											<!-- Modal Footer -->
											<div class="modal-footer">
											
												<!-- Modal Like -->
												<div class="modal-like">
													<c:choose>
														<c:when test="${ place.isExistPlaceLike() }">
															<span class="${place.placeId}placeLike">
																Like ♥
															</span>
														</c:when>
														<c:otherwise>
															<span class="${place.placeId}placeLike" >
																Not Like ♡
															</span>
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
																	<td class="reply_content">
																		<textarea class="${place.placeId}description" name="description" placeholder="댓글을 달아보세요"></textarea>
																	</td>
																	<td class="reply_btn">
																		<button type="button" class="btn btn-info"
																			id="${place.placeId}writeReplyBtn">
																			<span class="glyphicon glyphicon-pencil"></span>댓글 등록
																		</button>
																	</td>
																</tr>
															</table>
																<input type="hidden" class="placeId" name="placeId" value="${ place.placeId }" /> 
																<input type="hidden" class="depth" name="depth" value="0" /> 
																<input type="hidden" class="parentReplyId" name="parentReplyId" value="0" /> 
																<input type="hidden" class="groupId" name="groupId" value="0" /> <input type="hidden"
																class="orderNo" name="orderNo" value="0" /> 
																<input type="hidden" class="placeReplyId" name="placeReplyId" value="0" />
														</form>
													</div>
			
													<div class="replybyplace">
														<c:forEach items="${ place.placeReplyList }" var="reply">
															<div>
																<table>
																	<tr>
																		<td class="replybyplaceWriterName">${ reply.name }</td>
																		<td class="replybyplaceWrittenReply">${ reply.placeReplyDescription }</td>
																	<c:if test="${ reply.email eq loginEmail }">
																		<td class="deleteReplybyplace">
																	        <a href="/deletePlaceReply?placeReplyId=${ reply.placeReplyId }">
																	          <span class="glyphicon glyphicon-remove"></span>
																	        </a>
																		</td>
																	</c:if>
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
								
										$.post(
												"/placeLike"
												, { "placeId" : "${place.placeId}" }
												, function(data) {
								
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
										$.post(
												"/viewCountRecommendPlace"
												, { "placeId" : "${place.placeId}" }
												, function() {
												}
										);
									});
								</script>
		
						</c:forEach>		
						
						<c:if test="${ placeList.paging.totalArticleCount == 0 }">
						<div class="notFoundPack">
							<h3><span class="blue">${placeSearch.searchKeyword}</span>로 검색된 여행지가 존재하지 않습니다<br/><span class="red">초기화</span> 후 재 검색해주세요</h3>
						</div>
						</c:if>	
		
						</div>
					</div>
				</div>
			</div>
	</div>
</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>