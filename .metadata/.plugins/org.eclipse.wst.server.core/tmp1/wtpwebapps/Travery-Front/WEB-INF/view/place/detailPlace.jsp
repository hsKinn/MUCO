<!-- 김현섭 -->

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
	
<link rel="stylesheet" type="text/css"   href="<c:url value="/resource/css/place/detailPlace.css"/>" />

<!-- Share Package -->
<script type="text/javascript">
	$(document).ready(function() {
	
		$("#writePlaceReplyBtn").click( function() {
			
			var description = $("#description").val();
			description = $.trim(description);
			if ( description == "" ) {
				alert("댓글을 입력해주세요");
				$("#description").focus();
				return;
			}
			
			var form = $("#writePlaceReplyForm");
			
			form.attr("method", "POST");
			form.attr("action", "<c:url value="/doWritePlaceReply"/>");
			form.submit();
		});
		
		$(".placeLike").click( function() {
			
			$.post(
					"/placeLike"
					, { "placeId" : "${place.placeId}" } 
					, function(data) {
						
						var jsonData4 = {};
						
						try {
							jsonData4 = JSON.parse(data);
						}
						catch(e) {
							jsonData4.result = false;							
						}
						
						if ( jsonData4.result) {
							// 하트를 넣음
							var text = $(".placeLike").text();
							if ( jsonData4.isplaceLike ) {
								$(".placeLike").text("Like ♥");							
							}
							else {
								$(".placeLike").text("Not Like ♡");	
							}
						}
						else {
							alert("세션 만료");
							location.href = "/";
						}
					}
			  );
		});
		
	});
</script>

<c:set var="loginEmail" value="${ sessionScope._MEMBER_.email }" />

<!-- Detail Place Content by hskim -->
<section class="bg-primary" id="one">
	<div class="container">

		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">Detail Place Page</h2>
			<hr class="primary">
			<p>Place의 상세 정보를 확인하세요</p>
		</div>
		
		<div id="detail-Wrapper">
			
			<div id="detail-LeftWrapper">
				
				<div id="photo-Top">
					대표 이미지
					<img src="#" />
				</div>
				
				<div id="photo-Bottom">
					<c:forEach var="i" begin="1" end="12">
						<div class="photos">
							<img src="#" />
						</div>
					</c:forEach>
				</div>
				
				
			</div>
			
			<div id="detail-RightWrapper">
				<div id="info-Top">
					<div id="place-Title">
						${ place.countryName }, ${ place.placeName } 
					</div>
					<div id="place-LikeCount">
						<span class="glyphicon glyphicon-heart"></span>
						<span id="placeLikeCount">${ place.likeCount }</span>
					</div>
				</div>
				
				<div id="info-Middle">
					<div id="place-Description">
						<textarea readonly="readonly">${ place.placeDescription }</textarea>
					</div>
				</div>
				
				<div id="info-Vote">
					<div id="vote-Left">
						<c:choose>
							<c:when test="${ place.isExistPlaceLike() }">
								<span class="placeLike">
									Like ♥
								</span>
							</c:when>
							<c:otherwise>
								<span class="placeLike" >
									Not Like ♡
								</span>
							</c:otherwise>
						</c:choose>
					</div>
				
					<div id="vote-Right">
						Do Vote
					</div>
					<div id="placeVote">
						<table>
							<tr>
								<td>Bright</td>
								<td>
									<input type="range" readonly="readonly" min="1" max="100" value="${ place.avgBrightDarkScore }">
								</td>
								<td>Dark</td>
							</tr>
							<tr>
								<td>HightPrice</td>
								<td>
									<input type="range" readonly="readonly" min="1" max="100" value="${ place.avgHighPriceLowPriceScore }">
								</td>
								<td>LowPrice</td>
							</tr>
							<tr>
								<td>Active</td>
								<td>
									<input type="range" readonly="readonly" min="1" max="100" value="${ place.avgActiveCalmScore }">
								</td>
								<td>Calm</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div id="info-Bottom">
		          	<div id="place-Reply">
						<div id="placeReplyWrapper">
							<form id="writePlaceReplyForm">
								<table id="placeReply_table">
									<tr>
										<td id="placeReply_content">
											<textarea id="description" name="description" placeholder="Write Reply"></textarea>
										</td>
										<td id="placeReply_btn">
											<button type="button" class="btn btn-info" id="writePlaceReplyBtn">
									     		<span class="glyphicon glyphicon-pencil"></span>submit
									   		</button>  													
										</td>
									</tr>
								</table>
								<input type="hidden" class="placeId" name="placeId" value="${ place.placeId }" />
								<input type="hidden" class="depth" name="depth" value="0" />
								<input type="hidden" class="parentReplyId" name="parentReplyId" value="0" />
								<input type="hidden" class="groupId" name="groupId" value="0" />
								<input type="hidden" class="orderNo" name="orderNo" value="0" />
								<input type="hidden" class="placeReplyId" name="placeReplyId" value="0" />
							</form>
						</div>
						
						<div id="replybyPlace">
							<c:forEach items="${ place.placeReplyList }" var="reply">
								<div>
								<table>
									<tr id="placeReplyTR">
										<td id="placeReplyWriterName">${ reply.name }</td>
										<td id="placeReplyWrittenReply">
											${ reply.placeReplyDescription }
										</td>
										<c:if test="${ reply.email eq loginEmail }">
											<td id="deletePlaceReply">
										        <a href="/deletePlaceReply?placeReplyId=${ reply.placeReplyId }&placeId=${ place.placeId }">
										          <span class="glyphicon glyphicon-remove"></span>
										        </a>
											</td>
										</c:if>
									</tr>
								</table>
								<div id="hide formAppender"></div>
								</div>
							</c:forEach>
						</div>	
		          	</div>		
				</div>
				
			</div>
			
		
		</div>

	</div>
</section>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>

